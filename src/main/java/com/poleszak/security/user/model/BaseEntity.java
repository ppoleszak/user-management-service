package com.poleszak.security.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;
import static java.time.LocalDateTime.now;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "entity_id_sequence")
    @SequenceGenerator(name = "entity_id_sequence", sequenceName = "entity_id_sequence")
    private Integer id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime modifiedDate;

    private LocalDateTime deletedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = modifiedDate = now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = now();
    }
}