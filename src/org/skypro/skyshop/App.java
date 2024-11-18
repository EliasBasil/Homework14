package org.skypro.skyshop;

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
    }
}
