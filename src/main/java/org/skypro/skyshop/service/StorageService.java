package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service  // ← ЭТА АННОТАЦИЯ ВАЖНА!
public class StorageService {

    // Хранилище продуктов: ключ - UUID, значение - Product
    private final Map<UUID, Product> products;

    // Хранилище статей: ключ - UUID, значение - Article
    private final Map<UUID, Article> articles;

    // Конструктор
    public StorageService() {
        // Инициализируем пустые HashMap
        this.products = new HashMap<>();
        this.articles = new HashMap<>();

        // Заполняем тестовыми данными
        initTestData();
    }

    // Приватный метод для заполнения тестовыми данными
    private void initTestData() {
        // СОЗДАЕМ ТЕСТОВЫЕ ПРОДУКТЫ с UUID.randomUUID()

        // Простой товар (ноутбук)
        Product product1 = new SimpleProduct(
                UUID.randomUUID(),  // ← ГЕНЕРИРУЕМ УНИКАЛЬНЫЙ ID
                "Ноутбук",
                50000
        );

        // Товар со скидкой (мышь)
        Product product2 = new DiscountProduct(
                UUID.randomUUID(),  // ← ГЕНЕРИРУЕМ УНИКАЛЬНЫЙ ID
                "Мышь",
                1500,
                10
        );

        // Товар с фиксированной ценой (коврик)
        Product product3 = new FixPriceProduct(
                UUID.randomUUID(),  // ← ГЕНЕРИРУЕМ УНИКАЛЬНЫЙ ID
                "Коврик для мыши"
        );

        // Добавляем продукты в Map
        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);

        // СОЗДАЕМ ТЕСТОВЫЕ СТАТЬИ с UUID.randomUUID()

        Article article1 = new Article(
                UUID.randomUUID(),  // ← ГЕНЕРИРУЕМ УНИКАЛЬНЫЙ ID
                "Как выбрать ноутбук",
                "Советы по выбору идеального ноутбука для работы и игр"
        );

        Article article2 = new Article(
                UUID.randomUUID(),  // ← ГЕНЕРИРУЕМ УНИКАЛЬНЫЙ ID
                "Обзор игровых мышей",
                "Топ-5 лучших игровых мышей 2024 года"
        );

        // Добавляем статьи в Map
        articles.put(article1.getId(), article1);
        articles.put(article2.getId(), article2);
    }

    // Метод, возвращающий все продукты
    public Collection<Product> getAllProducts() {
        return products.values();  // values() возвращает Collection<Product>
    }

    // Метод, возвращающий все статьи
    public Collection<Article> getAllArticles() {
        return articles.values();  // values() возвращает Collection<Article>
    }
}