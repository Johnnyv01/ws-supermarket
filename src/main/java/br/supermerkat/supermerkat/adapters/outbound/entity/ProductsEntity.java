package br.supermerkat.supermerkat.adapters.outbound.entity;

import br.supermerkat.supermerkat.domain.Products;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class ProductsEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pdt_id")
    private Long id;

    @NotNull
    @Column(name = "pdt_name")
    private String name;

    @NotNull
    @Column(name = "pdt_price")
    private String price;

    public ProductsEntity() {
    }

    public ProductsEntity(Long id, String name, String price) {

    }

    public Products toProduto() {
        return new Products(this.id, this.name, this.price);
    }
}
