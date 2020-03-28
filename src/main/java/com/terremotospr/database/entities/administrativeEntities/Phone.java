package com.terremotospr.database.entities.administrativeEntities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created on March 17, 2020 - 12:31 PM
 *
 * @author Victor Nazario
 */
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    //Añadir la relación en el parent class
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
