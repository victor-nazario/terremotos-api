package com.terremotospr.beans.paymentBeans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.terremotospr.beans.administrativeBeans.BelongsBean;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    private Set<BelongsBean> belongsBeans;

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

    public Set<BelongsBean> getBelongsBeans() { return belongsBeans; }

    public void setBelongsBeans(Set<BelongsBean> belongsBeans) { this.belongsBeans = belongsBeans; }
}
