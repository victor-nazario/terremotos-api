package com.terremotospr.beans.administrativeBeans;

import java.util.List;

/**
 * Created on March 17, 2020 - 12:55 AM
 *
 * @author Victor Nazario
 */
public class AdminBean extends UserBean{
    private Long adminId;
    private List<UserBean> managedUsers;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public List<UserBean> getManagedUsers() {
        return managedUsers;
    }

    public void setManagedUsers(List<UserBean> managedUsers) {
        this.managedUsers = managedUsers;
    }
}
