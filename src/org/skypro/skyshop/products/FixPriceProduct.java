package org.skypro.skyshop.products;

public class FixPriceProduct extends Product {
    private static final double PRODUCT_PRICE = 50;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public double getProductPrice() {
        return PRODUCT_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + getProductPrice();
    }
}
