package br.supermerkat.supermerkat.application.base;

import br.supermerkat.supermerkat.infrastructure.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {

    default List<T> getAllOrThrow(String entityName) {
        List<T> allEntities = findAll();
        if (allEntities.isEmpty())
            throw new ResourceNotFoundException("Nenhuma entidade encontrada! " + entityName);
        return allEntities;
    }

    default T getOrThrow(UUID id, String entity) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Entity %s not found with id %s", entity, id)));
    }
}
