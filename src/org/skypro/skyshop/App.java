package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.utilities.Searchable;
import org.skypro.skyshop.products.*;

import java.util.ArrayList;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

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

        System.out.println();
        basket.printBasket();

        System.out.println();
        System.out.println(basket.getTotalValue());

        System.out.println();
        System.out.println(basket.containsProduct("молоко"));
        System.out.println(basket.containsProduct("шоколад"));

        System.out.println();
        ArrayList<Product> removedProducts = basket.removeProduct("картофель");
        System.out.println(removedProducts);
        System.out.println();
        basket.printBasket();
        ArrayList<Product> removeNonexistentProduct = basket.removeProduct("шоколад");
        System.out.println();
        if (removeNonexistentProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println();
        basket.printBasket();

        System.out.println();
        basket.clearAll();
        basket.printBasket();
        System.out.println(basket.getTotalValue());
        System.out.println(basket.containsProduct("молоко"));
        System.out.println(basket.containsProduct("шоколад"));
        System.out.println();

        Article cheeseArticle = new Article("Статья про сыр", "Сыр - это очень вкусно");
        Article badCheeseArticle = new Article("Опровержение!", "Сыр - это ужасно");
        Article anotherCheeseArticle = new Article("Это - статья про сыр №2", "Больше сыра богу сыра");
        Article yetAnotherCheeseArticle = new Article("Еще одна статья про сыр", "Добавьте к нему помидоры");
        Article tomatoArticle = new Article("Статья про помидоры", "Они еще вкуснее, чем эти моцареллы и бри");
        Article milkArticle = new Article("Статья про молоко", "Я просто статья про молоко");

        SearchEngine engine = new SearchEngine();
        engine.add(cheese);
        engine.add(potatoes);
        engine.add(eggs);
        engine.add(milk);
        engine.add(tomatoes);
        engine.add(cheeseArticle);
        engine.add(badCheeseArticle);
        engine.add(anotherCheeseArticle);
        engine.add(yetAnotherCheeseArticle);
        engine.add(tomatoArticle);
        engine.add(milkArticle);

        TreeSet<Searchable> searchResult = engine.search("сыр");
        for (Searchable searchable : searchResult) {
            System.out.println(searchable);
        }
        System.out.println();
        searchResult = engine.search("помидор");
        for (Searchable searchable : searchResult) {
            System.out.println(searchable);
        }
        System.out.println();
        searchResult = engine.search("молоко");
        for (Searchable searchable : searchResult) {
            System.out.println(searchable);
        }
        System.out.println();

        try {
            Product wrongPriceProduct = new SimpleProduct("оливки", -50);
            System.out.println(wrongPriceProduct);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product wrongNameProduct = new SimpleProduct("   ", 50);
            System.out.println(wrongNameProduct);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product wrongDiscountProduct = new DiscountedProduct("оливки", 50, -2);
            System.out.println(wrongDiscountProduct);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            System.out.println(engine.findBestResult("сыр"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(engine.findBestResult("помидор"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            System.out.println(engine.findBestResult("молоко"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(engine.findBestResult("фейхоа"));
            System.out.println();
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
