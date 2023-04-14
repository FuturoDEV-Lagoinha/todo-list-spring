package br.com.lagoinha.todolist.controller;

import br.com.lagoinha.todolist.entity.Tarefa;
import br.com.lagoinha.todolist.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa salvar(@Valid @RequestBody Tarefa tarefa) {
        return this.tarefaService.salvar(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return this.tarefaService.atualizar(id, tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return this.tarefaService.listar();
    }

    @GetMapping("/{id}")
    private Tarefa buscarPorId(@PathVariable Long id) {
        return this.tarefaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        this.tarefaService.deletar(id);
    }
}
