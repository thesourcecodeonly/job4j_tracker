package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (i >= index && i <= products.length - 2) {
                products[i] = products[i + 1];
            } else if (i == products.length - 1) {
                products[i] = null;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Oil", 20);
        products[4] = new Product("Sugar", 28);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
        System.out.println("==========================");
        delete(products, 2);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (products[i] == null) {
                System.out.println(products[i]);
            } else {
                System.out.println(product.getName());
            }
        }
    }
}