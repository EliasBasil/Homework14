package org.skypro.skyshop;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] basket = new Product[5];
    private int pointer = 0;


    public void addProduct(Product product) {
        if (pointer == 5) {
            System.out.println("Невозможно добавить продукт");
        } else {
            basket[pointer++] = product;
        }
    }

    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i < pointer; i++) {
            sum += basket[i].getProductPrice();
        }
        return sum;
    }

    public void printBasket() {
        System.out.println(this);
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < pointer; i++) {
            if (basket[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearAll() {
        for (int i = 0; i < pointer; i++) {
            basket[i] = null;
        }
        pointer = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket basket1 = (ProductBasket) o;
        return Arrays.equals(basket, basket1.basket);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(basket);
    }

    @Override
    public String toString() {
        if (pointer == 0) {
            return "в корзине пусто";
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < pointer; i++) {
                result.append(basket[i].toString()).append("\n");
            }
            result.append("Итого: ").append(getTotalValue());
            return result.toString();
        }
    }
}

