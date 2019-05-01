package com.xlx.product.repository.controller;

import com.xlx.product.repository.domain.Product;
import com.xlx.product.repository.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/findAndSave")
    public List<Product> findAndSave()throws SQLException {
        productService.findAndSaveWithTran();
        return productService.findAndSave();
    }

    @GetMapping("/product/findAndSaveWithWrite")
    public List<Product> findAndSaveWithWrite()throws SQLException {
        productService.findAndSaveWithWriteWithTran();
        return productService.findAndSaveWithWrite();
    }
}
