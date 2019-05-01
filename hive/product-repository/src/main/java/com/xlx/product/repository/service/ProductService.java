package com.xlx.product.repository.service;

import com.xlx.product.repository.annotation.DBTypeAnnotation;
import com.xlx.product.repository.domain.Product;
import com.xlx.product.repository.repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAndSave(){
        log.info("findAndSave() 方法开始.....");
        List<Product> productList = testFunc();
        log.info("findAndSave() 方法结束.....");
        return productList;
    }

    @Transactional
    public List<Product> findAndSaveWithTran(){
        log.info("findAndSaveWithTran() 方法开始.....");
        List<Product> productList = testFunc();
        log.info("findAndSaveWithTran() 方法结束.....");
        return productList;
    }

    @DBTypeAnnotation
    public List<Product> findAndSaveWithWrite(){
        log.info("findAndSaveWithWrite() 方法开始.....");
        List<Product> productList = testFunc();
        log.info("findAndSaveWithWrite() 方法结束.....");
        return productList;
    }

    @DBTypeAnnotation
    @Transactional
    public List<Product> findAndSaveWithWriteWithTran(){
        log.info("findAndSaveWithWriteWithTran() 方法开始.....");
        List<Product> productList = testFunc();
        log.info("findAndSaveWithWriteWithTran() 方法结束.....");
        return productList;
    }

    private List<Product> testFunc() {
        List<Product> productList = repository.selectAll();
        repository.saveProduct(productList.get(0));
        productList = repository.selectAll();
        return productList;
    }

}
