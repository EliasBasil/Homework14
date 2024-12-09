package org.skypro.skyshop.products;

import java.util.*;

public class ProductBasket {
    private LinkedList<Product> basket;

    public ProductBasket() {
        basket = new LinkedList<>();
    }

    public void addProduct(Product product) {
        basket.add(product);
    }

    public ArrayList<Product> removeProduct(String productName) {
        ArrayList<Product> result = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getProductName().equals(productName)) {
                result.add(element);
                iterator.remove();
            }
        }
        return result;
    }

    public double getTotalValue() {
        double sum = 0;
        for (Product product : basket) {
            sum += product.getProductPrice();
        }
        return sum;
    }

    public void printBasket() {
        System.out.println(this);
    }

    public boolean containsProduct(String productName) {
        for (Product product : basket) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearAll() {
        basket = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBasket that)) return false;
        return Objects.equals(basket, that.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basket);
    }

    @Override
    public String toString() {
        if (basket.isEmpty()) {
            return "в корзине пусто";
        }
        int specialProducts = 0;
        StringBuilder result = new StringBuilder();
        for (Product product : basket) {
            result.append(product.toString()).append("\n");
            if (product.isSpecial()) {
                specialProducts++;
            }
        }
        result.append("Итого: ").append(getTotalValue());
        result.append("\nСпециальных товаров: ").append(specialProducts);
        return result.toString();
    }
}

