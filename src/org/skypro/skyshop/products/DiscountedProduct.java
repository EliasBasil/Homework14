package org.skypro.skyshop.products;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, discount);
    }

    @Override
    public double getProductPrice() {
        return basePrice * (1 - discount / 100.0d);
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + " (" + getDiscount() + "%)";
    }


}
