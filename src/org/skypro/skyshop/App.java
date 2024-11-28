package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.products.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket(5);
        Product cheese = new SimpleProduct("сыр", 100);
        Product potatoes = new DiscountedProduct("картофель", 250, 20);
        Product eggs = new DiscountedProduct("яйца", 70, 50);
        Product milk = new FixPriceProduct("молоко");
        Product chicken = new SimpleProduct("курица", 300);
        Product tomatoes = new SimpleProduct("помидоры", 140);

        basket.addProduct(cheese);
        basket.addProduct(potatoes);
        basket.addProduct(eggs);
        basket.addProduct(milk);
        basket.addProduct(chicken);
        basket.addProduct(tomatoes);

        System.out.println();
        basket.printBasket();

        System.out.println();
        System.out.println(basket.getTotalValue());

        System.out.println();
        System.out.println(basket.containsProduct("молоко"));
        System.out.println(basket.containsProduct("шоколад"));

        System.out.println();
        basket.clearAll();
        basket.printBasket();
        System.out.println(basket.getTotalValue());
        System.out.println(basket.containsProduct("молоко"));
        System.out.println(basket.containsProduct("шоколад"));
        System.out.println();

        Article cheeseArticle = new Article("Статья про сыр", "Сыр - это очень вкусно");
        Article badCheeseArticle = new Article("Опровержение!", "Сыр - это ужасно");
        Article anotherCheeseArticle = new Article("Еще одна статья про сыр", "Добавьте к нему помидоры");
        Article tomatoArticle = new Article("Статья про помидоры", "Они еще вкуснее, чем эти моцареллы и бри");
        Article milkArticle = new Article("Статья про молоко", "Я просто статья про молоко");

        SearchEngine engine = new SearchEngine(10);
        engine.add(cheese);
        engine.add(potatoes);
        engine.add(eggs);
        engine.add(milk);
        engine.add(tomatoes);
        engine.add(cheeseArticle);
        engine.add(badCheeseArticle);
        engine.add(anotherCheeseArticle);
        engine.add(tomatoArticle);
        engine.add(milkArticle);

        System.out.println(Arrays.toString(engine.search("сыр")));
        System.out.println();
        System.out.println(Arrays.toString(engine.search("помидор")));
        System.out.println();
        System.out.println(Arrays.toString(engine.search("молоко")));
    }
}
