package com.terremotospr.beans;

import java.util.Date;

/*
 * @author Wilfredo Aponte Pomales
 */
public class CardBean extends PaymentMethodBean {
    private Long cardNumber;
    private Date expirationDate;

    public Long getCardNumber() { return cardNumber; }

    public void setCardNumber(Long cardNumber) { this.cardNumber = cardNumber; }

    public Date getExpirationDate() { return expirationDate;}

    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }
}
