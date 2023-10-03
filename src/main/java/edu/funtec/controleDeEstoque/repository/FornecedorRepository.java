package edu.funtec.controleDeEstoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.funtec.controleDeEstoque.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> { 
    // Consulta personalizada para pesquisar fornecedor por ID (Long)
    @Query("SELECT p FROM Fornecedor p WHERE p.id = :valorPesquisa")
    List<Fornecedor> findByPesquisaPorId(@Param("valorPesquisa") Long valorPesquisa);

    // Consulta personalizada para pesquisar fornecedor por Nome (String)
    @Query("SELECT p FROM Fornecedor p WHERE p.nome LIKE %:valorPesquisa%")
    List<Fornecedor> findByPesquisaPorNome(@Param("valorPesquisa") String valorPesquisa);
}
