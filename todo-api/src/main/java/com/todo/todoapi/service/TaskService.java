package com.todo.todoapi.service;

import com.todo.todoapi.model.Task;
import com.todo.todoapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    
    private final TaskRepository taskRepository;
    
    // Método para criar uma nova tarefa
    public Task createTask(Task task) {
        log.info("Criando nova tarefa: {}", task.getTitle());
        
        // Validações básicas de negócio
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("O título da tarefa é obrigatório");
        }
        
        if (task.getTitle().length() > 100) {
            throw new IllegalArgumentException("O título não pode ter mais de 100 caracteres");
        }
        
        // Garante que a tarefa seja criada como não concluída
        task.setCompleted(false);
        
        // Salva a tarefa no banco de dados
        Task savedTask = taskRepository.save(task);
        
        log.info("Tarefa criada com sucesso. ID: {}", savedTask.getId());
        return savedTask;
    }
    
    // Método para buscar todas as tarefas
    public List<Task> getAllTasks() {
        log.info("Buscando todas as tarefas");
        return taskRepository.findAll();
    }
    
    // Método para buscar tarefa por ID
    public Optional<Task> getTaskById(Long id) {
        log.info("Buscando tarefa por ID: {}", id);
        return taskRepository.findById(id);
    }
    
    // Método para atualizar tarefa
    public Task updateTask(Long id, Task taskDetails) {
        log.info("Atualizando tarefa ID: {}", id);
        
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
        
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        
        Task updatedTask = taskRepository.save(task);
        log.info("Tarefa atualizada com sucesso");
        return updatedTask;
    }
    
    // Método para deletar tarefa
    public void deleteTask(Long id) {
        log.info("Deletando tarefa ID: {}", id);
        
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com ID: " + id);
        }
        
        taskRepository.deleteById(id);
        log.info("Tarefa deletada com sucesso");
    }
    
    // Método para buscar tarefas concluídas
    public List<Task> getCompletedTasks() {
        log.info("Buscando tarefas concluídas");
        return taskRepository.findByCompleted(true);
    }
    
    // Método para buscar tarefas pendentes
    public List<Task> getPendingTasks() {
        log.info("Buscando tarefas pendentes");
        return taskRepository.findByCompleted(false);
    }
    
    // Método para buscar tarefas por título (busca parcial)
    public List<Task> getTasksByTitle(String title) {
        log.info("Buscando tarefas por título: {}", title);
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }
}