package com.luizakuze.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * O repositório JPA para a entidade Demo. <p>
 * Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) no banco de dados. <p>
 * Em serviços web: Camada de Persistência
 */
public interface DemoRepository extends JpaRepository<Demo, Long> {
}
