package org.skypro.skyshop.articles;

import org.skypro.skyshop.utilities.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getSearchTerm() {
        return name;
    }

    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return name + "\n" + text + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
