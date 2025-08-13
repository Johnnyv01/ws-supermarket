package br.supermerkat.supermerkat.domain.model.request;

import br.supermerkat.supermerkat.adapters.outbound.entity.FornecedoresEntity;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.application.base.BaseEntityRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersRequestDTO implements BaseEntityRequest<FornecedoresEntity> {

    private String nome;
    private Integer codFornecedor;
    private String email;
    private String login;
    private String senha;
    private List<ProductsEntity> productsEntityList;


    @Override
    public FornecedoresEntity toEntity() {
        return new FornecedoresEntity(null,nome,codFornecedor,email,login,senha,productsEntityList);
    }

    @Override
    public FornecedoresEntity toEntity(UUID id) {
        return new FornecedoresEntity(id,null,codFornecedor,email,login,senha,productsEntityList);
    }
}
