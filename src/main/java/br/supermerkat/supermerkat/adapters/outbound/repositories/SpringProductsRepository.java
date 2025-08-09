package br.supermerkat.supermerkat.adapters.outbound.repositories;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.application.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProductsRepository extends BaseRepository<ProductsEntity> {

    Optional<ProductsEntity> findByNameContainingIgnoreCase(String name);
}
