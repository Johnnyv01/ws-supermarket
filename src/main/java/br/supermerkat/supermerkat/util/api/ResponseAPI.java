package br.supermerkat.supermerkat.util.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAPI<T> {

    private String message;
    private HttpStatus status;
    private T object;
    private String sendDateTime;

    public static <T> ResponseAPI<T> salvar(T object) {
        return ResponseAPI.<T>builder()
                .message(String.format("Entidade %s foi cadastrado com sucesso no sistema!",
                        object.getClass().getSimpleName().replace("ResponseDTO", "")
                ))
                .status(HttpStatus.OK)
                .object(object)
                .build();
    }

    public static <T> ResponseAPI<T> delete(UUID id, T object) {
        return ResponseAPI.<T>builder()
                .message(String.format("Entidade com o código %s foi deletado com sucesso!", id))
                .status(HttpStatus.OK)
                .object(object)
                .build();
    }

    public static <T> ResponseAPI<T> getId(UUID uuid, T object) {
        return ResponseAPI.<T>builder()
                .message(String.format("Entidade com o código %s foi retornada com sucesso!", uuid))
                .status(HttpStatus.OK)
                .object(object)
                .build();
    }

    public static <T> ResponseAPI<List<T>> get(List<T> objects) {
        return ResponseAPI.<List<T>>builder()
                .message(String.format("Busca realizada com sucesso na tabela %s!",
                        objects.get(0).getClass().getSimpleName().replace("ResponseDTO", "")
                ))
                .status(HttpStatus.OK)
                .object(objects)
                .build();
    }
}
