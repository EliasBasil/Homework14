package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.utilities.SearchEngineComparator;
import org.skypro.skyshop.utilities.Searchable;

import java.util.HashSet;
import java.util.TreeSet;

public class SearchEngine {
    private final HashSet<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public TreeSet<Searchable> search(String searchQuery) {
        TreeSet<Searchable> result = new TreeSet<>(new SearchEngineComparator());
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
