package com.example.personalnotetaking.controller;

import com.example.personalnotetaking.model.Remark;
import com.example.personalnotetaking.service.RemarkService;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequiredArgsConstructor
@RequestMapping("/remark")
public class RemarkController {

    private final RemarkService service;
    private final Counter requestCounter = Metrics.counter("request_count");

    /**
     * Добавление заметки
     * @param remark
     * @return ResponseEntity<Remark>
     */
    @PostMapping
    public ResponseEntity<Remark> createRemark(@RequestBody Remark remark) {
        return new ResponseEntity<>(service.addRemark(remark), HttpStatus.CREATED);
    }

    /**
     * Просмотр всех заметок
     * @return ResponseEntity<List<Remark>>
     */
    @GetMapping
    public ResponseEntity<List<Remark>> getAllRemarks() {
        requestCounter.increment();
        return new ResponseEntity<>(service.getAllRemarks(), HttpStatus.OK);
    }

    /**
     * Редактирование заметки
     * @param remark
     * @return ResponseEntity<Remark>
     */
    @PutMapping
    public ResponseEntity<Remark> updateRemark(@RequestBody Remark remark) {
        return new ResponseEntity<>(service.updateRemark(remark), HttpStatus.OK);
    }

    /**
     * Удаление заметки
     * @param id
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRemark(@PathVariable("id") Long id) {
        service.deleteRemark(id);
        return ResponseEntity.ok().build();
    }

}
