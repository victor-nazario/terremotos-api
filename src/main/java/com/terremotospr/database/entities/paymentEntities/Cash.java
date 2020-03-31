package com.terremotospr.database.entities.paymentEntities;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class Cash extends PaymentMethod {
    private Long amountAvailable;

    public Long getAmountAvailable() { return amountAvailable; }

    public void setAmountAvailable(Long amountAvailable) { this.amountAvailable = amountAvailable; }
}
