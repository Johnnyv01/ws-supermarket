package br.supermerkat.supermerkat.repository;

import br.supermerkat.supermerkat.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    Optional<Products> findByNameContainingIgnoreCase(String name);
}
