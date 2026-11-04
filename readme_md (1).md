# TechByte eCommerce API (Spring Boot)

API RESTful desenvolvida em Java 25 com Spring Boot 4.1.2, refatorada a partir de uma aplicação Java em console para uma arquitetura baseada em serviços Web com persistência em banco de dados MySQL.

## Tecnologias Utilizadas

* Java: 25

* Framework: Spring Boot 4.1.2

* Persistência: Spring Data JPA

* Web: Spring Web

* Banco de Dados: MySQL

* Gerenciador de Dependências: Maven

## Passo a Passo da Criação no Spring Initializr

O projeto foi inicializado através do Spring Initializr (start.spring.io) utilizando a seguinte configuração:

* Project: Maven

* Language: Java

* Spring Boot: 4.1.2

* Group: com.techbyte

* Artifact: ecommerceapi

* Package Name: com.techbyte.ecommerceapi

* Packaging: Jar

* Configuration: Properties

* Java Version: 25

* Dependencies:

  1. Spring Web

  2. Spring Data JPA

  3. MySQL Driver

## Estrutura do Projeto

```
ecommerceapi/
├── .mvn/
├── docs/
│   └── prints/
│       ├── tabela-produto-ti-mysql.png
│       ├── get-todos-produtos.png
│       └── get-produto-por-id.png
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── techbyte/
│   │   │           └── ecommerceapi/
│   │   │               ├── EcommerceapiApplication.java
│   │   │               ├── Controller/
│   │   │               │   └── ProductController.java
│   │   │               └── model/
│   │   │                   └── products.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── techbyte/
│                   └── ecommerceapi/
│                       └── EcommerceapiApplicationTests.java
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Estrutura da Tabela no Banco de Dados (produto_ti)

A classe de modelo foi mapeada via JPA para criar automaticamente a tabela produto_ti no banco MySQL:

```
CREATE TABLE produto_ti (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DECIMAL(38,2)
);
```

### Script de Inserção de Dados para Testes

```
INSERT INTO produto_ti (nome, descricao, preco) 
VALUES ('Monitor Guns N Roses', 'Bonito e perfeito para fãs', 3.75);

INSERT INTO produto_ti (nome, descricao, preco) 
VALUES ('Notebook Dell Vostro', 'Intel i7 16GB RAM 512GB SSD', 5500.00);

INSERT INTO produto_ti (nome, descricao, preco) 
VALUES ('Mouse Sem Fio Logitech', 'Mouse ergonômico Bluetooth', 150.00);
```

## Configuração do Ambiente

A configuração de acesso ao banco de dados MySQL é realizada no arquivo application.properties localizado na pasta src/main/resources. Certifique-se de ajustar a URL de conexão, o usuário e a senha do seu ambiente local antes de executar a aplicação.

## Como Executar o Projeto (Java 25)

1. Certifique-se de ter o JDK 25 instalado e configurado nas variáveis de ambiente.

2. Clonar o repositório no GitHub:
   git clone https://github.com/SEU-USUARIO/ecommerceapi.git

3. Acessar a pasta raiz do projeto:
   cd ecommerceapi

4. Executar o projeto utilizando o Maven Wrapper:
   ./mvnw spring-boot:run

5. A aplicação estará rodando na porta padrão: http://localhost:8080

## Endpoints da API (Somente Métodos GET)

| Método | Endpoint | Descrição | 
| ----- | ----- | ----- | 
| GET | /produtos | Retorna a lista completa de produtos cadastrados na tabela produto_ti | 
| GET | /produtos/{id} | Retorna o registro correspondente ao ID informado | 

## Exemplo de JSON Retornado pela API

```
{
  "nome": "Monitor Guns N Roses",
  "descricao": "Bonito e perfeito para fãs",
  "preco": 3.75,
  "id": 0
}
```

## Evidências de Testes da API

### 1. Tabela produto_ti no MySQL

Visualização da tabela produto_ti gerada no MySQL com os dados populados.

### 2. Consumo da rota GET /produtos no Navegador

Retorno da lista de produtos no formato JSON ao acessar a rota principal no navegador.

### 3. Consumo da rota GET /produtos/1 no Navegador

Retorno do produto específico consultado por ID no navegador.