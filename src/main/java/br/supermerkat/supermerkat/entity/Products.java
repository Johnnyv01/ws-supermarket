package br.supermerkat.supermerkat.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Products {


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

}
