package br.supermerkat.supermerkat.service;

import br.supermerkat.supermerkat.util.api.ReturnResponse;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.infrastructure.exception.NaoEncontradoException;
import br.supermerkat.supermerkat.adapters.outbound.repositories.SpringProductsRepository;
import br.supermerkat.supermerkat.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    SpringProductsRepository repository;

    private static Logger logger = LoggerFactory.getLogger(ProductsService.class);

    public ReturnResponse salvar( ProductsEntity products){

        String message = "Produto foi cadastrado com sucesso!";
        HttpStatus status = HttpStatus.OK;

        if (products.getId() != null){
            Optional<ProductsEntity> productsOptional = repository.findById(products.getId());
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

        Optional<ProductsEntity>  product = repository.findByNameContainingIgnoreCase(name);

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

    public ProductsEntity buscarOuFalhar(Long productsId){
        logger.error("Adicionando logs na aplicacao para testes");
       return repository.findById(productsId)
               .orElseThrow(() -> new NaoEncontradoException(productsId));

    }

    public ReturnResponse deletar(Long productId) {
        String message = "Recurso deletado com sucesso!";
        HttpStatus status = HttpStatus.OK;

        repository.deleteById(productId);

        return ReturnResponse.builder()
                .status(status)
                .message(message)
                .object(null)
                .sendDateTime(Util.getDateTime())
                .build();
    }
}
