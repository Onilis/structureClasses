package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentSize;

    public SearchEngine(int initialCapacity) {
        this.searchables = new Searchable[initialCapacity];
        this.currentSize = 0;
    }

    public void add(Searchable searchable) {
        if (currentSize < searchables.length) {
            searchables[currentSize++] = searchable;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;

        for (int i = 0; i < currentSize && found < 5; i++) {
            Searchable searchable = searchables[i];
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[found++] = searchable;
            }
        }

        return results;
    }
}
