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

    /**
     * Construtor para injetar o serviço DemoService.
     * 
     * @param demoService o serviço para manipular operações de CRUD para a entidade Demo
     */
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

    /**
     * Endpoint para criar um novo Demo.
     *
     * @param demo o objeto Demo a ser criado
     * @return ResponseEntity contendo a entidade Demo criada e status 201 (Created), 
     *         ou status 400 (Bad Request) se o ID estiver ausente ou inválido
     */
    @PostMapping
    public ResponseEntity<Demo> createDemo(@RequestBody Demo demo) {
        if (demo.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Demo createdDemo = demoService.createDemo(demo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDemo);
    }

    /**
     * Endpoint para atualizar um Demo existente.
     *
     * @param id o ID da entidade Demo a ser atualizada
     * @param demo o objeto Demo contendo as novas informações
     * @return ResponseEntity contendo a entidade Demo atualizada e status 200 (OK), 
     *         ou status 400 (Bad Request) se o ID no caminho não corresponder ao ID no corpo,
     *         ou status 404 (Not Found) se o Demo não for encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Demo> updateDemo(@PathVariable("id") Long id, @RequestBody Demo demo) {  // @RequestBody indica que o corpo da requisição será convertido para um objeto Demo
        if (!id.equals(demo.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<Demo> updatedDemo = demoService.updateDemo(id, demo);
        return updatedDemo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para excluir um Demo pelo ID.
     *
     * @param id o ID da entidade Demo a ser excluída
     * @return ResponseEntity com status 204 (No Content) se a exclusão for bem-sucedida,
     *         ou status 404 (Not Found) se o Demo não for encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemo(@PathVariable("id") Long id) {
        if (demoService.deleteDemo(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
