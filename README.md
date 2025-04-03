# Agenda Telefônica

Este repositório contém o frontend desenvolvido em React e o backend em Java Spring Boot integrados via Docker.

## Tecnologias Utilizadas

- **Frontend**: React, Vite, TailwindCSS
- **Backend**: Java, Spring Boot, PostgreSQL
- **Infraestrutura**: Docker, Docker Compose

## Configuração e Execução (Sem Docker)

### 1. Clonar o Repositório

```sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Instalar Dependências

#### Frontend

```sh
cd agenda-telefonica-front
npm install
```

#### Backend

```sh
cd agenda-telefonica-back
./mvnw clean install
```

### 3. Rodar o Projeto

#### Frontend

```sh
npm run dev
```

Acesse em `http://localhost:5173`.

#### Backend

```sh
./mvnw spring-boot:run
```

API disponível em `http://localhost:8080`.

## Estrutura do Projeto

```
/agenda-telefonica-front
  |-- src/
  |-- public/
  |-- Dockerfile.dev
  |-- package.json
/agenda-telefonica-back
  |-- src/
  |-- pom.xml
  |-- Dockerfile.dev
/docker-compose.dev.yml
```

## Executando o Projeto no Docker

### Pré-requisitos

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Criar e iniciar os containers

```sh
docker-compose -f docker-compose.dev.yml up --build
```

Isso iniciará os serviços do frontend, backend e banco de dados.

### Acessar a aplicação

- **Frontend:** [http://localhost:5173](http://localhost:5173)
- **Backend:** [http://localhost:8080](http://localhost:8080)
- **Banco de Dados:** `localhost:5432` (credenciais no `docker-compose.dev.yml`)

## Comandos Úteis

### Verificar containers rodando

```sh
docker ps
```

### Reiniciar serviços específicos

- **Frontend:** `docker restart agenda-telefonica-api-frontend-1`
- **Backend:** `docker restart agenda-telefonica-api-backend-1`

### Parar os containers

```sh
docker-compose -f docker-compose.dev.yml down
```

### Reconstruir tudo e subir novamente

```sh
docker-compose -f docker-compose.dev.yml up --build
```

### Remover imagens não utilizadas

```sh
docker system prune -a
```
