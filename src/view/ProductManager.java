package view;

import config.Config;
import controller.ProductController;
import model.Product;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.List;

public class ProductManager {
    ProductController productController = new ProductController();
    public void showTableProduct(){
        System.out.println("***********PRODUCT MANAGERMENT************");
        List<Product> productList = productController.showListProduct();
        System.out.println("=======ID=====NAME=====PRICE======");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(" "+ productList.get(i).getId()+ " "+productList.get(i).getProductName()+ " "+ productList.get(i).getPrice());
        }
        System.out.println("Enter quit to comeback Menu ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
    public void createProductForm(){
        int id= productController.showListProduct().get(productController.showListProduct().size()-1).getId()-1;
        System.out.println("Enter product Name ");
        String name= Config.scanner().nextLine();
        System.out.println("Enter product price ");
        float price= Config.scanner().nextFloat();
        Product product = new Product(id, name, price);
        productController.createStudent(product);
        System.out.println("Create Success !!! ");
        System.out.println("Enter quit to comeback Menu ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();


        }
    }

}
