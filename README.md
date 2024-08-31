# Desafio PicPay

Este projeto é uma API desenvolvida com Spring Boot 3.3.2, que utiliza Kafka e PostgreSQL como parte de sua arquitetura. O objetivo do projeto é demonstrar uma integração básica entre essas tecnologias usando o Docker para orquestração dos serviços.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada.
- **Spring Boot 3.3.2**: Framework para desenvolvimento da API.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar informações.
- **Kafka**: Plataforma de streaming distribuído para mensageria.
- **Flyway**: Ferramenta para gerenciamento de versões de banco de dados.
- **Docker**: Usado para containerização dos serviços.

## Dependências

As principais dependências utilizadas no projeto incluem:

- **spring-boot-starter-data-jdbc**: Para interagir com o banco de dados usando JDBC.
- **spring-boot-starter-web**: Para criação da API REST.
- **spring-kafka**: Para integração com o Kafka.
- **postgresql**: Driver do PostgreSQL.
- **lombok**: Para simplificação do código Java.
- **spring-boot-devtools**: Para facilitar o desenvolvimento com recarregamento automático.
- **flyway-core** e **flyway-database-postgresql**: Para migrações do banco de dados.
- **spring-boot-starter-test** e **spring-kafka-test**: Para testes da aplicação.

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em sua máquina:

- [Docker](https://www.docker.com/)
- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org/)

## Configuração do Ambiente

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/GustavoFuzer77/desafio-picpay-springBoot.git
   cd desafio-picpay-springBoot

2. **Configurar o Docker**

- Certifique-se de que o Docker está instalado e em execução. O projeto utiliza Docker para rodar o PostgreSQL e o Kafka.

3. **Configurar as Variáveis de Ambiente**

- No arquivo application.properties coloque as seguintes variáveis de ambiente:
   ```bash
    SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/sua-base-dados
    SPRING_DATASOURCE_USERNAME=seu-usuario
    SPRING_DATASOURCE_PASSWORD=sua-senha
    SPRING_KAFKA_BOOTSTRAP_SERVERS=localhost:9092
    ```
## Startar

O projeto inclui um arquivo docker-compose.yml que configura o Kafka e o PostgreSQL. Para iniciar os serviços, execute:
  ```bash
    docker-compose up -d
    mvn spring-boot:run
  ```

## Contato
Para dúvidas ou sugestões, entre em contato:

Nome: Gustavo Fuzer
Email: gustavofuzer256@gmail.com
LinkedIn: https://www.linkedin.com/in/gustavo-fuzer-7286b8268/
