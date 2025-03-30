package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(20);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Яблоко", 52));
        basket.addProduct(new SimpleProduct("Банан", 73));
        basket.addProduct(new SimpleProduct("Апельсин", 64));
        basket.addProduct(new SimpleProduct("Виноград", 85));
        basket.addProduct(new SimpleProduct("Дыня", 91));

        for (int i = 0; i < basket.size(); i++) {
            engine.add(basket.getProducts()[i]);
        }

        engine.add(new Article("Как выбрать смартфон", "Советы по выбору мобильного телефона"));
        engine.add(new Article("Подарочные наборы", "Инструкция по оформлению подарочных сертификатов"));
        engine.add(new Article("Скидки и акции", "Как участвовать в распродажах"));

        System.out.println("\nТест поиска по товарам:");
        System.out.println(Arrays.toString(engine.search("яблоко")));

        System.out.println("\nТест поиска по статьям:");
        System.out.println(Arrays.toString(engine.search("подарочные")));

        System.out.println("\nТест поиска по нескольким типам:");
        System.out.println(Arrays.toString(engine.search("с")));

        System.out.println("\nТест поиска с пустым результатом:");
        System.out.println(Arrays.toString(engine.search("не существует")));
    }
}
