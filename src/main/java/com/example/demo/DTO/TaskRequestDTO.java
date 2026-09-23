package com.example.demo.DTO;

import java.time.LocalDate;

public record TaskRequestDTO(
        String titulo,
        String descricao,
        LocalDate prazo
) {
}
