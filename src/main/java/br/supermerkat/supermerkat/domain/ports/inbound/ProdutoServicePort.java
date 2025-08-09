package br.supermerkat.supermerkat.domain.ports.inbound;

import br.supermerkat.supermerkat.application.base.BaseService;
import br.supermerkat.supermerkat.domain.model.request.ProductsRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.ProductsResponseDTO;
import br.supermerkat.supermerkat.util.api.ResponseAPI;

import java.util.UUID;

public interface ProdutoServicePort extends BaseService<ProductsRequestDTO,ProductsResponseDTO> {

    @Override
    ResponseAPI<ProductsResponseDTO> create(ProductsRequestDTO request);

    @Override
    ResponseAPI<ProductsResponseDTO> update(UUID uuid, ProductsRequestDTO request);
}
