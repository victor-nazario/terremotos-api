package com.terremotospr.beans.administrativeBeans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
public class ManagesBean {
    private Long userId;
    private Long adminId;
    private AccountStatus status;

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getAdminId() { return adminId; }

    public void setAdminId(Long adminId) { this.adminId = adminId; }

    public AccountStatus getStatus() { return status; }

    public void setStatus(AccountStatus status) { this.status = status; }
}
