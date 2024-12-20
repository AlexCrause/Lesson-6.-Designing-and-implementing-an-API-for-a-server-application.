package com.example.personalnotetaking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Домашнее задание:
 *
 * Условие:
 * Разработайте небольшое веб-приложение на Spring Boot,
 * которое будет представлятьиз себя сервис для учета личных заметок.
 *
 * Приложение должно поддерживать
 * следующие функции:
 *
 * 1. Добавление заметки.
 * 2. Просмотр всех заметок.
 * 3. Редактирование заметки.
 * 4. Удаление заметки.
 *
 * Структура заметки:
 * - ID (автоинкрементное)
 * - Заголовок (не может быть пустым)
 * - Содержимое (не может быть пустым)
 * - Дата создания (автоматически устанавливается при создании заметки)
 */
@Data
@Entity
public class Remark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime date;

    public Remark() {
        this.date = LocalDateTime.now();
    }
}
