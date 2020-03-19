package com.terremotospr.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class PaypalAccount extends PaymentMethod {

    private String account;

    public String getAccount() { return account;}

    public void setAccount(String account) { this.account = account;}
}
