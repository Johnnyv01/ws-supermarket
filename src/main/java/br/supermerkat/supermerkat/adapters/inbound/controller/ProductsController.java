package br.supermerkat.supermerkat.adapters.inbound.controller;

import br.supermerkat.supermerkat.domain.model.request.ProductsRequestDTO;
import br.supermerkat.supermerkat.domain.ports.inbound.ProdutoServicePort;
import br.supermerkat.supermerkat.infrastructure.exception.ResourceNotFoundException;
import br.supermerkat.supermerkat.util.api.ResponseAPI;
import br.supermerkat.supermerkat.domain.model.response.ProductsResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProdutoServicePort produtoServicePort;

    public ProductsController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<ProductsResponseDTO>> save(
            @RequestBody ProductsRequestDTO products
    ) throws Exception {
        try {
            ResponseAPI<ProductsResponseDTO> produtoResponseDTO = produtoServicePort.create(products);
            return new ResponseEntity<>(produtoResponseDTO, produtoResponseDTO.getStatus());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @PutMapping("/{productId}")
    public ResponseEntity<ResponseAPI<ProductsResponseDTO>> update(
            @PathVariable UUID productId,
            @RequestBody ProductsRequestDTO products
    ) throws Exception {
        try {
            ResponseAPI<ProductsResponseDTO> productsResponseDTOAPIReturnResponse = produtoServicePort.update(productId, products);
            return new ResponseEntity<>(productsResponseDTOAPIReturnResponse, productsResponseDTOAPIReturnResponse.getStatus());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<ResponseAPI<List<ProductsResponseDTO>>> todos() {
        try {
            ResponseAPI<List<ProductsResponseDTO>> produtoServicePortAll = produtoServicePort.findAll();
            return new ResponseEntity<>(produtoServicePortAll, produtoServicePortAll.getStatus());
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ResponseAPI<ProductsResponseDTO>> findById(
            @PathVariable UUID productId
    ) {
        try {
            ResponseAPI<ProductsResponseDTO> produtoResponseDTO = produtoServicePort.findById(productId);
            return new ResponseEntity<>(produtoResponseDTO, produtoResponseDTO.getStatus());
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ResponseAPI<?>> delete(
            @PathVariable UUID productId
    ) {
        try {
            ResponseAPI<ProductsResponseDTO> produtoResponseDTO = produtoServicePort.deleteById(productId);
            return new ResponseEntity<>(produtoResponseDTO, produtoResponseDTO.getStatus());
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

}
