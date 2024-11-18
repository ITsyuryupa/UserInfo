package itsyuryupa.userinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Обработчик для исключений валидации
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        // Перебираем все ошибки поля и добавляем их в карту
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage()); // Получаем имя поля и сообщение ошибки
        }

        response.put("errors", errors); // Добавляем ошибочные поля в ответ
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // Возвращаем ответ с ошибками и кодом 400
    }

    // Обработчик для ResponseStatusException, который у вас уже есть
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleException(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }
}


