package view;

import config.Config;

public class Main {
    int choose;
    public Main(){
        do{
            System.out.println("**************PRODUCT MANAGERMENT***********");
            System.out.println("1. Show List Product ");
            System.out.println("2. Create New Product ");
            System.out.println("3. Update Product ");
            System.out.println("4. Delete Product ");
            System.out.println("5. Sort Product by Name ");
            System.out.println(" Vui lòng nhập lựa chọn ");
            int choose = Config.scanner().nextInt();
            switch (choose){
                case 1:
                    new ProductManager().showTableProduct();
                    break;
                case 2:
                    new ProductManager().createProductForm();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while (choose !=5);

    }
    public static void main(String[] args) {
        new Main();
    }
}