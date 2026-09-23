package com.example.demo.DTO;

import com.example.demo.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cargo
){}
