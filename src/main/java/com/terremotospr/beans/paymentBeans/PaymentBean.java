package com.terremotospr.beans.paymentBeans;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/19/2020
 */
public class PaymentBean {

    private Long paymentId;
    private Long consumerId;
    private Double amountPaid;

    public Long getPayment_id() { return paymentId; }

    public void setPayment_id(Long payment_id) { this.paymentId = payment_id; }

    public Double getPurchaseTotal() { return amountPaid; }

    public void setPurchaseTotal(Double amountPaid) { this.amountPaid = amountPaid; }

    public Long getConsumerId() { return consumerId; }

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId; }
}
