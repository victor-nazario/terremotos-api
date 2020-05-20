package com.terremotospr.database.entities.paymentEntities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Entity
@IdClass(PaysId.class)
public class Pays implements Serializable {

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date paymentDate;

    private Double changeAmount;

    public Date getPaymentDate() { return paymentDate; }

    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public Double getChangeAmount() { return changeAmount; }

    public void setChangeAmount(Double changeAmount) { this.changeAmount = changeAmount; }

    //Relationships
    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "payment_id", insertable = false, updatable = false)
    Payment payment;

    @Column(name = "payment_id")
    private Long paymentId;

    public Payment getPayment() { return payment; }

    public void setPayment(Payment payment) { this.payment = payment; }

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    PlacedOrder order;

    @Column(name = "order_id")
    private Long orderId;

    public PlacedOrder getOrder() { return order; }

    public void setOrder(PlacedOrder order) { this.order = order; }

    public Long getOrderId() { return orderId; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }
}