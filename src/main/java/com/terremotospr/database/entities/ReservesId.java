package com.terremotospr.database.entities;

import java.io.Serializable;

public class ReservesId implements Serializable {

    private Long resourceId;
    private Long reservationId;

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    public Long getReservationId() { return reservationId; }

    public void setReservationId(Long reservationId) { this.reservationId = reservationId; }
}
