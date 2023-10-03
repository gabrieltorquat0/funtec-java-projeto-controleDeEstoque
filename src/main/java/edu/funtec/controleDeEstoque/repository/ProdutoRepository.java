package edu.funtec.controleDeEstoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.funtec.controleDeEstoque.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { 
    
    // Consulta personalizada para pesquisar produtos por ID (Long)
    @Query("SELECT p FROM Produto p WHERE p.id = :valorPesquisa")
    List<Produto> findByPesquisaPorId(@Param("valorPesquisa") Long valorPesquisa);

    // Consulta personalizada para pesquisar produtos por Nome (String)
    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:valorPesquisa%")
    List<Produto> findByPesquisaPorNome(@Param("valorPesquisa") String valorPesquisa);
}
