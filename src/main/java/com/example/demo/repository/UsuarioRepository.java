package com.example.demo.repository;

import com.example.demo.model.Tarefa;
import com.example.demo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class UsuarioRepository {
    private final Map<Long, Usuario> banco = new LinkedHashMap<>();

    public Usuario salvar(Usuario usuario) {
        System.out.println("[REPOSITORY] Salvando usuário em memória: " + usuario.getNome());
        banco.put(usuario.getId(),usuario);
        return usuario;
    }
}
