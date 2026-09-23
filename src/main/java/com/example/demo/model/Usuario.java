package com.example.demo.model;

public record Usuario() {
    private static Long id;
    private static String nome;
    private static String email;
    private static String cargo;


    public Usuario(Long id, String nome, String email, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        System.out.println("Criando Usuario...");
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }
}

