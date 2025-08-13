package br.supermerkat.supermerkat.adapters.outbound.entity;

import br.supermerkat.supermerkat.application.base.BaseEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "products")
public class ProductsEntity extends BaseEntity {

    @NotNull
    @Column(name = "pdt_name")
    private String name;

    @NotNull
    @Column(name = "pdt_price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pdt_fnc_id")
    private FornecedoresEntity fornecedores;

    public ProductsEntity() {
    }

    public ProductsEntity(UUID id, String name, BigDecimal price) {
        super(id);
        this.name = name;
        this.price = price;
    }
}
