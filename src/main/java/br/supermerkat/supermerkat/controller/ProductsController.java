package br.supermerkat.supermerkat.controller;

import br.supermerkat.supermerkat.entity.Products;
import br.supermerkat.supermerkat.repository.ProductsRepository;
import br.supermerkat.supermerkat.service.ProductsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
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
    public Products buscarById(@PathVariable Long productId) throws Exception {
        try {

             return productsService.buscarOuFalhar(productId);

        }catch (Exception e){
           throw new Exception(e.getMessage());
        }
    }

    @PostMapping
    public Products salvar(@RequestBody Products products){
        return  productsService.salvar(products);
    }

    @PutMapping("update/{productId}")
    public Products atualizar(@PathVariable Long productId, @RequestBody Products products) throws Exception {

        try {
            Products productsAtual = productsService.buscarOuFalhar(productId);
            BeanUtils.copyProperties(products,productsAtual,"id");
            return productsService.salvar(productsAtual);
        }catch (Exception e){
            throw  new Exception( e.getCause());
        }
    }
}
