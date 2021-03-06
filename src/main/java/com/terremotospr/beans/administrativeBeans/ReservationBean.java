package com.terremotospr.beans.administrativeBeans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
public class ReservationBean {
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @JsonIgnore
    private ConsumerBean consumer;

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

    public ConsumerBean getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerBean consumer) {
        this.consumer = consumer;
    }
}
