import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Телевизор", 30000));
        basket.addProduct(new DiscountProduct("Смартфон", 50000, 10));
        basket.addProduct(new SimpleProduct("Телевизор", 35000));

        List<Product> removed = basket.removeProductsByName("Телевизор");
        System.out.println("Удаленные продукты:");
        removed.forEach(p -> System.out.println(p.getName()));
        basket.printBasket();

        removed = basket.removeProductsByName("Ноутбук");
        if(removed.isEmpty()) {
            System.out.println("Список пуст");
        }

        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Умные часы", 15000));
        engine.add(new Article("Обзор", "Новинки умных часов"));

        List<Searchable> results = engine.search("часы");
        System.out.println("\nРезультаты поиска:");
        results.forEach(r -> System.out.println(r.getStringRepresentation()));
    }
}
