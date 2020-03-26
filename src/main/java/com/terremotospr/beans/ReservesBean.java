package com.terremotospr.beans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
public class ReservesBean {
    private Long id;
    private int rquantity;
    private Long resourceId;
    private Long reservationId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getRQuantity() { return rquantity; }

    public void setRQuantity(int rquantity) { this.rquantity = rquantity; }

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    public Long getReservationId() { return reservationId; }

    public void setReservationId(Long reservationId) { this.reservationId = reservationId; }
}
