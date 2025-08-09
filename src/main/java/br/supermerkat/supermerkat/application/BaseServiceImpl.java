package br.supermerkat.supermerkat.application;

import br.supermerkat.supermerkat.application.base.BaseEntity;
import br.supermerkat.supermerkat.application.base.BaseEntityRequest;
import br.supermerkat.supermerkat.application.base.BaseRepository;
import br.supermerkat.supermerkat.application.base.BaseService;
import br.supermerkat.supermerkat.util.api.ResponseAPI;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public abstract class BaseServiceImpl<T extends BaseEntity,RQ extends BaseEntityRequest<T>, RE,R extends BaseRepository<T>> implements BaseService<RQ,RE> {
    protected final R repository;
    protected final String entityName;
    private final Function<T,RE> mapEntity;
    private final Function<List<T>, List<RE>> mapEntities;

    protected BaseServiceImpl(R repository, String entityName, Function<T, RE> mapEntity, Function<List<T>, List<RE>> mapEntities) {
        this.repository = repository;
        this.entityName = entityName;
        this.mapEntity = mapEntity;
        this.mapEntities = mapEntities;
    }

    @Override
    public ResponseAPI<RE> create(RQ request) {
        T entity = request.toEntity();
        repository.save(entity);
        return ResponseAPI.salvar(
                mapEntity.apply(entity)
        );
    }

    @Override
    public ResponseAPI<RE> update(UUID uuid, RQ request) {
        repository.getOrThrow(uuid, entityName);
        T entity = request.toEntity(uuid);
        repository.save(entity);

        return ResponseAPI.salvar(
                mapEntity.apply(entity)
        );
    }

    @Override
    public ResponseAPI<RE> deleteById(UUID ui) {
        T entity = repository.getOrThrow(ui, entityName);
        repository.deleteById(ui);

        return ResponseAPI.delete(
                ui,
                mapEntity.apply(entity)
        );
    }

    @Override
    public ResponseAPI<RE> findById(UUID ui) {
        T entity = repository.getOrThrow(ui, entityName);
        return ResponseAPI.getId(
                ui,
                mapEntity.apply(entity)
        );
    }

    @Override
    public ResponseAPI<List<RE>> findAll() {
        List<T> allOrThrow = repository.getAllOrThrow(entityName);
        return ResponseAPI.get(
                mapEntities.apply(allOrThrow)
        );
    }
}
