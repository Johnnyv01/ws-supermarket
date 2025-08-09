package br.supermerkat.supermerkat.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIReturnResponse<T> {
    private boolean success;
    private T data;
    private String message;
    private String timestamp;
    private Exception exception;

    public static <T> APIReturnResponse<T> create(T data) {
        return new APIReturnResponse<>(
                true,
                data,
                "message",
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")),
                null
        );
    }

    public static <T> APIReturnResponse<T> delete(T data) {
        return new APIReturnResponse<>(
                true,
                data,
                "message",
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")),
                null
        );
    }

    public static <T> APIReturnResponse<T> findById(UUID id) {
        return new APIReturnResponse<>(
                true,
                null,
                "message",
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                null
        );
    }

    public static <T> APIReturnResponse<T> update(T data) {
        return new APIReturnResponse<>(
                true,
                data,
                "message",
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")),
                null
        );
    }

    public static <T> APIReturnResponse<T> get(T data) {
        return new APIReturnResponse<>(
                true,
                data,
                "message",
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")),
                null
        );
    }

    public static APIReturnResponse<Void> error(Exception exception) {
        return new APIReturnResponse<>(
                false,
                null,
                "Erro na requisição: " + exception.getMessage(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")),
                exception
        );
    }


}
