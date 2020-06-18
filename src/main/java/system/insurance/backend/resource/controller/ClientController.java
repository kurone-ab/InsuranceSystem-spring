package system.insurance.backend.resource.controller;

import org.checkerframework.common.reflection.qual.GetClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import system.insurance.backend.exception.NoClientException;
import system.insurance.backend.resource.dto.ClientDTO;
import system.insurance.backend.resource.service.ClientService;

import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/registering/list")
    public Map<Integer, ClientDTO> findAllRegisteringClientList(){
        return this.clientService.findAllRegisteringClient();
    }

    @GetMapping("/registering/detail")
    public ResponseEntity<ClientDTO> getRegisteringClientDetail(@RequestParam(name = "id") int id) {
        try {
            return ResponseEntity.ok(this.clientService.getRegisteringClientDetail(id));
        } catch (NoClientException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
