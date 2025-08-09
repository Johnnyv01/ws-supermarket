package br.supermerkat.supermerkat.application.usescases;

import br.supermerkat.supermerkat.adapters.outbound.entity.UsuarioEntity;
import br.supermerkat.supermerkat.adapters.outbound.repositories.SpringUsersRepository;
import br.supermerkat.supermerkat.application.BaseServiceImpl;
import br.supermerkat.supermerkat.domain.model.request.UsersRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.UsersResponseDTO;
import br.supermerkat.supermerkat.domain.ports.inbound.UsersServicePort;
import br.supermerkat.supermerkat.util.api.ResponseAPI;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp extends BaseServiceImpl<UsuarioEntity, UsersRequestDTO, UsersResponseDTO, SpringUsersRepository> implements UsersServicePort {

    protected UserServiceImp(SpringUsersRepository repository) {
        super(repository, "Usuario", UsersResponseDTO::fromEntity, UsersResponseDTO::fromEntities);
    }

    @Override
    public ResponseAPI<UsersResponseDTO> create(UsersRequestDTO request) {
        return super.create(request);
    }

    @Override
    public ResponseAPI<UsersResponseDTO> update(UUID uuid, UsersRequestDTO request) {
        return super.update(uuid, request);
    }

    @Override
    public ResponseAPI<List<UsersResponseDTO>> findAll() {
        return super.findAll();
    }

    @Override
    public ResponseAPI<UsersResponseDTO> findById(UUID ui) {
        return super.findById(ui);
    }


}
