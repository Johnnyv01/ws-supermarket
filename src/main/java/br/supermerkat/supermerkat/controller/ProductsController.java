package br.supermerkat.supermerkat.controller;

import br.supermerkat.supermerkat.api.ReturnResponse;
import br.supermerkat.supermerkat.entity.Products;
import br.supermerkat.supermerkat.repository.ProductsRepository;
import br.supermerkat.supermerkat.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsService productsService;


    @GetMapping
    public List<Products> todos(){
        return productsRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Products findById(@PathVariable Long productId) throws Exception {
        try {
            return productsService.buscarOuFalhar(productId);

        }catch (Exception e){
           throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/nameProducts")
    public ResponseEntity<ReturnResponse> findNameProduct(@RequestParam String nameProduct) throws Exception {
        try {
              ReturnResponse returnResponse =  productsService.findName(nameProduct);
            return new ResponseEntity<>(returnResponse,returnResponse.getStatus());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ReturnResponse> saveAndUpdate(@RequestBody Products products) throws Exception {
        try {
            System.out.println("products: " + products);
            ReturnResponse returnResponse = productsService.salvar(products);
            return new ResponseEntity<>(returnResponse, returnResponse.getStatus());
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
