package org.skypro.skyshop.content;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Название статьи не может быть пустым");
        }
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым");
        }
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return toString(); // Возвращает название + текст
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", title, text);
    }
}
