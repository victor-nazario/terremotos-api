package com.terremotospr.beans.paymentBeans;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/19/2020
 */
public class PaymentBean {

    private Long payment_id;
    private Long consumerId;
    private Double purchaseTotal;

    public Long getPayment_id() { return payment_id; }

    public void setPayment_id(Long payment_id) { this.payment_id = payment_id; }

    public Double getPurchaseTotal() { return purchaseTotal; }

    public void setPurchaseTotal(Double purchaseTotal) { this.purchaseTotal = purchaseTotal; }

    public Long getConsumerId() { return consumerId; }

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId; }
}
