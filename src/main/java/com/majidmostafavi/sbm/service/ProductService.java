package com.majidmostafavi.sbm.service;

import com.majidmostafavi.sbm.dao.ProductRepository;
import com.majidmostafavi.sbm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<Product> findAllProduct(){
        return repository.findAll();
    }
    public Product save(Product product){
        product.setId(UUID.randomUUID().toString());
       return repository.save(product);
    }


    public Product findByID(String id){
        return  repository.findById(id).get();
    }

    public Product findByName(String name){
        return repository.findByName(name);
    }

    public Product findByCode(String code){
        return repository.findByCode(code);
    }

    public  Product edit(Product product){
        Product p = repository.findById(product.getId()).get();
        p.setName(product.getName());
        p.setCode(product.getCode());
        p.setDescription(product.getDescription());

        return repository.save(p);
    }


    public void deleteProduct(String productID){
         repository.deleteById(productID);
    }
}
