package com.majidmostafavi.sbm.dao;

import com.majidmostafavi.sbm.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByName(String name);

    Product findByCode(String code);
}
