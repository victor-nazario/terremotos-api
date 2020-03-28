package com.terremotospr.database.entities.paymentEntities;

import com.terremotospr.database.entities.administrativeEntities.Consumer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/19/2020
 */
@Entity(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    private Double purchaseTotal;

    public Long getPayment_id() { return payment_id; }

    public void setPayment_id(Long payment_id) { this.payment_id = payment_id; }

    public Double getPurchaseTotal() { return purchaseTotal; }

    public void setPurchaseTotal(Double purchaseTotal) { this.purchaseTotal = purchaseTotal; }


    //Relationship
    @ManyToOne(targetEntity = Consumer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)

    private Consumer consumer;

    @Column(name = "id")
    private Long consumerId;

    public Consumer getConsumer(){return consumer;}

    public void setConsumer(Consumer consumer) { this.consumer = consumer; }

    private Long getConsumerId(){return consumerId;}

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId;}



    @OneToMany(targetEntity=Pays.class, mappedBy="payment", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Pays> pays = new HashSet<>();

    public Set<Pays> getPays() { return pays; }

    public void setPays(Set<Pays> pays) { this.pays = pays; }
}
