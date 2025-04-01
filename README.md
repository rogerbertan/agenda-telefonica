# Agenda Telefônica - API REST

Esta é uma API REST para gerenciar contatos de uma agenda telefônica, utilizando **Java Spring Boot** e **PostgreSQL**.

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Como Configurar e Executar

### 1️⃣ Clonar o Repositório
```sh
git clone https://github.com/seu-usuario/agenda-telefonica-API.git
cd agenda-telefonica-API
```

### 2️⃣ Configurar o Banco de Dados PostgreSQL
1. Acesse o PostgreSQL e crie o banco de dados:
```sql
CREATE DATABASE agenda_telefonica;
```
2. Conecte-se ao banco recém-criado e crie a tabela necessária:
```sql
CREATE TABLE contatos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
);
```

### 3️⃣ Configurar o Arquivo `application.properties`
Edite o arquivo `src/main/resources/application.properties` para definir as credenciais do PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agenda_telefonica
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

### 4️⃣ Compilar e Executar a API
```sh
mvn clean install
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Endpoints Principais

### Criar um Novo Contato
**POST** `/contatos`
```json
{
  "nome": "João Silva",
  "telefone": "(11) 99999-8888",
  "email": "joao@email.com"
}
```

### Listar Todos os Contatos
**GET** `/contatos`
