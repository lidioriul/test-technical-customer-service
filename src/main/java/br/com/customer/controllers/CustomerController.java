package br.com.customer.controllers;

import br.com.customer.requests.CustomerRequest;
import br.com.customer.responses.CustomerResponse;
import br.com.customer.services.CustomerService;
import io.swagger.v3.oas.annotations.OpenAPI31;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Sucesso")
    )
    public ResponseEntity<?> save(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.save(customerRequest);
        return ResponseEntity.ok(customerResponse);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado")
            }
    )
    @PutMapping(value = "/{document}")
    public ResponseEntity<?> update(@PathVariable("document") String document,
                                    @RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.save(document, customerRequest);
        return ResponseEntity.ok(customerResponse);
    }

    @DeleteMapping(value = "/{document}")
    public ResponseEntity<?> delete(@PathVariable("document") String document) {
        return ResponseEntity.ok(customerService.delete(document));
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado")
            }
    )
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado")
            }
    )
    @GetMapping(value = "/byDocument")
    public ResponseEntity<?> findByDocument(@RequestParam("document") String document) {
        return ResponseEntity.ok(customerService.findByDocument(document));
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado")
            }
    )
    @GetMapping(value = "/byName")
    public ResponseEntity<?> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(customerService.findByName(name));
    }
}
