package com.terremotospr.database.entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Entity
public class Reserves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rquantity;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getRquantity() { return rquantity; }

    public void setRQuantity(int rquantity) { this.rquantity = rquantity; }

    //Relationships
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    BaseResource resource;

    @Column(name = "resource_id")
    private Long resourceId;

    public BaseResource getResource() { return resource; }

    public void setResource(BaseResource resource) { this.resource = resource; }

    public Long setResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", insertable = false, updatable = false)
    private Reservation reservation;

    @Column(name = "reservation")
    private Long reservationId;

    public Long getResourceId() { return resourceId; }

    public Long getReservationId() { return reservationId; }

    public void setReservationId(Long reservationId) { this.reservationId = reservationId; }
}
