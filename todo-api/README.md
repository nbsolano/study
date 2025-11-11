# API REST de Gerenciamento de Tarefas (To-Do List)

## Descrição
API RESTful desenvolvida em Spring Boot para gerenciamento de tarefas com operações CRUD completas.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **Spring Security**
- **H2 Database** (para testes)
- **Lombok**
- **JUnit 5** e **Mockito** (para testes)

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/todo/todoapi/
│   │   ├── config/
│   │   │   └── SecurityConfig.java
│   │   ├── controller/
│   │   │   └── TaskController.java
│   │   ├── model/
│   │   │   └── Task.java
│   │   ├── repository/
│   │   │   └── TaskRepository.java
│   │   ├── service/
│   │   │   └── TaskService.java
│   │   └── TodoApiApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/todo/todoapi/service/
        └── TaskServiceTest.java
```

## Principais Dependências (pom.xml)

- `spring-boot-starter-web` - Para criar endpoints REST
- `spring-boot-starter-data-jpa` - Para persistência de dados
- `spring-boot-starter-security` - Para segurança da API
- `h2` - Banco de dados em memória para testes
- `lombok` - Para reduzir boilerplate code
- `spring-boot-starter-test` - Para testes unitários

## Funcionalidades

### Operações CRUD
- **Criar** tarefa (POST /api/tasks)
- **Listar** todas as tarefas (GET /api/tasks)
- **Buscar** tarefa por ID (GET /api/tasks/{id})
- **Atualizar** tarefa (PUT /api/tasks/{id})
- **Deletar** tarefa (DELETE /api/tasks/{id})

### Funcionalidades Adicionais
- Buscar tarefas por status (concluídas/pendentes)
- Buscar tarefas por título (busca parcial)
- Validações de negócio
- Tratamento de exceções
- Logs detalhados

## Segurança

A API utiliza Spring Security com:
- Autenticação Basic Auth
- Autorização baseada em roles
- Usuários em memória para testes

### Usuários de Teste
- **Admin**: username: `admin`, password: `admin123`
- **User**: username: `user`, password: `user123`

## Endpoints da API

### Tarefas (Tasks)
- `GET /api/tasks` - Listar todas as tarefas
- `GET /api/tasks/{id}` - Buscar tarefa por ID
- `POST /api/tasks` - Criar nova tarefa
- `PUT /api/tasks/{id}` - Atualizar tarefa
- `DELETE /api/tasks/{id}` - Deletar tarefa
- `GET /api/tasks/completed` - Listar tarefas concluídas
- `GET /api/tasks/pending` - Listar tarefas pendentes
- `GET /api/tasks/search?title={titulo}` - Buscar tarefas por título

### Exemplo de Requisição

**Criar nova tarefa:**
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -H "Authorization: Basic dXNlcjp1c2VyMTIz" \
  -d '{
    "title": "Minha primeira tarefa",
    "description": "Descrição da tarefa"
  }'
```

## Testes

O projeto inclui testes unitários completos para o `TaskService` utilizando JUnit 5 e Mockito.

Para executar os testes:
```bash
mvn test
```

## Como Executar

1. Clone o repositório
2. Navegue até a pasta do projeto
3. Execute: `mvn spring-boot:run`
4. Acesse: `http://localhost:8080`

## Console H2
Para acessar o console do banco H2: `http://localhost:8080/h2-console`

**Configurações do H2:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (deixe vazio)

## Autor
Desenvolvido como projeto de estudo para demonstrar conhecimentos em Java Backend.