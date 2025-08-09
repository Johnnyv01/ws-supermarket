package br.supermerkat.supermerkat.adapters.outbound.repositories;

import br.supermerkat.supermerkat.domain.ports.outbound.ProductRepositoryPort;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final SpringProductsRepository springProductsRepository;

    public ProductRepositoryAdapter(SpringProductsRepository springProductsRepository) {
        this.springProductsRepository = springProductsRepository;
    }

    @Override
    public List<ProductsEntity> findAll() {
        return springProductsRepository.findAll();
    }

    @Override
    public Optional<ProductsEntity> findById(UUID products) {
        return springProductsRepository.findById(products);
    }

    @Override
    public void save(ProductsEntity products) {
        springProductsRepository.save(products);
    }

    @Override
    public Optional<ProductsEntity> findByNameContainingIgnoreCase(String nameProduct) {
        return springProductsRepository.findByNameContainingIgnoreCase(nameProduct);
    }

    @Override
    public void deleteById(UUID productsId) {
        springProductsRepository.deleteById(productsId);
    }

}
