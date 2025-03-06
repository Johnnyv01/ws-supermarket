package br.supermerkat.supermerkat.adapters.outbound.repositories;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringProductsRepository extends JpaRepository<ProductsEntity, Long> {

    Optional<ProductsEntity> findByNameContainingIgnoreCase(String name);
}
