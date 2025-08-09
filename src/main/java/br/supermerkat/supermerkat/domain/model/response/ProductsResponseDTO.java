package br.supermerkat.supermerkat.domain.model.response;


import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponseDTO {

    private UUID id;

    private String name;

    private BigDecimal price;

    public static ProductsResponseDTO fromEntity(ProductsEntity products) {
        return new ProductsResponseDTO(
                products.getId(),
                products.getName(),
                products.getPrice()
        );
    }

    public static List<ProductsResponseDTO> fromEntities(List<ProductsEntity> productsList) {
        return productsList.stream()
                .map(ProductsResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ProductsDTO: " +
                ", name = " + name +
                ", price = " + price;
    }

}
