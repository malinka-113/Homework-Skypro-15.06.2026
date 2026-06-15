package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();  // Возвращает текст для поиска
    String getContentType(); // Возвращает тип контента (PRODUCT или ARTICLE)
    UUID getId();
}
