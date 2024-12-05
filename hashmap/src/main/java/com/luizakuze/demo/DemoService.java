package com.luizakuze.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço que fornece a lógica de negócios para a entidade Demo.
 * Utiliza o repositório DemoRepository para interagir com os dados.
 */
@Service
public class DemoService {
    private final DemoRepository demoRepository;

    /**
     * Construtor que injeta o repositório DemoRepository.
     *
     * @param demoRepository o repositório que fornece operações de CRUD para a entidade Demo
     */
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    /**
     * Busca uma entidade Demo pelo ID.
     *
     * @param id o ID da entidade Demo a ser buscada
     * @return um Optional contendo a entidade Demo, caso exista, ou vazio se não encontrada
     */
    public Optional<Demo> getDemo(Long id) {
        return demoRepository.findById(id);
    }

    /**
     * Cria uma nova entidade Demo.
     *
     * @param demo a entidade Demo a ser criada
     * @return a entidade Demo criada e salva no repositório
     */
    public Demo createDemo(Demo demo) {
        return demoRepository.save(demo);
    }

    /**
     * Atualiza uma entidade Demo existente.
     * Se o ID não existir, retorna um Optional vazio.
     *
     * @param id o ID da entidade Demo a ser atualizada
     * @param demo o objeto Demo contendo as novas informações
     * @return um Optional contendo a entidade Demo atualizada, ou vazio se o ID não foi encontrado
     */
    public Optional<Demo> updateDemo(Long id, Demo demo) {
        if (demoRepository.existsById(id)) {
            demo.setId(id);
            return Optional.of(demoRepository.save(demo));
        }
        return Optional.empty();
    }

    /**
     * Exclui uma entidade Demo pelo ID.
     *
     * @param id o ID da entidade Demo a ser excluída
     * @return true se a exclusão foi bem-sucedida, false se o ID não foi encontrado
     */
    public boolean deleteDemo(Long id) {
        return demoRepository.deleteById(id);
    }

    /**
     * Retorna todas as entidades Demo armazenadas no repositório.
     *
     * @return uma lista contendo todas as entidades Demo
     */
    public List<Demo> getAllDemos() {
        return demoRepository.findAll();
    }
}
