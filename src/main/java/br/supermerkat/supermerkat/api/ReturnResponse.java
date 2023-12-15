package br.supermerkat.supermerkat.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ReturnResponse {

    private String message;
    private HttpStatus status;
    private Object object;
    private String sendDateTime;
}
