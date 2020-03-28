package com.terremotospr.beans.administrativeBeans;

/**
 * Created on March 17, 2020 - 12:55 AM
 *
 * @author Victor Nazario
 */
public class AdminBean extends UserBean{
    private Long adminId;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
