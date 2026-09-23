package com.example.demo.service;

import com.example.demo.DTO.TaskRequestDTO;
import com.example.demo.DTO.TaskResponseDTO;
import com.example.demo.model.Tarefa;
import com.example.demo.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public TaskResponseDTO criar(TaskRequestDTO dto) {
        String titulo = TarefaDTO.titulo();
        Tarefa tarefa = new Tarefa((long)1.0,dto.titulo(),dto.descricao(),null, false);
        return toResponseDTO(salvar);
        System.out.println("[SERVICE] Validando regra de negócio para: " +
                titulo);
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        return repository.salvar(titulo.trim());
    }

    public List<TaskResponseDTO> listarTodas() {
        System.out.println("[SERVICE] Solicitando lista de tarefas ao repository");
        return repository.listarTodas().stream().map(this::toReponseDTO).toList();
    }

    public Tarefa buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }

    public List<Tarefa> listarConcluidos(){
        System.out.println("[SERVICE] solicitando lista de tarefas concluidas");
        List<Tarefa> tarefas = repository.listarTodas();
        List<Tarefa> tarefasConcluidas=new List<Tarefa>()

        for(tarefa in tarefas){
            if(tarefa.isConcluido()){
             tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

}