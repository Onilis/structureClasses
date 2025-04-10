package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        } else {
            throw new NullPointerException("Поисковый объект не может быть null");
        }
    }

    public Searchable[] search(String query, int maxResults) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(searchable);
                if (results.size() == maxResults) {
                    break;
                }
            }
        }

        return results.toArray(new Searchable[0]);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
            int occurrences = countOccurrences(searchable.getSearchTerm(), search);
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден подходящий результат для поиска: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String search) {
        int occurrences = 0;
        int index = 0;

        while (true) {
            index = text.toLowerCase().indexOf(search.toLowerCase(), index);
            if (index == -1) {
                break;
            }
            occurrences++;
            index += search.length();
        }

        return occurrences;
    }
}
