# 📊 API de Avaliação Física – Projeto Integrador

API desenvolvida em **Spring Boot** para registrar e disponibilizar dados de avaliações físicas de alunos.  
O objetivo é fornecer dados padronizados para integração com o **Power BI**, permitindo análise de desempenho, evolução individual e indicadores físicos ao longo do tempo.

---

## 🚀 Tecnologias

- Java 17  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- Lombok  
- MySQL (WAMP)  
- DBeaver  
- Postman  
- Power BI  

---

## 🎯 Objetivo

Esta API permite:

- Cadastrar **turmas, alunos e módulos de avaliação**  
- Registrar **avaliações** realizadas em campo (data, avaliador, módulo, aluno)  
- Registrar **medidas** numéricas de cada teste físico (ex.: IMC, peso, flexibilidade)  
- Entregar dados limpos via JSON para consumo em dashboards Power BI  
- Servir como backend para um futuro sistema web de coleta

---

## 🏛️ Arquitetura

Estrutura básica do projeto:

- `model/` → entidades mapeadas com JPA  
- `dto/` → objetos de transferência entre controller e service  
- `repository/` → interfaces JPA com consultas e buscas personalizadas  
- `service/` → regras de negócio, validações e conversão para DTO  
- `controller/` → endpoints REST expostos para Postman, Power BI e front-end  

### Principais entidades

- **Turma** → Agrupa alunos (nome, ano, período, professor)  
- **Aluno** → Participante das avaliações (dados básicos + turma)  
- **Modulo** → Categoria do teste (ex.: Composição Corporal, Flexibilidade, Força)  
- **Avaliacao** → Coleta realizada (data, coletor, módulo, aluno)  
- **Medida** → Valores numéricos dos testes (nome do teste, valor, unidade, avaliação)

Relacionamentos principais:

- 1 Turma → N Alunos  
- 1 Aluno → N Avaliações  
- 1 Módulo → N Avaliações  
- 1 Avaliação → N Medidas  

---

## ▶️ Como Rodar o Projeto

1. Criar o banco de dados MySQL:

```sql
CREATE DATABASE dashboard_fisico;
Configurar o arquivo application.properties:

properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/dashboard_fisico
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.application.name=api-dashboard
Executar o projeto:

bash
Copiar código
mvn spring-boot:run
ou rodar diretamente pela IDE (IntelliJ).

📌 Endpoints Principais
Turmas
http
Copiar código
POST /api/turmas
GET  /api/turmas
GET  /api/turmas/{id}
PUT  /api/turmas/{id}
DELETE /api/turmas/{id}
Alunos
http
Copiar código
POST /api/alunos
GET  /api/alunos
GET  /api/alunos/{id}
PUT  /api/alunos/{id}
DELETE /api/alunos/{id}
Módulos
http
Copiar código
POST /api/modulos
GET  /api/modulos
GET  /api/modulos/{id}
PUT  /api/modulos/{id}
DELETE /api/modulos/{id}
Avaliações
http
Copiar código
POST /api/avaliacoes
GET  /api/avaliacoes
GET  /api/avaliacoes/{id}
GET  /api/avaliacoes/aluno/{alunoId}
GET  /api/avaliacoes/modulo/{moduloId}
PUT  /api/avaliacoes/{id}
DELETE /api/avaliacoes/{id}
Medidas
http
Copiar código
POST /api/medidas
GET  /api/medidas
GET  /api/medidas/avaliacao/{avaliacaoId}
GET  /api/medidas/aluno/{alunoId}
GET  /api/medidas/modulo/{moduloId}
GET  /api/medidas/teste/{nomeTeste}
DELETE /api/medidas/{id}
📊 Integração com Power BI
O Power BI pode consumir diretamente os endpoints:

/api/medidas

/api/avaliacoes

/api/alunos

/api/modulos

Os DTOs já retornam dados “achatados”, incluindo:

Nome do aluno

Nome do módulo

Nome do teste

Valor e unidade da medida

Data da coleta

Isso facilita a criação de dashboards com:

Evolução individual por aluno

Comparação entre turmas e módulos

Indicadores como IMC, peso, altura, flexibilidade

Rankings de desempenho e engajamento

✨ Status do Projeto
✅ Modelagem de dados implementada

✅ API REST funcional

✅ Endpoints testados no Postman

✅ Pronto para consumo no Power BI

⏳ Front-end web (planejado para etapa futura)

