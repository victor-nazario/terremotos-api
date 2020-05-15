package com.terremotospr.database.entities.paymentEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.terremotospr.database.entities.administrativeEntities.Consumer;

import javax.persistence.*;

/**
 * Created on March 15, 2020 - 9:50 PM
 *
 * @author Victor Nazario
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class
PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pm_id;

    public Long getPM_id() { return pm_id; }

    public void setPM_id(Long pm_id) { this.pm_id = pm_id; }


    //Relationship
    @JsonIgnore
    @ManyToOne(targetEntity = Consumer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Consumer consumer;

    @Column(name = "id")
    private Long consumerId;

    public Consumer getConsumer(){return consumer;}

    public void setConsumer(Consumer consumer) { this.consumer = consumer; }

    private Long getConsumerId(){return consumerId;}

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId;}
}
