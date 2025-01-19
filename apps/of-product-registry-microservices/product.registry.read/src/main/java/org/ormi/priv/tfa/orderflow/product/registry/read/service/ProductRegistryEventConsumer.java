package org.ormi.priv.tfa.orderflow.product.registry.read.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.event.ProductRegistryEvent;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.message.ProductRegistryMessage;
import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.error.ProductRegistryError;
import org.ormi.priv.tfa.orderflow.product.registry.read.projection.ProductRegistryProjector;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductRegistryEventConsumer {

  @Inject
  private ProductRegistryProjector projector;

  @Incoming("product-registry-event")
  @Transactional(Transactional.TxType.REQUIRED)
  public void handleEvent(ProductRegistryMessage message) {
    // Project the event
    if (message instanceof ProductRegistryEvent event) {
      projector.handleEvent(event);
    }
    else if (message instanceof ProductRegistryError error) {
      throw new RuntimeException("Error while processing event: " + error.getMessage());
    }
    else {
      throw new RuntimeException("Unknown message type: " + message.getClass().getName());
    }
    // TODO: Sink the event here once or while projection is processed
  }
}
