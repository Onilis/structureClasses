package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Яблоко", 52));
        basket.addProduct(new SimpleProduct("Банан", 73));
        basket.addProduct(new SimpleProduct("Апельсин", 64));
        basket.addProduct(new SimpleProduct("Виноград", 85));
        basket.addProduct(new SimpleProduct("Дыня", 91));
        basket.addProduct(new SimpleProduct("Груша", 52));

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println("\nСтоимость корзины: " + basket.getTotalPrice());
        System.out.println("Корзина содержит яблоко? " + basket.containsProduct("Яблоко"));
        System.out.println("Корзина содержит грушу? " + basket.containsProduct("Груша"));

        basket.clearBasket();
        System.out.println("\nКорзина очищена.");
        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());
        System.out.println("Корзина содержит банан? " + basket.containsProduct("Банан"));

        ProductBasket anotherBasket = new ProductBasket();
        anotherBasket.addProduct(new SimpleProduct("Сало", 200));
        System.out.println("\nСодержимое второй корзины:");
        anotherBasket.printBasket();

        Product product = new DiscountProduct("Смартфон", 30000, 15);
        System.out.println("\nТест скидки:");
        System.out.println(product.getName() + ": " + product.getPrice() + " руб.");

        Product product1 = new FixPriceProduct("Подарочный набор");
        System.out.printf("\nТест фиксированной цены:\nТовар: %s, Цена: %d руб.%n",
                product1.getName(), product1.getPrice());

        ProductBasket specialBasket = new ProductBasket();
        specialBasket.addProduct(new DiscountProduct("Смартфон", 30000, 15));
        specialBasket.addProduct(new FixPriceProduct("Подарочный сертификат"));
        specialBasket.addProduct(new SimpleProduct("Чайник", 2499));
        specialBasket.addProduct(new DiscountProduct("Наушники", 15000, 30));

        System.out.println("\nСпециальная корзина:");
        specialBasket.printBasket();
    }
}