package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    IProductService productService = new ProductServiceIMPL();
    public List<Product> showListProduct(){
        return productService.findAll();
    }
    public void createStudent(Product product){
        productService.save(product);
    }
}
