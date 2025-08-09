package br.supermerkat.supermerkat.application.base;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    protected BaseEntity() {
    }

    protected BaseEntity(UUID id) {
        this.id = id;
    }
}
