package org.skypro.skyshop.products;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private final int basketSize;
    private final Product[] basket;
    private int pointer = 0;

    public ProductBasket(int basketSize) {
        this.basketSize = basketSize;
        basket = new Product[basketSize];
    }

    public void addProduct(Product product) {
        if (pointer == basketSize) {
            System.out.println("Невозможно добавить продукт");
        } else {
            basket[pointer++] = product;
        }
    }

    public double getTotalValue() {
        double sum = 0;
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
        int result = Objects.hash(basketSize, pointer);
        result = 31 * result + Arrays.hashCode(basket);
        return result;
    }

    @Override
    public String toString() {
        if (pointer == 0) {
            return "в корзине пусто";
        }
        int specialProducts = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pointer; i++) {
            result.append(basket[i].toString()).append("\n");
            if (basket[i].isSpecial()) {
                specialProducts++;
            }
        }
        result.append("Итого: ").append(getTotalValue());
        result.append("\nСпециальных товаров: ").append(specialProducts);
        return result.toString();
    }
}

