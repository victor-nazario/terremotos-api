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
    private Long paymentId;

    private Double purchaseTotal;

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentI) { this.paymentId = paymentId; }

    public Double getPurchaseTotal() { return purchaseTotal; }

    public void setPurchaseTotal(Double purchaseTotal) { this.purchaseTotal = purchaseTotal; }


    //Relationship
    @ManyToOne(targetEntity = Consumer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "consumer_id", insertable = false, updatable = false)

    private Consumer consumer;

    @Column(name = "consumer_id")
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
