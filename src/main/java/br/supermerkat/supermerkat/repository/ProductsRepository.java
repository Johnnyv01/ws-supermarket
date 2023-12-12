package br.supermerkat.supermerkat.repository;

import br.supermerkat.supermerkat.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
