# 🚀 Projeto Quarkus

Este projeto é uma aplicação desenvolvida utilizando o **Quarkus**, focada em alta performance, baixo consumo de memória e inicialização rápida.

---

## 📦 Tecnologias e Dependências

O projeto utiliza as seguintes extensões e bibliotecas principais:

### 🔹 Core

* **quarkus-rest** → Criação de APIs REST
* **quarkus-arc** → Injeção de dependência (CDI)
* **quarkus-rest-jsonb** → Serialização JSON

### 🔹 Documentação e API

* **quarkus-smallrye-openapi** → Documentação automática (Swagger/OpenAPI)

### 🔹 Banco de Dados

* **quarkus-hibernate-orm-panache** → ORM simplificado
* **quarkus-jdbc-postgresql** → Conexão com PostgreSQL

### 🔹 Segurança

* **quarkus-smallrye-jwt** → Autenticação via JWT

### 🔹 Observabilidade

* **quarkus-opentelemetry** → Rastreamento distribuído
* **opentelemetry-jdbc** → Instrumentação JDBC
* **quarkus-micrometer** → Métricas
* **quarkus-micrometer-registry-prometheus** → Integração com Prometheus

### 🔹 Resiliência

* **quarkus-smallrye-fault-tolerance** → Retry, circuit breaker, timeout

### 🔹 Integrações

* **quarkus-rest-client** → Consumo de APIs externas

### 🔹 Health Check

* **quarkus-smallrye-health** → Monitoramento de saúde da aplicação

### 🔹 Testes

* **quarkus-junit** → Testes com Quarkus
* **rest-assured** → Testes de API

---

## ⚙️ Requisitos

* Java **21**
* Maven
* PostgreSQL

---

## ▶️ Como rodar o projeto

### Modo desenvolvimento

```bash
./mvnw quarkus:dev
```

### Build do projeto

```bash
./mvnw clean install
```

### Rodar o jar gerado

```bash
java -jar target/*-runner.jar
```

---

## 🧪 Testes

Executar testes:

```bash
./mvnw test
```

---

## 🐳 Build nativo (opcional)

Para gerar uma versão nativa:

```bash
./mvnw package -Dnative
```

---

## 📊 Observabilidade

Endpoints disponíveis (dependendo da config):

* `/q/health` → Status da aplicação
* `/q/metrics` → Métricas Prometheus
* `/q/openapi` → Especificação OpenAPI

---

## 📁 Estrutura do Projeto

Organização padrão Quarkus:

```
src/
 ├── main/
 │   ├── java/
 │   └── resources/
 └── test/
```

---

## 📌 Observações

* Projeto baseado em **Quarkus 3.34.3**
* Uso de Panache para simplificação do acesso a dados
* Preparado para observabilidade completa (logs, métricas e tracing)
* Arquitetura pronta para microsserviços

---
