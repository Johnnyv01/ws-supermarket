package br.supermerkat.supermerkat.adapters.outbound.entity;

import br.supermerkat.supermerkat.application.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UsuarioEntity extends BaseEntity {

    @Column(name = "usr_name")
    private String name;

    @Column(name = "usr_email")
    private String email;

    @Column(name = "usr_telefone")
    private String telefone;

    @Column(name = "usr_ativo")
    private Boolean ativo;

    @Column(name = "usr_dt_acoes")
    private Date dataHrAcoes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductsEntity> productsEntityList = new ArrayList<>();

    public UsuarioEntity(UUID id, String name, String email, String telefone, Boolean ativo, Date dataHrAcoes) {
        super(id);
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.ativo = ativo;
        this.dataHrAcoes = dataHrAcoes;
    }
}
