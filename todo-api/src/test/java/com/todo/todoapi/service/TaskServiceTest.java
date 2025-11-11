package com.todo.todoapi.service;

import com.todo.todoapi.model.Task;
import com.todo.todoapi.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do TaskService")
class TaskServiceTest {
    
    @Mock
    private TaskRepository taskRepository;
    
    @InjectMocks
    private TaskService taskService;
    
    private Task task;
    private Task savedTask;
    
    @BeforeEach
    void setUp() {
        // Inicializa objetos de teste antes de cada método
        task = new Task();
        task.setTitle("Tarefa de Teste");
        task.setDescription("Descrição da tarefa de teste");
        task.setCompleted(false);
        
        savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setTitle("Tarefa de Teste");
        savedTask.setDescription("Descrição da tarefa de teste");
        savedTask.setCompleted(false);
        savedTask.setCreationDate(LocalDateTime.now());
    }
    
    @Test
    @DisplayName("Deve criar uma tarefa com sucesso")
    void createTask_Success() {
        // Arrange (Preparação)
        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);
        
        // Act (Ação)
        Task result = taskService.createTask(task);
        
        // Assert (Verificação)
        assertNotNull(result);
        assertEquals("Tarefa de Teste", result.getTitle());
        assertEquals(false, result.isCompleted());
        assertNotNull(result.getCreationDate());
        
        // Verifica se o método save foi chamado uma vez
        verify(taskRepository, times(1)).save(any(Task.class));
    }
    
    @Test
    @DisplayName("Deve lançar exceção quando o título é nulo")
    void createTask_TitleNull_ThrowsException() {
        // Arrange
        task.setTitle(null);
        
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> taskService.createTask(task)
        );
        
        assertEquals("O título da tarefa é obrigatório", exception.getMessage());
        verify(taskRepository, never()).save(any(Task.class));
    }
    
    @Test
    @DisplayName("Deve lançar exceção quando o título está vazio")
    void createTask_TitleEmpty_ThrowsException() {
        // Arrange
        task.setTitle("");
        
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> taskService.createTask(task)
        );
        
        assertEquals("O título da tarefa é obrigatório", exception.getMessage());
        verify(taskRepository, never()).save(any(Task.class));
    }
    
    @Test
    @DisplayName("Deve buscar todas as tarefas")
    void getAllTasks_Success() {
        // Arrange
        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Segunda Tarefa");
        
        List<Task> tasks = Arrays.asList(savedTask, task2);
        when(taskRepository.findAll()).thenReturn(tasks);
        
        // Act
        List<Task> result = taskService.getAllTasks();
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Tarefa de Teste", result.get(0).getTitle());
        assertEquals("Segunda Tarefa", result.get(1).getTitle());
        
        verify(taskRepository, times(1)).findAll();
    }
    
    @Test
    @DisplayName("Deve buscar tarefa por ID com sucesso")
    void getTaskById_Success() {
        // Arrange
        when(taskRepository.findById(1L)).thenReturn(Optional.of(savedTask));
        
        // Act
        Optional<Task> result = taskService.getTaskById(1L);
        
        // Assert
        assertTrue(result.isPresent());
        assertEquals("Tarefa de Teste", result.get().getTitle());
        assertEquals(1L, result.get().getId());
        
        verify(taskRepository, times(1)).findById(1L);
    }
    
    @Test
    @DisplayName("Deve retornar Optional vazio quando tarefa não existe")
    void getTaskById_NotFound() {
        // Arrange
        when(taskRepository.findById(999L)).thenReturn(Optional.empty());
        
        // Act
        Optional<Task> result = taskService.getTaskById(999L);
        
        // Assert
        assertFalse(result.isPresent());
        verify(taskRepository, times(1)).findById(999L);
    }
    
    @Test
    @DisplayName("Deve buscar tarefas concluídas")
    void getCompletedTasks_Success() {
        // Arrange
        savedTask.setCompleted(true);
        Task completedTask2 = new Task();
        completedTask2.setId(2L);
        completedTask2.setTitle("Tarefa Concluída 2");
        completedTask2.setCompleted(true);
        
        List<Task> completedTasks = Arrays.asList(savedTask, completedTask2);
        when(taskRepository.findByCompleted(true)).thenReturn(completedTasks);
        
        // Act
        List<Task> result = taskService.getCompletedTasks();
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(Task::isCompleted));
        
        verify(taskRepository, times(1)).findByCompleted(true);
    }
    
    @Test
    @DisplayName("Deve buscar tarefas pendentes")
    void getPendingTasks_Success() {
        // Arrange
        Task pendingTask2 = new Task();
        pendingTask2.setId(2L);
        pendingTask2.setTitle("Tarefa Pendente 2");
        pendingTask2.setCompleted(false);
        
        List<Task> pendingTasks = Arrays.asList(savedTask, pendingTask2);
        when(taskRepository.findByCompleted(false)).thenReturn(pendingTasks);
        
        // Act
        List<Task> result = taskService.getPendingTasks();
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().noneMatch(Task::isCompleted));
        
        verify(taskRepository, times(1)).findByCompleted(false);
    }
    
    @Test
    @DisplayName("Deve atualizar tarefa com sucesso")
    void updateTask_Success() {
        // Arrange
        Task updatedDetails = new Task();
        updatedDetails.setTitle("Tarefa Atualizada");
        updatedDetails.setDescription("Nova descrição");
        updatedDetails.setCompleted(true);
        
        when(taskRepository.findById(1L)).thenReturn(Optional.of(savedTask));
        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);
        
        // Act
        Task result = taskService.updateTask(1L, updatedDetails);
        
        // Assert
        assertNotNull(result);
        assertEquals("Tarefa Atualizada", result.getTitle());
        assertEquals("Nova descrição", result.getDescription());
        assertEquals(true, result.isCompleted());
        
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).save(any(Task.class));
    }
    
    @Test
    @DisplayName("Deve lançar exceção ao atualizar tarefa inexistente")
    void updateTask_NotFound_ThrowsException() {
        // Arrange
        Task updatedDetails = new Task();
        updatedDetails.setTitle("Tarefa Atualizada");
        
        when(taskRepository.findById(999L)).thenReturn(Optional.empty());
        
        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> taskService.updateTask(999L, updatedDetails)
        );
        
        assertEquals("Tarefa não encontrada com ID: 999", exception.getMessage());
        verify(taskRepository, times(1)).findById(999L);
        verify(taskRepository, never()).save(any(Task.class));
    }
    
    @Test
    @DisplayName("Deve deletar tarefa com sucesso")
    void deleteTask_Success() {
        // Arrange
        when(taskRepository.existsById(1L)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(1L);
        
        // Act
        taskService.deleteTask(1L);
        
        // Assert
        verify(taskRepository, times(1)).existsById(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }
    
    @Test
    @DisplayName("Deve lançar exceção ao deletar tarefa inexistente")
    void deleteTask_NotFound_ThrowsException() {
        // Arrange
        when(taskRepository.existsById(999L)).thenReturn(false);
        
        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> taskService.deleteTask(999L)
        );
        
        assertEquals("Tarefa não encontrada com ID: 999", exception.getMessage());
        verify(taskRepository, times(1)).existsById(999L);
        verify(taskRepository, never()).deleteById(anyLong());
    }
}