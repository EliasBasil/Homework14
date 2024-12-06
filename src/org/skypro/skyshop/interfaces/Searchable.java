package org.skypro.skyshop.interfaces;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getContentType();
    }
}
