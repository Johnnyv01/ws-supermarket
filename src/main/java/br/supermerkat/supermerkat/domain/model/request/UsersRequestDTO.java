package br.supermerkat.supermerkat.domain.model.request;

import br.supermerkat.supermerkat.adapters.outbound.entity.UsuarioEntity;
import br.supermerkat.supermerkat.application.base.BaseEntityRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDTO implements BaseEntityRequest<UsuarioEntity> {

    private String name;
    private String email;
    private String telefone;
    private Boolean ativo;
    private Date dataHrAcoes;

    @Override
    public UsuarioEntity toEntity() {
        return new UsuarioEntity(
                null,
                name,
                email,
                telefone,
                ativo,
                dataHrAcoes
        );
    }

    @Override
    public UsuarioEntity toEntity(UUID id) {
        return new UsuarioEntity(
                id,
                name,
                email,
                telefone,
                ativo,
                dataHrAcoes
        );
    }
}
