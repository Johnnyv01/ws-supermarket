package br.supermerkat.supermerkat.util.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnResponse {

    private String message;
    private HttpStatus status;
    private Object object;
    private String sendDateTime;
}
