package com.luizakuze.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador REST para a entidade Demo. <p>
 * Fornece endpoints para interagir com o serviço DemoService, permitindo operações CRUD.
 */
@RestController // contralador REST permite lidar com requisições http
@RequestMapping("/demo") // para onde vai todas as requisições
public class DemoController {
    private final DemoService demoService; 
    
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    /**
     * Endpoint para consultar um Demo pelo ID.
     *
     * @param id o ID da entidade Demo a ser consultada
     * @return ResponseEntity contendo a entidade Demo e status 200 (OK) se encontrada, 
     *         ou status 404 (Not Found) se não encontrada
     */
    @GetMapping("/{id}") 
    public ResponseEntity<Demo> getDemo(@PathVariable("id") Long id) { // @PathVariable associa o valor do caminho da URL (id) ao parâmetro "id" do método
        Optional<Demo> demo = demoService.getDemo(id);
        return demo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); 
    }
}
