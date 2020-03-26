package com.terremotospr.database.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @ManyToOne(targetEntity = Consumer.class, cascade = CascadeType.ALL)
    private Consumer consumer;

    @OneToMany(targetEntity=Reserves.class, mappedBy="resource", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Reserves> reserves = new HashSet<>();

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

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Set<Reserves> getReserves() { return reserves; }

    public void setReserves(Set<Reserves> reserves) { this.reserves = reserves; }
}
