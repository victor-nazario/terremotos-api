package com.terremotospr.beans;

/**
 * Created on March 17, 2020 - 12:28 PM
 *
 * @author Victor Nazario
 */
public class PhoneBean{
    private Long id;
    private String phone;
    private String customerIdPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerIdPhone() {
        return customerIdPhone;
    }

    public void setCustomerIdPhone(String customerIdPhone) {
        this.customerIdPhone = customerIdPhone;
    }
}
