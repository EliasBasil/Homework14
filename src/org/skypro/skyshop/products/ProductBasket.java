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
        double sum = 0;
        for (Map.Entry<String, ArrayList<Product>> entry : basket.entrySet()) {
            for (Product product : entry.getValue()) {
                sum += product.getProductPrice();
            }
        }
        return sum;
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
        int specialProducts = 0;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, ArrayList<Product>> entry : basket.entrySet()) {
            for (Product product : entry.getValue()) {
                result.append(product.toString()).append("\n");
                if (product.isSpecial()) {
                    specialProducts++;
                }
            }
        }
        result.append("Итого: ").append(getTotalValue());
        result.append("\nСпециальных товаров: ").append(specialProducts);
        return result.toString();
    }
}

