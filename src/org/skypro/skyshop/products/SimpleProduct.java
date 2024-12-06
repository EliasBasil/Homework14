package org.skypro.skyshop.products;

public class SimpleProduct extends Product {
    private final double productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice();
    }


}
