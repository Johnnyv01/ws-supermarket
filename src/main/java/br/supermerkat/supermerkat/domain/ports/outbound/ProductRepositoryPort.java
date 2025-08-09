package br.supermerkat.supermerkat.domain.ports.outbound;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {

    List<ProductsEntity> findAll();

    Optional<ProductsEntity> findById(UUID products);

    void save(ProductsEntity products);

    Optional<ProductsEntity> findByNameContainingIgnoreCase (String nameProduct);

    void deleteById(UUID productsId);
}
