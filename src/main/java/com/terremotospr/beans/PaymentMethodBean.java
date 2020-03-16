package com.terremotospr.beans;

/**
 * Created on March 15, 2020 - 9:49 PM
 *
 * @author Victor Nazario
 */

public class PaymentMethodBean {

    private Long id;
    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
