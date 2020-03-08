package com.terremotospr.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created on March 7, 2020 - 9:13 PM
 *
 * @author Victor Nazario
 */

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Long uId;


    //public List<String> orderItems;
    public double price;
    //Podría ser un enum de tipos de pago
    public String paymentType;
    public Date orderDate;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getuId() { return uId; }

    public void setuId(Long uId) { this.uId = uId; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getPaymentType() { return paymentType; }

    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

    public Date getOrderDate() { return orderDate; }

    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
}
