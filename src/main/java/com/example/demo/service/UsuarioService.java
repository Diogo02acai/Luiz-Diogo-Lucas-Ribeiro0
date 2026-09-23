package com.example.demo.service;

import com.example.demo.DTO.UsuarioRequestDTO;
import com.example.demo.DTO.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final AtomicLong sequencia = new AtomicLong();

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        String nome = dto.nome();
        Usuario usuario = new Usuario(sequencia.incrementAndGet(),dto.nome(),dto.email(),null);
        System.out.println("[SERVICE] Validando regra de negócio para: " + nome);
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio.");
        }
        Usuario salva = repository.salvar(usuario);
        return new UsuarioResponseDTO(salva);
    }
}
