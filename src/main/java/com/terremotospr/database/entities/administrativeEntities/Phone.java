package com.terremotospr.database.entities.administrativeEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created on March 17, 2020 - 12:31 PM
 *
 * @author Victor Nazario
 */
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phone_id;

    private String phone;

    public Long getPhone_id() { return phone_id; }

    public void setPhone_id(Long phone_id) { this.phone_id = phone_id; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    //Relationship
    @JsonIgnore
    @ManyToOne(targetEntity = Consumer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)

    private Consumer consumer;

    @JsonIgnore
    @Column(name = "id")
    private Long consumerId;

    public Consumer getConsumer(){return consumer;}

    public void setConsumer(Consumer consumer) { this.consumer = consumer; }

    private Long getConsumerId(){return consumerId;}

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId;}
}
