package com.terremotospr.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created on March 17, 2020 - 12:56 AM
 *
 * @author Victor Nazario
 */
@Entity
public class Admin extends User{

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
