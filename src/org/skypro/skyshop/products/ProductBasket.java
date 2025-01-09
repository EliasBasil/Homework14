package org.skypro.skyshop.products;

import java.util.*;

public class ProductBasket {
    private HashMap<String, ArrayList<Product>> basket;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getProductName();
        if (basket.containsKey(productName)) {
            basket.get(productName).add(product);
        } else {
            ArrayList<Product> products = new ArrayList<>();
            products.add(product);
            basket.put(productName, products);
        }
    }

    public ArrayList<Product> removeProduct(String productName) {
        ArrayList<Product> result = new ArrayList<>();
        if (basket.containsKey(productName)) {
            result = basket.remove(productName);
        }
        return result;
    }

    public double getTotalValue() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getProductPrice)
                .sum();
    }

    public void printBasket() {
        System.out.println(this);
    }

    public boolean containsProduct(String productName) {
        return basket.containsKey(productName);
    }

    public void clearAll() {
        basket = new HashMap<>();
    }

    @Override
    public String toString() {
        if (basket.isEmpty()) {
            return "в корзине пусто";
        }
        StringBuilder result = new StringBuilder();
        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(p -> result.append(p.toString()).append("\n"));
        result.append("Итого: ").append(getTotalValue());
        result.append("\nСпециальных товаров: ").append(getSpecialCount());
        return result.toString();
    }

    private int getSpecialCount() {
        return (int) basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }
}

