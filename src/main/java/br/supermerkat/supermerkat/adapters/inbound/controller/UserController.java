package br.supermerkat.supermerkat.adapters.inbound.controller;

import br.supermerkat.supermerkat.domain.model.request.UsersRequestDTO;
import br.supermerkat.supermerkat.domain.model.response.UsersResponseDTO;
import br.supermerkat.supermerkat.domain.ports.inbound.UsersServicePort;
import br.supermerkat.supermerkat.util.api.ResponseAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersServicePort usersServicePort;

    public UserController(UsersServicePort usersServicePort) {
        this.usersServicePort = usersServicePort;
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<UsersResponseDTO>> create(
            @RequestBody UsersRequestDTO request
    ) {
        ResponseAPI<UsersResponseDTO> usersResponseDTO = usersServicePort.create(request);
        return new ResponseEntity<>(usersResponseDTO, usersResponseDTO.getStatus());
    }

    @GetMapping
    public ResponseEntity<ResponseAPI<List<UsersResponseDTO>>> findAll() {
        ResponseAPI<List<UsersResponseDTO>> userResponseDTOAll = usersServicePort.findAll();
        return new ResponseEntity<>(userResponseDTOAll, userResponseDTOAll.getStatus());
    }
}
