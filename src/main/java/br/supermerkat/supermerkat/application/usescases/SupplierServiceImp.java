package br.supermerkat.supermerkat.application.usescases;

import br.supermerkat.supermerkat.adapters.outbound.entity.FornecedoresEntity;
import br.supermerkat.supermerkat.adapters.outbound.repositories.SpringSuppliersRepository;
import br.supermerkat.supermerkat.application.BaseServiceImpl;
import br.supermerkat.supermerkat.domain.model.request.SuppliersRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.SuppliersResponseDTO;
import br.supermerkat.supermerkat.domain.ports.inbound.SupplierServicePort;
import br.supermerkat.supermerkat.util.api.ResponseAPI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierServiceImp extends BaseServiceImpl<FornecedoresEntity, SuppliersRequestDTO, SuppliersResponseDTO, SpringSuppliersRepository> implements SupplierServicePort {

    protected SupplierServiceImp(SpringSuppliersRepository repository) {
        super(repository, "Fornecedores", SuppliersResponseDTO::toDTO, SuppliersResponseDTO::toDTOList);
    }

    @Override
    public ResponseAPI<SuppliersResponseDTO> create(SuppliersRequestDTO request) {
        return super.create(request);
    }

    @Override
    public ResponseAPI<SuppliersResponseDTO> update(UUID uuid, SuppliersRequestDTO request) {
        return super.update(uuid, request);
    }

    @Override
    public ResponseAPI<SuppliersResponseDTO> findById(UUID ui) {
        return super.findById(ui);
    }

    @Override
    public ResponseAPI<List<SuppliersResponseDTO>> findAll() {
        return super.findAll();
    }

    @Override
    public ResponseAPI<SuppliersResponseDTO> deleteById(UUID ui) {
        return super.deleteById(ui);
    }
}
