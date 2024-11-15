package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket(5);
        Product cheese = new Product("сыр", 100);
        Product potatoes = new Product("картофель", 250);
        Product eggs = new Product("яйца", 70);
        Product milk = new Product("молоко", 40);
        Product chicken = new Product("курица", 300);
        Product tomatoes = new Product("помидоры", 140);

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
