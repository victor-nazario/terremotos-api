package com.terremotospr.beans.administrativeBeans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
public class ReservesBean {
    private int rquantity;
    private Long resourceId;
    private Long reservationId;

    public int getRQuantity() { return rquantity; }

    public void setRQuantity(int rquantity) { this.rquantity = rquantity; }

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    public Long getReservationId() { return reservationId; }

    public void setReservationId(Long reservationId) { this.reservationId = reservationId; }
}
