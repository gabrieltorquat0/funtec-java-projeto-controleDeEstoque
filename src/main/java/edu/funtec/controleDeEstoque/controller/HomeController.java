package edu.funtec.controleDeEstoque.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.funtec.controleDeEstoque.entity.*;
import edu.funtec.controleDeEstoque.repository.*;
import edu.funtec.controleDeEstoque.service.SistemaDeLogin;

@Controller
public class HomeController { 
 
    @Autowired 
    private ProdutoRepository produtoRepository; 

    private SistemaDeLogin sistemaDeLogin = new SistemaDeLogin();

    @GetMapping("/index")
    public String home(Model model, @RequestParam(required = false) boolean loginError) {
        if (!loginError) {
            // Apenas mostrar a página de login se não houver erro de login
            return "produtos";
        }

        List<Produto> produto = produtoRepository.findAll();
        model.addAttribute("produto", produto);
        return "main";
    }

    @PostMapping("/index")
    public String fazerLogin(@RequestParam String email, @RequestParam String senha, Model model) {
        if (sistemaDeLogin.autenticarUsuario(email, senha)) {
            List<Produto> produto = produtoRepository.findAll();
            model.addAttribute("produto", produto);
            return "main"; // Redirecionar para a página principal após o login bem-sucedido
        } else {
            return "redirect:/"; // Redirecionar de volta para a página de login
        }
    }

    @GetMapping("/produtos")
    public String showProdutosPage(Model model) {
        List<Produto> produtos = produtoRepository.findAll(); 

		model.addAttribute("produtos", produtos);
        
        return "produtos";
    }

    @Autowired 
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String showClientePage(Model model) {
        List<Cliente> clientes = clienteRepository.findAll(); 

		model.addAttribute("clientes", clientes);

        return "clientes";
    }

    @Autowired 
    private FornecedorRepository fornecedorRepository;

    @GetMapping("/fornecedores")
    public String showFornecedoresPage(Model model) {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll(); 

		model.addAttribute("fornecedores", fornecedores);

        return "fornecedores";
    }
} 
