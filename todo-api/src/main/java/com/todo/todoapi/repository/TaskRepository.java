package com.todo.todoapi.repository;

import com.todo.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Método customizado para buscar tarefas por status de conclusão
    List<Task> findByCompleted(boolean completed);
    
    // Método customizado para buscar tarefas por título (containing - LIKE)
    List<Task> findByTitleContainingIgnoreCase(String title);
    
    // Método customizado para buscar tarefas criadas após uma data específica
    List<Task> findByCreationDateAfter(LocalDateTime date);
    
    // Query customizada com JPQL para buscar tarefas pendentes (não concluídas)
    @Query("SELECT t FROM Task t WHERE t.completed = false ORDER BY t.creationDate DESC")
    List<Task> findPendingTasks();
    
    // Query customizada com SQL nativo para contar tarefas concluídas
    @Query(value = "SELECT COUNT(*) FROM tasks WHERE completed = true", nativeQuery = true)
    long countCompletedTasks();
    
    // Método customizado para buscar tarefas por status com ordenação por data
    List<Task> findByCompletedOrderByCreationDateDesc(boolean completed);
    
    // Query customizada com parâmetro nomeado
    @Query("SELECT t FROM Task t WHERE t.completed = :status AND t.creationDate >= :date")
    List<Task> findByStatusAndDateAfter(@Param("status") boolean completed, @Param("date") LocalDateTime date);
}