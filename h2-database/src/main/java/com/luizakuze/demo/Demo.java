package com.luizakuze.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * A entidade Demo representa um objeto com um identificador único e uma descrição.
 * Esta classe é mapeada para uma tabela no banco de dados usando JPA.
 * Em serviços web: Mapeamento Objeto-Relacional (ORM)
 */
@Entity
public class Demo {
    @Id
    Long id;
    String description;


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