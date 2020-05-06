package com.terremotospr.database.entities.administrativeEntities;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/26/2020
 */
public class ReservesId implements Serializable {

    private Long resourceId;
    private Long reservationId;

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    public Long getReservationId() { return reservationId; }

    public void setReservationId(Long reservationId) { this.reservationId = reservationId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservesId that = (ReservesId) o;
        return Objects.equals(resourceId, that.resourceId) &&
                Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, reservationId);
    }
}
