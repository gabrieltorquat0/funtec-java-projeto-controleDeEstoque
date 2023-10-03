package edu.funtec.controleDeEstoque.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;

import edu.funtec.controleDeEstoque.entity.Produto;
import edu.funtec.controleDeEstoque.repository.ProdutoRepository; 

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<?> adicionarProduto(@Valid @RequestBody Produto produto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());
    
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Erros de validação: " + String.join(", ", errors));
        }
        try {
            produtoRepository.save(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Produto adicionado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar o produto.");
        }
    }
    
    @GetMapping("/pesquisar")
    public ResponseEntity<List<Produto>> pesquisarProduto(
            @RequestParam(name = "tipoPesquisa") String tipoPesquisa,
            @RequestParam(name = "valorPesquisa") String valorPesquisa) {

        List<Produto> produtos = new ArrayList<>();

        // Pesquisa no banco de dados com base no tipoPesquisa e valorPesquisa
        if ("ID".equals(tipoPesquisa)) {
            try {
                Long id = Long.parseLong(valorPesquisa);
                produtos = produtoRepository.findByPesquisaPorId(id);
            } catch (NumberFormatException e) {
                // Lida com o caso em que valorPesquisa não é um número válido (trate como pesquisa vazia)
            }
        } else if ("Nome".equals(tipoPesquisa)) {
            produtos = produtoRepository.findByPesquisaPorNome(valorPesquisa);
        }

        return ResponseEntity.ok(produtos);
    }
} 
