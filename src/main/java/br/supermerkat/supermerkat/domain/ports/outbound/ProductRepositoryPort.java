package br.supermerkat.supermerkat.domain.ports.outbound;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

    List<ProductsEntity> findAll();

    Optional<ProductsEntity> findById(Long products);

    ProductsEntity save(ProductsEntity products);

    Optional<ProductsEntity> findByNameContainingIgnoreCase (String nameProduct);
}
