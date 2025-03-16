package br.supermerkat.supermerkat.domain.ports.inbound;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.util.api.ReturnResponse;
import java.util.List;

public interface ProdutoServicePort {

    List<ProductsEntity> findAll();

    ProductsEntity buscarOuFalhar(Long productsId);

    ReturnResponse salvar(ProductsEntity products);

    ReturnResponse findName(String nameProduct);

    ReturnResponse deletar(Long productId);
}
