package org.skypro.skyshop;

import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine {
    private final Searchable[] items;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
    }

    public Searchable[] search(String searchQuery) {
        int pointer = 0;
        Searchable[] result = new Searchable[5];
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase())) {
                result[pointer] = item;
                pointer++;
                if (pointer == 5) {
                    break;
                }
            }
        }
        return result;
    }

    public boolean add(Searchable searchable) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = searchable;
                return true;
            }
        }
        return false;
    }
}
