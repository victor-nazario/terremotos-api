package com.terremotospr.database.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Entity
@IdClass(ReservesId.class)
public class Reserves implements Serializable {

    private int rquantity;

    public int getRquantity() { return rquantity; }

    public void setRQuantity(int rquantity) { this.rquantity = rquantity; }

    //Relationships
    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    BaseResource resource;

    @Column(name = "resource_id")
    private Long resourceId;

    public BaseResource getResource() { return resource; }

    public void setResource(BaseResource resource) { this.resource = resource; }

    public Long setResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", insertable = false, updatable = false)
    private Reservation reservation;

    @Column(name = "reservation_id")
    private Long reservationId;

    public Long getResourceId() { return resourceId; }

    public Long getReservationId() { return reservationId; }

    public void setReservationId(Long reservationId) { this.reservationId = reservationId; }
}
