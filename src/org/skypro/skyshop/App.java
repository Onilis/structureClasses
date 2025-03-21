package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 70);
        Product orange = new Product("Апельсин", 60);
        Product grape = new Product("Виноград", 80);
        Product melon = new Product("Дыня", 90);
        Product pear = new Product("Груша", 55);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grape);
        basket.addProduct(melon);

        basket.addProduct(pear);

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Корзина содержит яблоко? " + basket.containsProduct("Яблоко"));

        System.out.println("Корзина содержит грушу? " + basket.containsProduct("Груша"));

        basket.clearBasket();
        System.out.println("Корзина очищена.");

        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket(); // Вывод: "В корзине пусто"

        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        System.out.println("Корзина содержит банан? " + basket.containsProduct("Банан"));

        // Создание второй корзины
        ProductBasket anotherBasket = new ProductBasket();
        Product cake = new Product("Сало", 200);
        anotherBasket.addProduct(cake);
        System.out.println("\nСодержимое второй корзины:");
        anotherBasket.printBasket();
    }
}
