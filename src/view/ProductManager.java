package view;

import config.Config;
import controller.ProductController;
import model.Product;
import service.ProductComparator;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Collections;
import java.util.List;

public class ProductManager {
    static ProductController productController = new ProductController();
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
    public static void createProductForm(){
        Product product = getProduct();
        productController.createProduct(product);
        System.out.println("Create Success !!! ");
        System.out.println("Enter quit to comeback Menu ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();

        }

    }

    private static Product getProduct() {

        int id= productController.showListProduct().get(productController.showListProduct().size()-1).getId()+1;
        System.out.println("Enter product Name ");
        String name= Config.scanner().nextLine();
        System.out.println("Enter product price ");
        float price= Config.scanner().nextFloat();
        Product product = new Product(id, name, price);
        return product;
    }

    public static void editProduct(){
        System.out.println("Input Id of Product you want to edit ");
        int id= Config.scanner().nextInt();
        Product product=getProduct();
        product.setId(id);
        int index =findIndexById(id);
        if (index !=-1) {
            productController.showListProduct().set(index, product);
        }
        
    }
    
    public static int findIndexById(int id){
        for (int i = 0; i < productController.showListProduct().size(); i++) {
            if (id == productController.showListProduct().get(i).getId()) {
                return i;
            }
        }
        System.err.println("Can not find this product in list ");
        return -1;
    }
    public static void deleteProductById(){
        System.out.println("Enter Id of Product you want to delete");
        int id= Config.scanner().nextInt();
        int index= findIndexById(id);
        if (index !=-1) {
            productController.showListProduct().remove(index);
        }
    }
    public static void sortProductByName(){
        ProductComparator productComparator = new ProductComparator();
        List<Product> productList = productController.showListProduct();
        Collections.sort(productList, productComparator);
        System.out.println("Sort successfull ! ");
        System.out.println("Enter back to comeback !");
        String back= Config.scanner().nextLine();
        if (back.equalsIgnoreCase("back")) {
            new Main();
        }
    }




}
