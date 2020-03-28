package com.terremotospr.database.entities.paymentEntities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.terremotospr.database.entities.administrativeEntities.Belongs;
import com.terremotospr.database.entities.administrativeEntities.Consumer;

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
public class PlacedOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @OneToOne
    private Consumer consumer;

    @OneToMany(targetEntity= Belongs.class, mappedBy="orders", cascade={CascadeType.ALL}, orphanRemoval=true)
    private Set<Belongs> belongs = new HashSet<>();

    @OneToMany(targetEntity= Pays.class, mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Pays> pays = new HashSet<>();

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

    public Set<Belongs> getBelongs() { return belongs; }

    public void setBelongs(Set<Belongs> belongs) { this.belongs = belongs; }

    public Set<Pays> getPays() { return pays; }

    public void setPays(Set<Pays> pays) { this.pays = pays; }
}
