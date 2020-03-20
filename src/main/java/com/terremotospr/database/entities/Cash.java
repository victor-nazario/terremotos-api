package com.terremotospr.database.entities;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class Cash extends PaypalAccount{
    private Long amountAvailable;

    public Long getAmountAvailable() { return amountAvailable; }

    public void setAmountAvailable(Long amountAvailable) { this.amountAvailable = amountAvailable; }
}