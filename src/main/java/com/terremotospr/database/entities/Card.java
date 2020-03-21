package com.terremotospr.database.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import java.util.Date;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class Card extends PaymentMethod {
    private Long cardNumber;
    @JsonFormat(pattern="yyyy-MM")
    private Date expirationDate;

    public Long getCardNumber() { return cardNumber; }

    public void setCardNumber(Long cardNumber) { this.cardNumber = cardNumber; }

    public Date getExpirationDate() { return expirationDate;}

    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }
}
