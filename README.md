🏙️ Event City API


REST API desenvolvida com Java + Spring Boot para gerenciamento de eventos e cidades, com autenticação OAuth2, validação de dados e controle de acesso baseado em roles.

Projeto desenvolvido com foco em:

Arquitetura limpa

Segurança com Spring Security

Test Driven Development (TDD)

Boas práticas de API REST

🚀 Visão Geral

O sistema permite gerenciar:

Cidades

Eventos

Cada evento pertence a uma cidade.

City (1) -------- (N) Event
🏗️ Arquitetura da Aplicação

A aplicação segue arquitetura em camadas:

Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database

Responsabilidades:

Camada	Responsabilidade
Controller	Receber requisições HTTP
Service	Regras de negócio
Repository	Acesso ao banco
Entity	Modelo de domínio
🧩 Modelo de Domínio
City
Campo	Tipo
id	Long
name	String
Event
Campo	Tipo
id	Long
name	String
date	LocalDate
url	String
city	City
🔐 Segurança da API

A API utiliza Spring Security + OAuth2 com autenticação via Bearer Token.

Fluxo de autenticação:

Client → POST /oauth/token → Access Token
Client → Authorization: Bearer TOKEN → API
🔑 Obter Token
POST /oauth/token

Body:

grant_type=password
username=admin@gmail.com
password=123456

Resposta:

{
 "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
 "token_type": "bearer"
}
🔒 Regras de Acesso
Endpoint	Acesso
GET /events	Público
GET /cities	Público
POST /events	CLIENT ou ADMIN
POST /cities	ADMIN
PUT /events	ADMIN
✔ Regras de Validação
City
name não pode ser vazio
Event
name não pode ser vazio
date não pode ser passada
city não pode ser nula
🌐 Endpoints
Criar Evento
POST /events

Request

{
 "name": "Java Conference",
 "date": "2030-05-10",
 "url": "https://javaconf.com",
 "cityId": 1
}

Response

201 Created
Listar Eventos
GET /events

Response

200 OK
Criar Cidade
POST /cities
{
 "name": "São Paulo"
}
⚠️ Tratamento de Erros
Erro	HTTP
ResourceNotFoundException	404
DatabaseException	400
ValidationException	422
🧪 Cenários de Teste
Events
Cenário	Resultado
POST /events sem login	401
POST /events CLIENT	201
POST /events ADMIN	201
POST nome vazio	422
POST data passada	422
POST cidade nula	422
GET /events	200
Cities
Cenário	Resultado
POST /cities sem login	401
POST /cities CLIENT	403
POST /cities ADMIN	201
POST nome vazio	422
GET /cities	200
🛠️ Tecnologias

Java 21

Spring Boot

Spring Security

OAuth2

Spring Data JPA

Hibernate

Bean Validation

H2 Database

JUnit 5

Mockito

MockMvc

Maven

Lombok

▶️ Executar Projeto
Clonar repositório
git clone https://github.com/seu-usuario/event-city-api.git
Rodar aplicação
mvn spring-boot:run
Executar testes
mvn test
📁 Estrutura do Projeto
src/main/java/com/devsuperior

controllers
services
repositories
entities
dto
exceptions
config
⭐ Destaques Técnicos

API REST segura com Spring Security

Autenticação OAuth2

Controle de acesso por roles

Validação com Bean Validation

Arquitetura limpa e escalável

Desenvolvimento orientado a testes (TDD)

👨‍💻 Autor

Heverton Araújo Machado

Backend Developer — Java & Spring Boot
