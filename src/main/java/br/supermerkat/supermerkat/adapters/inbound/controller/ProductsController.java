package br.supermerkat.supermerkat.adapters.inbound.controller;

import br.supermerkat.supermerkat.domain.ports.inbound.ProdutoServicePort;
import br.supermerkat.supermerkat.infrastructure.mappers.MappersStruct;
import br.supermerkat.supermerkat.util.api.ReturnResponse;
import br.supermerkat.supermerkat.domain.model.ProductsDTO;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProdutoServicePort produtoServicePort;

    private final MappersStruct mappersStruct;

    public ProductsController(ProdutoServicePort produtoServicePort, MappersStruct mappersStruct) {
        this.produtoServicePort = produtoServicePort;
        this.mappersStruct = mappersStruct;
    }


    @GetMapping
    public List<ProductsDTO> todos(){
        List<ProductsEntity> productsList = produtoServicePort.findAll();
        return mappersStruct.toDtoProducts(productsList);
    }

    @GetMapping("/{productId}")
    public ProductsDTO findById(@PathVariable Long productId) throws Exception {
        try {
            ProductsEntity productsEntity = produtoServicePort.buscarOuFalhar(productId);
            return mappersStruct.toDtoProduct(productsEntity);
        }catch (Exception e){
           throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/nameProducts")
    public ResponseEntity<ReturnResponse> findNameProduct(@RequestParam String nameProduct) throws Exception {
        try {
              ReturnResponse returnResponse =  produtoServicePort.findName(nameProduct);
            return new ResponseEntity<>(returnResponse,returnResponse.getStatus());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ReturnResponse> saveAndUpdate(@RequestBody ProductsEntity products) throws Exception {
        try {
            ReturnResponse response = produtoServicePort.salvar(products);
            return new ResponseEntity<>(response, response.getStatus());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> delete(@PathVariable Long productId){
        try {
            ReturnResponse returnResponse = produtoServicePort.deletar(productId);
            return new ResponseEntity<>(returnResponse, returnResponse.getStatus());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
