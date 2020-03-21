package com.terremotospr.beans;

import java.util.Date;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
public class PaysBean {
    private Long id;
    private Date paymentDate;
    private Long paymentId;
   // private Long orderId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getPaymentDate() { return paymentDate; }

    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }
}

