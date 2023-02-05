
package com.ricardodev.cadastroendereco.controller;

import com.ricardodev.cadastroendereco.model.Cliente;
import com.ricardodev.cadastroendereco.model.Endereco;
import com.ricardodev.cadastroendereco.repository.ClienteRepository;
import com.ricardodev.cadastroendereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }

    @PostMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar( @RequestBody Endereco endereco, @PathVariable Long idCliente ) {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        endereco.setCliente(cliente);
        return enderecoRepository.save(endereco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        enderecoRepository.deleteById(id);
    }

    @PutMapping
    public Endereco replace (@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}

