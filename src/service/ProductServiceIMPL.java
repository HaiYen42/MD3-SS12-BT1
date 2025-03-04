package service;

import config.Config;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService{
    public static List<Product> productList= new ArrayList<>();
    static {
        productList.add(new Product(1, "bag1", 15 ));
        productList.add(new Product(2, "bag2", 20));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }


    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id) {
                productList.remove(i);
            }
        }
    }
}
