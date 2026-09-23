package com.example.demo.DTO;

public record TaskResponseDTO(
        Long id,
        String titulo,
        boolean concluido,
        String prioridade
) {}
