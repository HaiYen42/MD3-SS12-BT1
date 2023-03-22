package service;

import model.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getProductName().toLowerCase().compareTo(o2.getProductName().toLowerCase());
    }
}
