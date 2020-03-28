package com.terremotospr.database.entities.administrativeEntities;

import com.terremotospr.beans.administrativeBeans.AccountStatus;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */

@Entity
@IdClass(ManagesId.class)
public class Manages implements Serializable {

    private AccountStatus status;

    public AccountStatus getStatus() { return status; }

    public void setStatus(AccountStatus status) { this.status = status; }

    //Relationships
    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    User user;

    @Column(name = "user_id")
    private Long userId;

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "admin_id", insertable = false, updatable = false)
    Admin admin;

    @Column(name = "admin_id")
    private Long adminId;

    public Admin getAdmin() { return admin; }

    public void setAdmin(Admin admin) { this.admin = admin; }

    public Long getAdminId() { return adminId; }

    public void setAdminId(Long adminId) { this.adminId = adminId;
    }

}

