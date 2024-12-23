package org.skypro.skyshop.utilities;

import java.util.Comparator;

public class SearchEngineComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        Integer o1Length = o1.getSearchTerm().length();
        Integer o2Length = o2.getSearchTerm().length();
        if (o2Length.compareTo(o1Length) == 0) {
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        } else {
            return o2Length.compareTo(o1Length);
        }
    }
}
