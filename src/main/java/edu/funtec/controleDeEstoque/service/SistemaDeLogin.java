package edu.funtec.controleDeEstoque.service;

import edu.funtec.controleDeEstoque.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeLogin {
    private List<Usuario> usuarios = new ArrayList<>();

    public SistemaDeLogin() {
        // Adicione os usuários válidos aqui
        usuarios.add(new Usuario("gabrielviniciust@hotmail.com", "aluno123"));
        usuarios.add(new Usuario("usuario2@example.com", "senha456"));
        usuarios.add(new Usuario("usuario3@example.com", "senha789"));
    }

    public boolean autenticarUsuario(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return true; // Usuário autenticado com sucesso
            }
        }
        return false; // Credenciais inválidas
    }
}
