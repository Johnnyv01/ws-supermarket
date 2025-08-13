package br.supermerkat.supermerkat.adapters.outbound.entity;

import br.supermerkat.supermerkat.application.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "suppliers")
public class FornecedoresEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "fnc_name")
    private String nome;

    @Column(name = "fnc_cod_fornecedor")
    private Integer codFornecedor;

    @Column(name = "fnc_email")
    private String email;

    @Column(name = "fnc_login")
    private String login;

    @Column(name = "fnc_senha")
    private String senha;

    @OneToMany(mappedBy = "fornecedores", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductsEntity> productsEntityList = new ArrayList<>();

    public FornecedoresEntity(UUID id, String nome, Integer codFornecedor, String email, String login, String senha, List<ProductsEntity> productsEntityList) {
        super(id);
        this.nome = nome;
        this.codFornecedor = codFornecedor;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.productsEntityList = productsEntityList;
    }
}
