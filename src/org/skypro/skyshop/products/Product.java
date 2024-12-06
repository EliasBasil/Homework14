package org.skypro.skyshop.products;

import org.skypro.skyshop.interfaces.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract double getProductPrice();

    public abstract boolean isSpecial();

    public String getSearchTerm() {
        return productName;
    }

    public String getContentType() {
        return "PRODUCT";
    }
}
