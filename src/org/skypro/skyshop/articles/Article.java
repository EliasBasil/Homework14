package org.skypro.skyshop.articles;

import org.skypro.skyshop.interfaces.Searchable;

public class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getSearchTerm() {
        return toString();
    }

    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return name + "\n" + text + "\n";
    }
}
