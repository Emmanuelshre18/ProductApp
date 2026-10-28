package com.v1.ProductApp.service;

import com.v1.ProductApp.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product upadteProduct(Long id, Product productDetails);
    String deleteProduct(Long id);

}
