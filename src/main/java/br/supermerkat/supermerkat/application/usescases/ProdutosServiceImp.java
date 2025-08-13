package br.supermerkat.supermerkat.application.usescases;

import br.supermerkat.supermerkat.adapters.outbound.entity.FornecedoresEntity;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.adapters.outbound.entity.UsuarioEntity;
import br.supermerkat.supermerkat.adapters.outbound.repositories.SpringProductsRepository;
import br.supermerkat.supermerkat.adapters.outbound.repositories.SpringSuppliersRepository;
import br.supermerkat.supermerkat.application.BaseServiceImpl;
import br.supermerkat.supermerkat.domain.model.request.ProductsRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.ProductsResponseDTO;
import br.supermerkat.supermerkat.domain.ports.inbound.ProdutoServicePort;
import br.supermerkat.supermerkat.util.api.ResponseAPI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutosServiceImp extends BaseServiceImpl<ProductsEntity, ProductsRequestDTO, ProductsResponseDTO, SpringProductsRepository> implements ProdutoServicePort {

    private final SpringSuppliersRepository springSuppliersRepository;

    protected ProdutosServiceImp(SpringProductsRepository repository, SpringSuppliersRepository springSuppliersRepository) {
        super(repository, "Produtos", ProductsResponseDTO::fromEntity , ProductsResponseDTO::fromEntities);
        this.springSuppliersRepository = springSuppliersRepository;
    }

    @Override
    public ResponseAPI<ProductsResponseDTO> findById(UUID ui) {
        return super.findById(ui);
    }

    @Override
    public ResponseAPI<List<ProductsResponseDTO>> findAll() {
        return super.findAll();
    }

    @Override
    public ResponseAPI<ProductsResponseDTO> create(ProductsRequestDTO request) {
        ProductsEntity productsEntity = request.toEntity();

        FornecedoresEntity fornecedores = springSuppliersRepository.getOrThrow(request.getUsuarioId(),entityName);
        productsEntity.setFornecedores(fornecedores);

        repository.save(productsEntity);

        return ResponseAPI.salvar(new ProductsResponseDTO(productsEntity.getId(),productsEntity.getName(), productsEntity.getPrice()));
    }

    @Override
    public ResponseAPI<ProductsResponseDTO> update(UUID uuid, ProductsRequestDTO request) {
        return super.update(uuid, request);
    }

    @Override
    public ResponseAPI<ProductsResponseDTO> deleteById(UUID ui) {
        return super.deleteById(ui);
    }
}

