package br.supermerkat.supermerkat.domain.model.response;

import br.supermerkat.supermerkat.adapters.outbound.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseDTO {

    private String name;
    private String email;
    private String telefone;
    private Boolean ativo;
    private Date dataHrAcoes;

    public static UsersResponseDTO fromEntity(UsuarioEntity user) {
        return new UsersResponseDTO(
                user.getName(),
                user.getName(),
                user.getTelefone(),
                user.getAtivo(),
                user.getDataHrAcoes()
        );
    }

    public static List<UsersResponseDTO> fromEntities(List<UsuarioEntity> users) {
        return users.stream()
                .map(UsersResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
