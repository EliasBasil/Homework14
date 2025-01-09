package org.skypro.skyshop.products;

import org.skypro.skyshop.utilities.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Неверно введено название продукта");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
