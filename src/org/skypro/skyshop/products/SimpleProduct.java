package org.skypro.skyshop.products;

public class SimpleProduct extends Product {
    private final double productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Неверно введена цена продукта");
        }
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
