TechByte eCommerce API (Spring Boot)
API RESTful desenvolvida em Java 25 com Spring Boot, refatorada a partir de uma aplicação Java em console para uma arquitetura baseada em serviços Web com persistência em banco de dados MySQL.
Tecnologias Utilizadas
Java: 25
Framework: Spring Boot 4.1.2
Persistência: Spring Data JPA
Web: Spring Web
Banco de Dados: MySQL
Gerenciador de Dependências: Maven
Passo a Passo da Criação no Spring Initializr
O projeto foi inicializado através do Spring Initializr (start.spring.io) utilizando a seguinte configuração:
Project: Maven
Language: Java
Spring Boot: 4.1.2
Group: com.techbyte
Artifact: ecommerce
Package Name: com.techbyte.ecommerce
Packaging: Jar
Configuration: Properties
Java Version: 25
Dependencies:
Spring Web
Spring Data JPA
MySQL Driver
Estrutura do Projeto
```
ecommerce/
├── .gitignore
├── pom.xml
├── README.md
├── docs/
│   └── prints/
│       ├── tabela-produto-ti-mysql.png
│       ├── get-todos-produtos.png
│       └── get-produto-por-id.png
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── techbyte/
    │   │           └── ecommerce/
    │   │               ├── EcommerceApplication.java
    │   │               ├── controller/
    │   │               │   └── ProdutoController.java
    │   │               ├── model/
    │   │               │   └── Produto.java
    │   │               ├── repository/
    │   │               │   └── ProdutoRepository.java
    │   │               └── service/
    │   │                   └── ProdutoService.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/
            └── com/
                └── techbyte/
                    └── ecommerce/
                        └── EcommerceApplicationTests.java
```
Estrutura da Tabela no Banco de Dados (produto_ti)
A classe Produto foi mapeada via JPA para criar automaticamente a tabela produto_ti no banco MySQL:
```sql
CREATE TABLE produto_ti (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);
```
Script de Inserção de Dados para Testes
```sql
INSERT INTO produto_ti (nome, descricao, preco) 
VALUES ('Notebook Dell Vostro', '[VALOR ALTO] Intel i7 16GB RAM 512GB SSD', 5500.00);

INSERT INTO produto_ti (nome, descricao, preco) 
VALUES ('Mouse Sem Fio Logitech', 'Mouse ergonômico Bluetooth', 150.00);

INSERT INTO produto_ti (nome, descricao, preco) 
VALUES ('Teclado Mecânico RGB', 'Switch Blue ABNT2', 350.00);

INSERT INTO produto_ti (nome, descricao, preco) 
VALUES ('Monitor UltraWide 29', '[VALOR ALTO] LG Full HD IPS 75Hz', 5200.00);
```
Configuração do Ambiente (application.properties)
```properties
spring.application.name=ecommerce

spring.datasource.url=jdbc:mysql://localhost:3306/techbyte_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=sua_senha_aqui
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
Como Executar o Projeto
Clonar o repositório no GitHub:
git clone https://github.com/SEU-USUARIO/ecommerce.git
Acessar a pasta raiz do projeto:
cd ecommerce
Executar o projeto utilizando o Maven Wrapper:
./mvnw spring-boot:run
A aplicação estará rodando na porta padrão: http://localhost:8080
Endpoints da API (Somente Métodos GET)
Método	Endpoint	Descrição
GET	/produtos	Retorna a lista completa de produtos cadastrados na tabela produto_ti
GET	/produtos/{id}	Retorna o registro correspondente ao ID informado
Evidências de Testes da API
1. Tabela produto_ti no MySQL
Visualização da tabela produto_ti gerada no MySQL com os dados populados.
![Tabela produto_ti no MySQL](docs/prints/tabela-produto-ti-mysql.png)
2. Consumo da rota GET /produtos no Navegador
Retorno da lista de produtos no formato JSON ao acessar a rota principal no navegador.
![GET /produtos no Navegador](docs/prints/get-todos-produtos.png)
3. Consumo da rota GET /produtos/1 no Navegador
Retorno do produto específico consultado por ID no navegador.
![GET /produtos por ID no Navegador](docs/prints/get-produto-por-id.png)
