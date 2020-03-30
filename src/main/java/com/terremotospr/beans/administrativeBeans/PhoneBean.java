package com.terremotospr.beans.administrativeBeans;

/**
 * Created on March 17, 2020 - 12:28 PM
 *
 * @author Victor Nazario
 */
public class PhoneBean{
    private Long phone_id;
    private String phone;
    private Long consumerId;

    public Long getPhone_id() { return phone_id; }

    public void setPhone_id(Long phone_id) { this.phone_id = phone_id; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public Long getConsumerId() { return consumerId; }

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId; }
}
