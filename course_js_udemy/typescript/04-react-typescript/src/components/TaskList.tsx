/**
 * Componente de Lista de Tarefas com TypeScript e React
 * Autor: Nathan Solano
 */

import React, { useState, useEffect } from 'react';

// Definição de tipos
interface Task {
  id: number;
  title: string;
  completed: boolean;
}

interface TaskListProps {
  initialTasks?: Task[];
}

const TaskList: React.FC<TaskListProps> = ({ initialTasks = [] }) => {
  const [tasks, setTasks] = useState<Task[]>(initialTasks);
  const [newTaskTitle, setNewTaskTitle] = useState<string>('');
  const [filter, setFilter] = useState<'all' | 'active' | 'completed'>('all');

  // Adicionar nova tarefa
  const handleAddTask = (e: React.FormEvent) => {
    e.preventDefault();
    
    if (newTaskTitle.trim() === '') return;
    
    const newTask: Task = {
      id: Date.now(),
      title: newTaskTitle,
      completed: false
    };
    
    setTasks([...tasks, newTask]);
    setNewTaskTitle('');
  };

  // Alternar status da tarefa
  const toggleTaskStatus = (taskId: number) => {
    setTasks(tasks.map(task => 
      task.id === taskId ? { ...task, completed: !task.completed } : task
    ));
  };

  // Remover tarefa
  const removeTask = (taskId: number) => {
    setTasks(tasks.filter(task => task.id !== taskId));
  };

  // Filtrar tarefas
  const filteredTasks = tasks.filter(task => {
    if (filter === 'active') return !task.completed;
    if (filter === 'completed') return task.completed;
    return true; // 'all'
  });

  // Contagem de tarefas restantes
  const remainingTasks = tasks.filter(task => !task.completed).length;

  return (
    <div className="task-list">
      <h1>Lista de Tarefas</h1>
      
      <form onSubmit={handleAddTask}>
        <input
          type="text"
          value={newTaskTitle}
          onChange={(e) => setNewTaskTitle(e.target.value)}
          placeholder="Adicionar nova tarefa"
        />
        <button type="submit">Adicionar</button>
      </form>
      
      <div className="filters">
        <button 
          onClick={() => setFilter('all')}
          className={filter === 'all' ? 'active' : ''}
        >
          Todas
        </button>
        <button 
          onClick={() => setFilter('active')}
          className={filter === 'active' ? 'active' : ''}
        >
          Ativas
        </button>
        <button 
          onClick={() => setFilter('completed')}
          className={filter === 'completed' ? 'active' : ''}
        >
          Concluídas
        </button>
      </div>
      
      <ul>
        {filteredTasks.map(task => (
          <li key={task.id} className={task.completed ? 'completed' : ''}>
            <input
              type="checkbox"
              checked={task.completed}
              onChange={() => toggleTaskStatus(task.id)}
            />
            <span>{task.title}</span>
            <button onClick={() => removeTask(task.id)}>Remover</button>
          </li>
        ))}
      </ul>
      
      <div className="task-count">
        {remainingTasks} {remainingTasks === 1 ? 'tarefa' : 'tarefas'} restante{remainingTasks !== 1 ? 's' : ''}
      </div>
    </div>
  );
};

export default TaskList;