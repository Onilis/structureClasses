package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products;
    private int productCount;
    private static final int MAX_SIZE = 5; // Максимальный размер корзины

    public ProductBasket() {
        this.products = new Product[MAX_SIZE];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < MAX_SIZE) {
            this.products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < productCount; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public void printBasket() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;
    }
}