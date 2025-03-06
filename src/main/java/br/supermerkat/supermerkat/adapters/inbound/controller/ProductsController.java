package br.supermerkat.supermerkat.adapters.inbound.controller;

import br.supermerkat.supermerkat.application.usescases.ProdutosServiceImp;
import br.supermerkat.supermerkat.domain.ports.outbound.ProductRepositoryPort;
import br.supermerkat.supermerkat.infrastructure.mappers.MappersStruct;
import br.supermerkat.supermerkat.util.api.ReturnResponse;
import br.supermerkat.supermerkat.domain.model.ProductsDTO;
import br.supermerkat.supermerkat.adapters.outbound.entity.ProductsEntity;
import br.supermerkat.supermerkat.adapters.outbound.repositories.SpringProductsRepository;
import br.supermerkat.supermerkat.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private SpringProductsRepository productsRepository;

    @Autowired
    private ProductsService productsService;

    private final ProdutosServiceImp produtosServiceImp;

    private final MappersStruct mappersStruct;

    public ProductsController(SpringProductsRepository productsRepository, ProductsService productsService, ProdutosServiceImp produtosServiceImp,
                              MappersStruct mappersStruct) {
        this.productsRepository = productsRepository;
        this.productsService = productsService;
        this.produtosServiceImp = produtosServiceImp;
        this.mappersStruct = mappersStruct;
    }


    @GetMapping
    public List<ProductsDTO> todos(){
        List<ProductsEntity> productsList = produtosServiceImp.findAll();
        List<ProductsDTO> productsDTOS = mappersStruct.toDtoProducts(productsList);
        return productsDTOS;
    }

    @GetMapping("/{productId}")
    public ProductsDTO findById(@PathVariable Long productId) throws Exception {
        try {
            ProductsEntity productsEntity = produtosServiceImp.buscarOuFalhar(productId);
            return mappersStruct.toDtoProduct(productsEntity);
        }catch (Exception e){
           throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/nameProducts")
    public ResponseEntity<ReturnResponse> findNameProduct(@RequestParam String nameProduct) throws Exception {
        try {
              ReturnResponse returnResponse =  produtosServiceImp.findName(nameProduct);
            return new ResponseEntity<>(returnResponse,returnResponse.getStatus());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ReturnResponse> saveAndUpdate(@RequestBody ProductsEntity products) throws Exception {
        try {
            ReturnResponse response = produtosServiceImp.salvar(products);
            return new ResponseEntity<>(response, response.getStatus());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> delete(@PathVariable Long productId) throws Exception {

        try {
            ReturnResponse returnResponse = productsService.deletar(productId);
            return new ResponseEntity<>(returnResponse, returnResponse.getStatus());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
