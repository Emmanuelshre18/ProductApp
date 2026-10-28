package com.v1.ProductApp.service;


import com.v1.ProductApp.model.Product;
import com.v1.ProductApp.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        log.info("getAllProduct() was hit");

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        log.info("getProductById was hit");

        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product Not Found"));
    }

    @Override
    public Product createProduct(Product product) {
        log.info("createProduct was hit");

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product upadteProduct(Long id, Product productDetails) {
        log.info("upadteProduct was hit");

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product Not Found"));

         if (productDetails.getName() != null) existingProduct.setName(productDetails.getName());
         if (productDetails.getDescription() != null) existingProduct.setDescription(productDetails.getDescription());
         if (productDetails.getPrice() != null) existingProduct.setPrice(productDetails.getPrice());
         if (productDetails.getQuantity() > 0) existingProduct.setQuantity(productDetails.getQuantity());

         return productRepository.save(existingProduct);
    }

    @Override
    public String deleteProduct(Long id) {
        log.info("deleteProduct was hit");

        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Product deleted Successfully";
        }else{
            throw new RuntimeException("Product does not exist");
        }

    }
}
