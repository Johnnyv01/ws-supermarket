package br.supermerkat.supermerkat.application.base;

import java.util.UUID;

public interface BaseEntityRequest<T extends BaseEntity> {
    T toEntity();
    T toEntity(UUID id);
}
