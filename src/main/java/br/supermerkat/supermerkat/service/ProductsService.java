package br.supermerkat.supermerkat.service;

import br.supermerkat.supermerkat.api.ReturnResponse;
import br.supermerkat.supermerkat.entity.Products;
import br.supermerkat.supermerkat.exception.NaoEncontradoException;
import br.supermerkat.supermerkat.repository.ProductsRepository;
import br.supermerkat.supermerkat.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository repository;

    public ReturnResponse salvar( Products products){

        String message = "Produto foi cadastrado com sucesso!";
        HttpStatus status = HttpStatus.OK;

        if (products.getId() != null){
            Optional<Products> productsOptional = repository.findById(products.getId());
            if (productsOptional.isPresent()){
                message = "Produto foi atualizado com sucesso!";
                status = HttpStatus.ACCEPTED;
            }
        }

         repository.save(products);

        return ReturnResponse.builder()
                .message(message)
                .status(status)
                .object(products)
                .sendDateTime(Util.getDateTime())
                .build();

    }

    public ReturnResponse findName(String name){
        String message = "Produto foi encontrado com sucesso";
        HttpStatus status = HttpStatus.OK;

        Optional<Products>  product = repository.findByNameContainingIgnoreCase(name);

        System.out.println("product: " + product);
        if (!product.isPresent()) {
            message = "Produto não encontrado";
            status = HttpStatus.NOT_FOUND;
        }

        return ReturnResponse.builder()
                .status(status)
                .message(message)
                .object(product)
                .sendDateTime(Util.getDateTime())
                .build();

    }

    public Products buscarOuFalhar(Long productsId){

       return repository.findById(productsId)
               .orElseThrow(() -> new NaoEncontradoException(productsId));

    }
}
