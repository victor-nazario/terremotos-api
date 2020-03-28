package com.terremotospr.database.entities.paymentEntities;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class PaypalAccount extends PaymentMethod {

    private String account;

    public String getAccount() { return account;}

    public void setAccount(String account) { this.account = account;}
}
