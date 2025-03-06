package br.supermerkat.supermerkat.adapters.outbound.repositories;

import br.supermerkat.supermerkat.domain.ports.outbound.ProductRepositoryPort;
import br.supermerkat.supermerkat.infrastructure.exception.NaoEncontradoException;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.infrastructure.mappers.MappersStruct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final SpringProductsRepository springProductsRepository;

    private final MappersStruct mappersStruct;

    public ProductRepositoryAdapter(SpringProductsRepository springProductsRepository, MappersStruct mappersStruct) {
        this.springProductsRepository = springProductsRepository;
        this.mappersStruct = mappersStruct;
    }

    @Override
    public List<ProductsEntity> findAll() {
        List<ProductsEntity> productsEntities = springProductsRepository.findAll();
        return productsEntities;
    }

    @Override
    public Optional<ProductsEntity> findById(Long products) {
        return springProductsRepository.findById(products);
    }

    @Override
    public ProductsEntity save(ProductsEntity products) {
        return springProductsRepository.save(products);
    }

    @Override
    public Optional<ProductsEntity> findByNameContainingIgnoreCase(String nameProduct) {
        return springProductsRepository.findByNameContainingIgnoreCase(nameProduct);
    }

}
