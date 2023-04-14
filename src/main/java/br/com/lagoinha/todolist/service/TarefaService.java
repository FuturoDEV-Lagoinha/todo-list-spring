package br.com.lagoinha.todolist.service;

import br.com.lagoinha.todolist.entity.Tarefa;
import br.com.lagoinha.todolist.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvar(Tarefa tarefa) {
        return this.tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaPesquisada = this.tarefaRepository.findById(id);

        if(tarefaPesquisada.isPresent()) {
            BeanUtils.copyProperties(tarefaAtualizada, tarefaPesquisada.get(), "id");
            return this.tarefaRepository.save(tarefaPesquisada.get());
        }
        return null;
    }

    public Tarefa buscarPorId(Long id) {
        return this.tarefaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public List<Tarefa> listar() {
        return this.tarefaRepository.findAll();
    }

    public void deletar(Long id) {
        this.tarefaRepository.deleteById(id);
    }
}
