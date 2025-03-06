package br.supermerkat.supermerkat.infrastructure.mappers;

import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.domain.model.ProductsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MappersStruct {

    @Mappings({
            @Mapping(source = "products.id", target = "id"),
            @Mapping(source = "products.name", target = "name"),
            @Mapping(source = "products.price", target = "price")
    })
    ProductsDTO toDtoProduct(ProductsEntity products);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "products.name", target = "name"),
            @Mapping(source = "products.price", target = "price")
    })
    List<ProductsDTO> toDtoProducts(List<ProductsEntity> products);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "productsDTO.name", target = "name"),
            @Mapping(source = "productsDTO.price", target = "price")
    })
    ProductsEntity toEntityProduct(ProductsDTO productsDTO);
}
