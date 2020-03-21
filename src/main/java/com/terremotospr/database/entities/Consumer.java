package com.terremotospr.database.entities;

import com.terremotospr.beans.ConsumerType;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Entity(name = "Consumer")
public class Consumer{
    @Id
    //should extend UserBean and import Phone and PM
    private ConsumerType type;
//    private Phone phone;
//    private PaymentMethod payment_method;

    public ConsumerType getType() { return type; }

    public void setType(ConsumerType type) { this.type = type; }

//    public Phone getPhone() { return phone; }
//
//    public void setPhone(Phone phone) { this.phone = phone; }
//
//    public PaymentMethod getPayment_method() { return payment_method; }
//
//    public void setPayment_method(PaymentMethod payment_method) { this.payment_method = payment_method; }
}
