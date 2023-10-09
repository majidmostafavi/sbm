package com.majidmostafavi.sbm.controller;

import com.majidmostafavi.sbm.model.Product;
import com.majidmostafavi.sbm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product postProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable String id){
        return  productService.findByID(id);
    }


    @PutMapping
    public Product editProduct(@RequestBody Product product){
        return productService.edit(product);
    }

    @DeleteMapping("/{id}")
    public void  deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

}
