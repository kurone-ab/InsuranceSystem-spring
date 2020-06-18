package system.insurance.backend.resource.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/registered/search{name}")
    public ResponseEntity<ClientDTO> searchRegisteredByName(@PathVariable String name){
        return ResponseEntity.ok(this.clientService.searchRegisteredByName(name));
    }

    @GetMapping("/registered/search{contact}")
    public ResponseEntity<ClientDTO> searchRegisteredByContact(@PathVariable String contact){
        return ResponseEntity.ok(this.clientService.searchRegisteredByContact(contact));
    }

    @GetMapping("/registered/search{rrn}")
    public ResponseEntity<ClientDTO> searchRegisteredByRRN(@PathVariable String rrn){
        return ResponseEntity.ok(this.clientService.searchRegisteredByRRN(rrn));
    }
}
