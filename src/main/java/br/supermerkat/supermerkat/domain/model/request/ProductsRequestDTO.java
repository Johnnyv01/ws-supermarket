package br.supermerkat.supermerkat.domain.model.request;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.application.base.BaseEntityRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequestDTO implements BaseEntityRequest<ProductsEntity> {

    private UUID id;

    private String name;

    private BigDecimal price;

    private UUID usuarioId;

    @Override
    public ProductsEntity toEntity() {
        return new ProductsEntity(
                null,
                name,
                price
        );
    }

    @Override
    public ProductsEntity toEntity(UUID id) {
        return new ProductsEntity(
                id,
                name,
                price
        );
    }

    @Override
    public String toString() {
        return "ProductsRequestDTO: " +
                "id = " + id +
                ", name = " + name +
                ", price = " + price +
                ", usuarioId = " + usuarioId;
    }
}
