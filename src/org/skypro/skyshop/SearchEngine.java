package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.ArrayList;

public class SearchEngine {
    private final ArrayList<Searchable> items;

    public SearchEngine(int size) {
        this.items = new ArrayList<>(size);
    }

    public ArrayList<Searchable> search(String searchQuery) {
        ArrayList<Searchable> result = new ArrayList<>();
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        Searchable result = null;
        int maxCount = 0;
        for (Searchable s : items) {
            int count = 0;
            int index = 0;
            int substringIndex = s.toString().toLowerCase().indexOf(search.toLowerCase(), index);
            while (substringIndex != -1) {
                count++;
                index = substringIndex + search.length();
                substringIndex = s.toString().toLowerCase().indexOf(search.toLowerCase(), index);
            }
            if (count > maxCount) {
                maxCount = count;
                result = s;
            }
        }
        if (result == null) {
            throw new BestResultNotFound("No results found for the query \"" + search + "\"");
        }
        return result;
    }

    public void add(Searchable searchable) {
        items.add(searchable);
    }
}
