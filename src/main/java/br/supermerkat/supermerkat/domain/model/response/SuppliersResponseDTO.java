package br.supermerkat.supermerkat.domain.model.response;

import br.supermerkat.supermerkat.adapters.outbound.entity.FornecedoresEntity;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersResponseDTO {

    private String nome;
    private Integer codFornecedor;
    private String email;
    private String login;
    private String senha;
    private List<ProductsEntity> productsEntityList;

    public static SuppliersResponseDTO toDTO(FornecedoresEntity fornecedor) {
        return new SuppliersResponseDTO(fornecedor.getNome(),fornecedor.getCodFornecedor(),fornecedor.getEmail(), fornecedor.getLogin(), fornecedor.getSenha(), fornecedor.getProductsEntityList());
    }
    public static List<SuppliersResponseDTO> toDTOList(List<FornecedoresEntity> fornecedoresEntities) {
        return fornecedoresEntities.stream()
                .map(SuppliersResponseDTO::toDTO)
                .collect(Collectors.toList());
    }

}
