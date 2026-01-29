🏙️ Event City API — TDD Challenge (Spring Boot)

REST API desenvolvida com Java e Spring Boot, utilizando TDD para garantir qualidade, previsibilidade e robustez no desenvolvimento de funcionalidades relacionadas a eventos e cidades.








📖 Sumário

Sobre o Projeto

Arquitetura

Modelo de Domínio

Requisitos Implementados

Endpoints da API

Tratamento de Exceções

Testes Automatizados

Tecnologias Utilizadas

Como Executar

Estrutura do Projeto

Destaques Técnicos

Autor

🚀 Sobre o Projeto

O Event City API é uma aplicação RESTful desenvolvida como desafio técnico com foco em:

Desenvolvimento orientado a testes (TDD)

Implementação de regras de negócio reais

Boas práticas de arquitetura backend

Tratamento consistente de erros HTTP

Código limpo e manutenível

O sistema gerencia eventos e cidades, considerando o relacionamento N-1 entre essas entidades.

🏗️ Arquitetura

A aplicação segue uma arquitetura em camadas:

Controller → Service → Repository → Database


Principais padrões utilizados:

DTO Pattern

Repository Pattern

Service Layer

Exception Handling Centralizado

Test Driven Development (TDD)

🧩 Modelo de Domínio
City (Cidade)
Campo	Tipo
id	Long
name	String
Event (Evento)
Campo	Tipo
id	Long
name	String
date	LocalDate
url	String
city	City

Relacionamento:

City (1) -------- (N) Event

✅ Requisitos Implementados
Cities

✔️ Inserir cidade (POST /cities)

✔️ Listar cidades ordenadas por nome (GET /cities)

✔️ Remover cidade com regras de integridade (DELETE /cities/{id})

Events

✔️ Atualizar evento existente (PUT /events/{id})

✔️ Retornar erro quando evento não existe

🌐 Endpoints da API
🏙️ Cities
➤ POST /cities

Cria uma nova cidade.

Request

{
  "name": "Recife"
}


Response — 201 Created

{
  "id": 1,
  "name": "Recife"
}

➤ GET /cities

Retorna lista ordenada por nome.

Response — 200 OK

[
  {
    "id": 1,
    "name": "Belo Horizonte"
  },
  {
    "id": 2,
    "name": "Recife"
  }
]

➤ DELETE /cities/{id}
Cenário	Status HTTP
Cidade não existe	404 Not Found
Cidade sem eventos	204 No Content
Cidade com eventos vinculados	400 Bad Request
🎉 Events
➤ PUT /events/{id}

Request

{
  "name": "Expo XP",
  "date": "2021-05-18",
  "url": "https://expoxp.com.br",
  "cityId": 7
}


Response — 200 OK

{
  "id": 1,
  "name": "Expo XP",
  "date": "2021-05-18",
  "url": "https://expoxp.com.br",
  "cityId": 7
}

Cenário	Status HTTP
Evento existe	200 OK
Evento não existe	404 Not Found
⚠️ Tratamento de Exceções

A API possui tratamento centralizado de exceções com respostas HTTP semânticas:

ResourceNotFoundException → 404 Not Found

DatabaseException → 400 Bad Request

Validation Errors → 422 Unprocessable Entity

🧪 Testes Automatizados

O projeto foi desenvolvido utilizando TDD, com cobertura de testes de integração.

Cenários testados:

✔️ Inserção de cidades

✔️ Listagem ordenada

✔️ Exclusão com integridade referencial

✔️ Atualização de eventos

✔️ Retorno de erros apropriados

Resultado:

✅ 7/7 testes aprovados

🛠️ Tecnologias Utilizadas

Java 21

Spring Boot 3.x

Spring Data JPA

Hibernate

H2 Database (perfil test)

JUnit 5

Mockito

MockMvc

Maven

Lombok

▶️ Como Executar
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/event-city-api.git

2️⃣ Executar a aplicação
mvn spring-boot:run

3️⃣ Executar os testes
mvn test

🗂️ Estrutura do Projeto
src/main/java/com/devsuperior/bds02
│
├── controllers
├── services
├── repositories
├── entities
├── dto
└── exceptions

💡 Destaques Técnicos

Implementação real de TDD (test-first)

Separação clara de responsabilidades

Uso correto de DTOs para isolamento de domínio

Tratamento de exceções RESTful

Código limpo e aderente às boas práticas do Spring

Projeto pronto para escalar e evoluir

👨‍💻 Autor

Heverton Araújo Machado
Backend Developer — Java & Spring Boot

📌 Projeto desenvolvido como desafio técnico com foco em qualidade de código e boas práticas.
