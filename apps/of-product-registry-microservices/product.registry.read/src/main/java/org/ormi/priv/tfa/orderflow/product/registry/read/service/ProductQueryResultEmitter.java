package org.ormi.priv.tfa.orderflow.product.registry.read.service;

import java.util.concurrent.CompletionStage;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.query.ProductRegistryQuery.ProductRegistryQueryResult;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.query.config.ProductRegistryQueryChannelName;

import io.quarkus.logging.Log;
import io.smallrye.reactive.messaging.pulsar.PulsarClientService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProductQueryResultEmitter {

  /**
   * The Pulsar client service.
   */
  @Inject
  private PulsarClientService pulsarClients;


  // Custom exception for message sending failure
  public static class MessageSendException extends RuntimeException {
    public MessageSendException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  // Custom exception for producer closing failure
  public static class ProducerCloseException extends RuntimeException {
    public ProducerCloseException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  // Custom exception for producer creation failure
  public static class ProducerCreationException extends RuntimeException {
    public ProducerCreationException(String message, Throwable cause) {
      super(message, cause);
    }
  }
  

  /**
   * Sink the result.
   * 
   * @param correlationId - the correlation id
   * @param result        - the result
   */
  public void sink(String correlationId, ProductRegistryQueryResult result) {
    // Get the producer for the correlation id
    getResultProducerByCorrelationId(correlationId,
        ProductRegistryQueryResult.class)
        .thenAccept((producer) -> {
          // Sink the result
          producer
              .newMessage()
              .value(result)
              .sendAsync()
              .whenComplete((msgId, ex) -> {
                if (ex != null) {
                  throw new MessageSendException("Failed to send message", ex);
                  }
                

                Log.debug(String.format("Sinked result with correlation id{%s}", correlationId));
                try {
                  producer.flush();
                  producer.close();
                } catch (PulsarClientException e) {
                  throw new ProducerCloseException("Failed to close producer", e);
                }
              });
        });
  }


  /**
   * Get the producer for the correlation id.
   * 
   * @param <T>           - the type of the result
   * @param correlationId - the correlation id
   * @param resultType    - the type of the result
   * @return the producer
   */
  private <T> CompletionStage<Producer<T>> getResultProducerByCorrelationId(String correlationId, Class<T> resultType) {
    // Define the channel name, topic and schema definition
    final String channelName = ProductRegistryQueryChannelName.PRODUCT_REGISTRY_READ_RESULT.toString();
    final String topic = channelName + "-" + correlationId;
    // Create and return the producer
    return pulsarClients.getClient(channelName)
        .newProducer(Schema.JSON(resultType))
        .producerName(topic)
        .topic(topic)
        .createAsync()
        .exceptionally(
            ex -> {
              throw new ProducerCreationException("Failed to create producer for correlation id: " + correlationId, ex);
            });
  }
}
