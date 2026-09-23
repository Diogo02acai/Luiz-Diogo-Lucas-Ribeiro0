package com.example.demo.controller;

import com.example.demo.DTO.UsuarioRequestDTO;
import com.example.demo.DTO.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody UsuarioRequestDTO corpo) {
        UsuarioResponseDTO criada = UsuarioService.criar(corpo);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }
}
