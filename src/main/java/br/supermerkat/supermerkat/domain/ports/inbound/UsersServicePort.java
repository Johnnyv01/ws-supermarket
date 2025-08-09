package br.supermerkat.supermerkat.domain.ports.inbound;

import br.supermerkat.supermerkat.application.base.BaseService;
import br.supermerkat.supermerkat.domain.model.request.UsersRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.UsersResponseDTO;
import br.supermerkat.supermerkat.util.api.ResponseAPI;

import java.util.List;
import java.util.UUID;

public interface UsersServicePort extends BaseService<UsersRequestDTO, UsersResponseDTO> {

    @Override
    ResponseAPI<UsersResponseDTO> create(UsersRequestDTO request);

    @Override
    ResponseAPI<List<UsersResponseDTO>> findAll();

    @Override
    ResponseAPI<UsersResponseDTO> findById(UUID ui);

    @Override
    ResponseAPI<UsersResponseDTO> deleteById(UUID ui);

    @Override
    ResponseAPI<UsersResponseDTO> update(UUID uuid, UsersRequestDTO request);
}
