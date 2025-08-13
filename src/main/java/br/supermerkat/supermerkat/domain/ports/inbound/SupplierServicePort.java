package br.supermerkat.supermerkat.domain.ports.inbound;

import br.supermerkat.supermerkat.application.base.BaseService;
import br.supermerkat.supermerkat.domain.model.request.SuppliersRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.SuppliersResponseDTO;
import br.supermerkat.supermerkat.util.api.ResponseAPI;

import java.util.List;
import java.util.UUID;

public interface SupplierServicePort extends BaseService<SuppliersRequestDTO, SuppliersResponseDTO> {

    @Override
    ResponseAPI<SuppliersResponseDTO> create(SuppliersRequestDTO request);

    @Override
    ResponseAPI<SuppliersResponseDTO> update(UUID uuid, SuppliersRequestDTO request);

    @Override
    ResponseAPI<List<SuppliersResponseDTO>> findAll();

    @Override
    ResponseAPI<SuppliersResponseDTO> findById(UUID ui);

    @Override
    ResponseAPI<SuppliersResponseDTO> deleteById(UUID ui);
}
