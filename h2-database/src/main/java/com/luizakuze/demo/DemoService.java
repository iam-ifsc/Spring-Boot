package com.luizakuze.demo;

import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * O serviço que fornece a lógica de negócios para a entidade Demo.
 * Utiliza o repositório DemoRepository para interagir com o banco de dados.
 */
@Service
public class DemoService {
    private final DemoRepository demoRepository; 
    
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    /**
     * Obter um Demo pelo ID.
     *
     * @param id o ID da entidade Demo a ser obtida
     * @return um Optional contendo a entidade Demo, caso exista
     */
    public Optional<Demo> getDemo(Long id) {
        return demoRepository.findById(id);
    }
}
