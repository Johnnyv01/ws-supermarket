package br.supermerkat.supermerkat.service;

import br.supermerkat.supermerkat.entity.Products;
import br.supermerkat.supermerkat.exception.NaoEncontradoException;
import br.supermerkat.supermerkat.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository repository;

    public Products salvar( Products products){

        return repository.save(products);

    }

    public Products buscarOuFalhar(Long productsId){

       return repository.findById(productsId)
               .orElseThrow(() -> new NaoEncontradoException(productsId));

    }
}
