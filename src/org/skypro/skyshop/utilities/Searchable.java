package org.skypro.skyshop.utilities;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getContentType();
    }
}
