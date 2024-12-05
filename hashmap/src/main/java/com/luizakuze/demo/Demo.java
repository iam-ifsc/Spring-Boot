package com.luizakuze.demo;

/**
 * A classe Demo representa um objeto com um identificador único e uma descrição.
 * Esta classe é usada para armazenar dados temporários em memória.
 */
public class Demo {
    private Long id; // Identificador único
    private String description; // Descrição do Demo

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
