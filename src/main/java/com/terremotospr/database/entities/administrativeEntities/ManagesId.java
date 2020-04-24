package com.terremotospr.database.entities.administrativeEntities;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/26/2020
 */
public class ManagesId implements Serializable {
    private Long userId;
    private Long adminId;

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getAdminId() { return adminId; }

    public void setAdminId(Long adminId) { this.adminId = adminId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagesId managesId = (ManagesId) o;
        return Objects.equals(userId, managesId.userId) &&
                Objects.equals(adminId, managesId.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, adminId);
    }
}
