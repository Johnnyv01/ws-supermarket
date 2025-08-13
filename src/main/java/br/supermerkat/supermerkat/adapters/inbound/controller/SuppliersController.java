package br.supermerkat.supermerkat.adapters.inbound.controller;

import br.supermerkat.supermerkat.domain.model.request.SuppliersRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.SuppliersResponseDTO;
import br.supermerkat.supermerkat.domain.ports.inbound.SupplierServicePort;
import br.supermerkat.supermerkat.infrastructure.exception.ResourceNotFoundException;
import br.supermerkat.supermerkat.util.api.ResponseAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/supplier")
public class SuppliersController {

    private final SupplierServicePort supplierServicePort;

    public SuppliersController(SupplierServicePort supplierServicePort) {
        this.supplierServicePort = supplierServicePort;
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<SuppliersResponseDTO>> create(@RequestBody SuppliersRequestDTO request) {
        try {
            ResponseAPI<SuppliersResponseDTO> suppliersResponseDTOResponseAPI = supplierServicePort.create(request);
            return new ResponseEntity<>(suppliersResponseDTOResponseAPI, suppliersResponseDTOResponseAPI.getStatus());
        }catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ResponseAPI<SuppliersResponseDTO>> update(@PathVariable UUID uuid, @RequestBody SuppliersRequestDTO request) {
        try {
            ResponseAPI<SuppliersResponseDTO> suppliersResponseDTOResponseAPI = supplierServicePort.update(uuid, request);
            return new ResponseEntity<>(suppliersResponseDTOResponseAPI, suppliersResponseDTOResponseAPI.getStatus());
        }catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<ResponseAPI<List<SuppliersResponseDTO>>> get() {
        ResponseAPI<List<SuppliersResponseDTO>> supplierResponseDTO = supplierServicePort.findAll();
        return new ResponseEntity<>(supplierResponseDTO, supplierResponseDTO.getStatus());
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<ResponseAPI<SuppliersResponseDTO>> get(@PathVariable UUID supplierId) {
        try {
            ResponseAPI<SuppliersResponseDTO> suppliersResponseDTOResponseAPI = supplierServicePort.findById(supplierId);
            return new ResponseEntity<>(suppliersResponseDTOResponseAPI, suppliersResponseDTOResponseAPI.getStatus());
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

}
