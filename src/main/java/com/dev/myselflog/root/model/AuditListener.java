package com.dev.myselflog.root.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditListener {
    @PrePersist
    public void onPrePersist(AuditBO audit) {
        if (audit != null) {
            audit.setCreatedBy(UserContext.getCurrentTenant().getId().longValue());
            audit.setUpdatedBy(UserContext.getCurrentTenant().getId().longValue());
        }
    }

    @PreUpdate
    public void onPreUpdate(AuditBO audit) {
        if (audit != null) {
            audit.setUpdatedBy(UserContext.getCurrentTenant().getId().longValue());
        }
    }
}
