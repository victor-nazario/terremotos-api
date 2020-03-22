package com.terremotospr.beans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
public class PlacedOrderBean {
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
