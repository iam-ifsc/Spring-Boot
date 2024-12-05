package com.luizakuze.demo;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repositório em memória para a entidade Demo.
 * Simula operações CRUD usando um HashMap.
 */
@Repository
public class DemoRepository {
    private final Map<Long, Demo> demoStore = new HashMap<>(); 
    private final AtomicLong idCounter = new AtomicLong(1);

    /**
     * Busca uma entidade Demo pelo ID.
     *
     * @param id o ID da entidade Demo a ser buscada
     * @return um Optional contendo a entidade Demo, caso exista, ou vazio se não encontrada
     */
    public Optional<Demo> findById(Long id) {
        return Optional.ofNullable(demoStore.get(id));
    }

    /**
     * Salva uma entidade Demo no repositório.
     * Se a entidade não possui um ID, um novo ID único é gerado.
     *
     * @param demo a entidade Demo a ser salva
     * @return a entidade Demo salva no repositório
     */
    public Demo save(Demo demo) {
        if (demo.getId() == null) {
            long id = idCounter.getAndIncrement();
            demo.setId(id);
        }
        demoStore.put(demo.getId(), demo);
        return demo;
    }

    /**
     * Verifica se uma entidade Demo existe no repositório pelo ID.
     *
     * @param id o ID da entidade Demo a ser verificada
     * @return true se a entidade existe, false caso contrário
     */
    public boolean existsById(Long id) {
        return demoStore.containsKey(id);
    }

    /**
     * Exclui uma entidade Demo pelo ID.
     *
     * @param id o ID da entidade Demo a ser excluída
     * @return true se a entidade foi excluída, false se o ID não foi encontrado
     */
    public boolean deleteById(Long id) {
        return demoStore.remove(id) != null;
    }

    /**
     * Retorna todas as entidades Demo armazenadas no repositório.
     *
     * @return uma lista contendo todas as entidades Demo
     */
    public List<Demo> findAll() {
        return new ArrayList<>(demoStore.values());
    }
}
