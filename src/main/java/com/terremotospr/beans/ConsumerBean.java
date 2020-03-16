package com.terremotospr.beans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
public class ConsumerBean{
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