package com.dev.myselflog.root.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;


@Getter
@Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, AuditListener.class})
@JsonIgnoreProperties(value = {"createdAt", "updatedAt", "createdBy", "updatedBy"}, allowGetters = true)
public class AuditBO {

    @Column(nullable = false, updatable = false, name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @Column(nullable = false, name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

}