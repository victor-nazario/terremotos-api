package com.terremotospr.database.entities;

import com.terremotospr.beans.ConsumerType;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */


@Entity(name = "Consumer")
public class Consumer extends User{

    private ConsumerType type;

    public ConsumerType getType() { return type; }

    public void setType(ConsumerType type) { this.type = type; }

//    @OneToMany(targetEntity=Payment.class, mappedBy = "consumer", orphanRemoval=true)
//    private Set<Payment> payments = new HashSet<>();
//
//    public Set<Payment> getPayments() { return payments; }
//
//    public void setPayments(Set<Payment> payments) { this.payments = payments; }




}
