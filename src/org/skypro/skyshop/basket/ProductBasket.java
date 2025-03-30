package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int productCount;
    private static final int MAX_SIZE = 5;

    public ProductBasket() {
        this.products = new Product[MAX_SIZE];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < MAX_SIZE) {
            products[productCount++] = product;
        } else {
            System.out.println("Невозможно добавить продукт: корзина заполнена.");
        }
    }

    public int size() {
        return productCount;
    }

    // Геттер для доступа к массиву products
    public Product[] getProducts() {
        return products;
    }
}
