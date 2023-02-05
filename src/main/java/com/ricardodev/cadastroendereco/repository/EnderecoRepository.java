
package com.ricardodev.cadastroendereco.repository;


import com.ricardodev.cadastroendereco.model.Cliente;
import com.ricardodev.cadastroendereco.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {
    Endereco findByCliente(Cliente cliente);
}
