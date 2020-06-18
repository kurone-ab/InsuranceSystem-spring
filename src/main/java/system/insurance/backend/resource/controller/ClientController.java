package system.insurance.backend.resource.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.insurance.backend.exception.NoClientException;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.dto.ClientDTO;
import system.insurance.backend.resource.service.ClientService;
import system.insurance.backend.resource.service.MailService;
import system.insurance.backend.resource.service.SalesService;

import javax.mail.MessagingException;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final SalesService salesService;
    private final MailService mailService;

    public ClientController(ClientService clientService, SalesService salesService, MailService mailService) {
        this.clientService = clientService;
        this.salesService = salesService;
        this.mailService = mailService;
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

    @PostMapping("/new/register")
    public boolean newClient(@RequestParam(name = "content") String content, @RequestParam(name = "eid")int eid, @RequestParam(name = "email")String email) {
        try {
            this.mailService.sendMail(email);
            return this.salesService.saveCounselingRecord(content, eid);
        } catch (NoEmployeeException | MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
