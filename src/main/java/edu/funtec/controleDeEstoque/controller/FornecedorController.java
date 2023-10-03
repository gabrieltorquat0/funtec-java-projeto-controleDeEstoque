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
import edu.funtec.controleDeEstoque.entity.Fornecedor;
import edu.funtec.controleDeEstoque.repository.FornecedorRepository; 

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping
    public ResponseEntity<?> adicionarFornecedor(@Valid @RequestBody Fornecedor fornecedor, BindingResult bindingResult) {
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
            fornecedorRepository.save(fornecedor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Fornecedor adicionado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar fornecedor.");
        }
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<Fornecedor>> pesquisarFornecedor(
            @RequestParam(name = "tipoPesquisa") String tipoPesquisa,
            @RequestParam(name = "valorPesquisa") String valorPesquisa) {

        List<Fornecedor> fornecedor = new ArrayList<>();

        // Pesquisa no banco de dados com base no tipoPesquisa e valorPesquisa
        if ("ID".equals(tipoPesquisa)) {
            try {
                Long id = Long.parseLong(valorPesquisa);
                fornecedor = fornecedorRepository.findByPesquisaPorId(id);
            } catch (NumberFormatException e) {
                // Lida com o caso em que valorPesquisa não é um número válido (trate como pesquisa vazia)
            }
        } else if ("Nome".equals(tipoPesquisa)) {
            fornecedor = fornecedorRepository.findByPesquisaPorNome(valorPesquisa);
        }

        return ResponseEntity.ok(fornecedor);
    }
} 
