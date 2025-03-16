package br.supermerkat.supermerkat.application.usescases;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.domain.ports.inbound.ProdutoServicePort;
import br.supermerkat.supermerkat.domain.ports.outbound.ProductRepositoryPort;
import br.supermerkat.supermerkat.infrastructure.exception.NaoEncontradoException;
import br.supermerkat.supermerkat.util.Util;
import br.supermerkat.supermerkat.util.api.ReturnResponse;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class ProdutosServiceImp implements ProdutoServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    public ProdutosServiceImp(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<ProductsEntity> findAll() {
        return productRepositoryPort.findAll();
    }

    @Override
    public ProductsEntity buscarOuFalhar(Long productsId) {
        return productRepositoryPort.findById(productsId).orElseThrow(() ->
                new NaoEncontradoException("Produto não foi encontrado na nossa base de dados"));
    }

    @Override
    public ReturnResponse salvar(ProductsEntity products) {
        String message = "Produto foi cadastrado com sucesso!";
        HttpStatus status = HttpStatus.OK;

        if ( products.getId() != null ) {
            Optional<ProductsEntity> productsOptional = productRepositoryPort.findById(products.getId());
            if (productsOptional.isPresent()){
                message = "Produto foi atualizado com sucesso!";
                status = HttpStatus.ACCEPTED;
            }
        }

        productRepositoryPort.save(products);
        return ReturnResponse.builder()
                .message(message)
                .status(status)
                .object(products)
                .sendDateTime(Util.getDateTime())
                .build();
    }

    @Override
    public ReturnResponse findName(String nameProduct) {
        String message = "Produto foi encontrado com sucesso";
        HttpStatus status = HttpStatus.OK;

        Optional<ProductsEntity>  product = productRepositoryPort.findByNameContainingIgnoreCase(nameProduct);

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

    @Override
    public ReturnResponse deletar(Long productId) {
        String message = "Recurso deletado com sucesso!";
        HttpStatus status = HttpStatus.OK;

        productRepositoryPort.deleteById(productId);

        return ReturnResponse.builder()
                .status(status)
                .message(message)
                .object(null)
                .sendDateTime(Util.getDateTime())
                .build();
    }
}
