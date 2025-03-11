package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.utilities.SearchEngineComparator;
import org.skypro.skyshop.utilities.Searchable;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public Set<Searchable> search(String searchQuery) {
        return items.stream()
                .filter(p -> p.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchEngineComparator())));
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
