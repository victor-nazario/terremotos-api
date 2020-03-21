package com.terremotospr.database.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Entity
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date paymentDate;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getPaymentDate() { return paymentDate; }

    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    //Relationships
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "payment_id", insertable = false, updatable = false)
    Payment payment;

    @Column(name = "payment_id")
    private Long paymentId;

    public Payment getPayment() { return payment; }

    public void setPayment(Payment payment) { this.payment = payment; }

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

//    @ManyToOne(cascade= CascadeType.ALL)
//    @JoinColumn(name = "order_id", insertable = false, updatable = false)
//    Order order;
//
//    @Column(name = "order_id")
//    private Long orderId;
//
//    public Order getOrder() { return order; }
//
//    public void setOrder(Order order) { this.order = order; }
//
//    public Long getOrderId() { return orderId; }
//
//    public void setOrderId(Long orderId) { this.orderId = orderId; }
}
