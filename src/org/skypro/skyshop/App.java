import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        SearchEngine engine = new SearchEngine();

// Добавляем статьи
        engine.add(new Article("Новости", "Сегодня произошло важное событие"));
        engine.add(new Article("Обзор", "Новый смартфон поражает"));

// Добавляем продукты
        engine.add(new SimpleProduct("Мышь", 999.99));
        engine.add(new SimpleProduct("Клавиатура", 2999.50));

// Поиск
        Set<Searchable> results = engine.search("нов");
        results.forEach(System.out::println);
    }
}
