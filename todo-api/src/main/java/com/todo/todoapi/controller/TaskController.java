package com.todo.todoapi.controller;

import com.todo.todoapi.model.Task;
import com.todo.todoapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*") // Para permitir requisições de diferentes origens
public class TaskController {
    
    private final TaskService taskService;
    
    // Endpoint POST para criar uma nova tarefa
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        log.info("Recebendo requisição POST para criar nova tarefa");
        
        try {
            Task createdTask = taskService.createTask(task);
            log.info("Tarefa criada com sucesso: {}", createdTask.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
            
        } catch (IllegalArgumentException e) {
            log.error("Erro de validação ao criar tarefa: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            
        } catch (Exception e) {
            log.error("Erro ao criar tarefa: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    // Endpoint GET para buscar todas as tarefas
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        log.info("Recebendo requisição GET para buscar todas as tarefas");
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
    
    // Endpoint GET para buscar tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        log.info("Recebendo requisição GET para buscar tarefa por ID: {}", id);
        
        Optional<Task> task = taskService.getTaskById(id);
        
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            log.warn("Tarefa não encontrada com ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // Endpoint PUT para atualizar tarefa
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        log.info("Recebendo requisição PUT para atualizar tarefa ID: {}", id);
        
        try {
            Task updatedTask = taskService.updateTask(id, taskDetails);
            return ResponseEntity.ok(updatedTask);
            
        } catch (RuntimeException e) {
            log.error("Erro ao atualizar tarefa: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // Endpoint DELETE para deletar tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        log.info("Recebendo requisição DELETE para deletar tarefa ID: {}", id);
        
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
            
        } catch (RuntimeException e) {
            log.error("Erro ao deletar tarefa: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    // Endpoint GET para buscar tarefas concluídas
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getCompletedTasks() {
        log.info("Recebendo requisição GET para buscar tarefas concluídas");
        List<Task> completedTasks = taskService.getCompletedTasks();
        return ResponseEntity.ok(completedTasks);
    }
    
    // Endpoint GET para buscar tarefas pendentes
    @GetMapping("/pending")
    public ResponseEntity<List<Task>> getPendingTasks() {
        log.info("Recebendo requisição GET para buscar tarefas pendentes");
        List<Task> pendingTasks = taskService.getPendingTasks();
        return ResponseEntity.ok(pendingTasks);
    }
    
    // Endpoint GET para buscar tarefas por título (busca parcial)
    @GetMapping("/search")
    public ResponseEntity<List<Task>> getTasksByTitle(@RequestParam String title) {
        log.info("Recebendo requisição GET para buscar tarefas por título: {}", title);
        List<Task> tasks = taskService.getTasksByTitle(title);
        return ResponseEntity.ok(tasks);
    }
}