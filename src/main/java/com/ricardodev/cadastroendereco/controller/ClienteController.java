package com.ricardodev.cadastroendereco.controller;

import com.ricardodev.cadastroendereco.model.Cliente;
import com.ricardodev.cadastroendereco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adiocionar ( @RequestBody Cliente cliente ) {
        Cliente user = clienteRepository.findByEmail(cliente.getEmail());
        if (user != null) {
            throw new RuntimeException("Impossivel realizar o cadastro!");
        }
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Cliente replace (@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
