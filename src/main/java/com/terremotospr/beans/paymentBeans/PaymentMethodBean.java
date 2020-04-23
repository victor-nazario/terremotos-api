package com.terremotospr.beans.paymentBeans;

/**
 * Created on March 15, 2020 - 9:49 PM
 *
 * @author Victor Nazario
 */

public class PaymentMethodBean {

    private Long pm_id;
    private Long consumerId;

    public Long getPM_id() { return pm_id; }

    public void setPM_id(Long pm_id) { this.pm_id = pm_id; }

    public Long getConsumerId() { return consumerId; }

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId; }
}
