import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Инициализация корзины
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Чай", 150));
        basket.addProduct(new SimpleProduct("Чай", 150));
        basket.addProduct(new FixPriceProduct("Кофе"));
        basket.addProduct(new DiscountProduct("Сахар", 100, 10));

        // Демонстрация корзины
        System.out.println("Содержимое корзины:");
        basket.printContents();
        System.out.println("Общая стоимость: " + basket.getTotalPrice() + " руб.");

        // Демонстрация поиска
        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Чай", 150));
        engine.add(new FixPriceProduct("Кофе"));
        engine.add(new Article("Как заваривать чай", "Инструкция..."));

        System.out.println("\nРезультаты поиска:");
        Map<String, Searchable> results = engine.search("чай");
        results.forEach((name, item) ->
                System.out.println(name + " (" + item.getContentType() + ")")
        );
    }
}
