package org.ormi.priv.tfa.orderflow.product.registry.aggregate.repository.model;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * Entity representing a product registry event.
 */
@MongoEntity(collection = "product_registry_events")
public abstract class ProductRegistryEventEntity {
  private ObjectId id;
  private String eventId;
  private String eventType = getEventType();
  private String aggregateRootId;
  private long version;
  private long timestamp;

  /**
   * Get the event type.
   * 
   * @return the event type
   */
  public ObjectId getId() {
    return id;
  }

  /**
   * Set the event type.
   * 
   * @param id the event type to set
   */
  public void setId(ObjectId id) {
    this.id = id;
  }


  /**
   * Get the event id.
   * 
   * @return the event id
   */
  public String getEventId() {
    return eventId;
  }


  /**
   * Get the event type.
   * 
   * @return the event type
   */
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  
  /**
   * Get the event type.
   * 
   * @return the event type
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  /**
   * Get the aggregate root id.
   * 
   * @return the aggregate root id
   */

  public String getAggregateRootId() {
    return aggregateRootId;
  }

  /**
   * Set the aggregate root id.
   * 
   * @param aggregateRootId the aggregate root id to set
   */
  public void setAggregateRootId(String aggregateRootId) {
    this.aggregateRootId = aggregateRootId;
  }


  /**
   * Get the version.
   * 
   * @return the version
   */
  public long getVersion() {
    return version;
  }

  /**
   * Set the version.
   * 
   * @param version the version to set
   */
  public void setVersion(long version) {
    this.version = version;
  }

  /**
   * Get the timestamp.
   * 
   * @return the timestamp
   */
  public long getTimestamp() {
    return timestamp;
  }

  /**
   * Set the timestamp.
   * 
   * @param timestamp the timestamp to set
   */
  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Get the event type.
   * 
   * @return the event type
   */
  abstract String getEventType();
}
