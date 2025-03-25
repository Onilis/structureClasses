package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract boolean isSpecial(); // Абстрактный метод для проверки специальности

    @Override
    public String toString() {
        return String.format("%s: %d руб.", getName(), getPrice());
    }
}