package com.example.personalnotetaking.service;

import com.example.personalnotetaking.model.Remark;

import java.util.List;

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
public interface RemarkService {

    Remark addRemark(Remark remark);
    Remark getRemarkById(Long id);
    List<Remark> getAllRemarks();
    Remark updateRemark(Remark remark);
    void deleteRemark(Long id);
}
