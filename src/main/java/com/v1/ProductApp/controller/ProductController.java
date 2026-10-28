package com.v1.ProductApp.controller;


import com.v1.ProductApp.model.Product;
import com.v1.ProductApp.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

       @Autowired
    private ProductServiceImpl productService;

      /** @GetMapping("/all")
    public List<Product> getAllProduct(){
           return productService.getAllProduct();
       }**/

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
           return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
   @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product){

        return ResponseEntity.ok((productService.createProduct(product)));
   }

   @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product productDetails){
      return ResponseEntity.ok(productService.upadteProduct(id, productDetails));

   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){

        return ResponseEntity.ok(productService.deleteProduct(id));
   }

}
