package com.terremotospr.database.entities;

import javax.persistence.*;

/**
 * Created on March 15, 2020 - 9:50 PM
 *
 * @author Victor Nazario
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
