package edu.funtec.controleDeEstoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.funtec.controleDeEstoque.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Consulta personalizada para pesquisar cliente por ID (Long)
    @Query("SELECT p FROM Cliente p WHERE p.id = :valorPesquisa")
    List<Cliente> findByPesquisaPorId(@Param("valorPesquisa") Long valorPesquisa);

    // Consulta personalizada para pesquisar cliente por Nome (String)
    @Query("SELECT p FROM Cliente p WHERE p.nome LIKE %:valorPesquisa%")
    List<Cliente> findByPesquisaPorNome(@Param("valorPesquisa") String valorPesquisa);
}
