package com.terremotospr.database.entities.administrativeEntities;

import java.io.Serializable;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
public class ManagesId implements Serializable {
    private Long userId;
    private Long adminId;

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getAdminId() { return adminId; }

    public void setAdminId(Long adminId) { this.adminId = adminId; }
}
