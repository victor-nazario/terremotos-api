package com.terremotospr.database.entities.administrativeEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.terremotospr.database.entities.paymentEntities.Payment;
import com.terremotospr.database.entities.paymentEntities.PaymentMethod;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */


@Entity(name = "Consumer")
public class Consumer extends User{

    private String type;

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    @JsonIgnore
    @OneToMany(targetEntity= Payment.class, mappedBy = "consumer", orphanRemoval=true)
    private Set<Payment> payments = new HashSet<>();

    public Set<Payment> getPayments() { return payments; }

    public void setPayments(Set<Payment> payments) { this.payments = payments; }

    @JsonIgnore
    @OneToMany(targetEntity= Phone.class, mappedBy = "consumer", orphanRemoval=true)
    private Set<Phone> phones = new HashSet<>();

    public Set<Phone> getPhones() { return phones; }

    public void setPhones(Set<Phone> phones) { this.phones = phones; }

    @JsonIgnore
    @OneToMany(targetEntity= PaymentMethod.class, mappedBy = "consumer", orphanRemoval=true)
    private Set<PaymentMethod> paymentMethods = new HashSet<>();

    public Set<PaymentMethod> getPaymentMethods() { return paymentMethods; }

    public void setPaymentMethods(Set<PaymentMethod> phones) { this.paymentMethods = paymentMethods; }


}
