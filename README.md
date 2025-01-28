# RetornosAPI

## Descrição
O projeto **RetornosAPI** é uma API desenvolvida para gerenciar e validar dados de entrada, retornando respostas apropriadas para diferentes cenários, como validações de campos, criação de recursos e manipulação de erros.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Validation**
- **Maven** (Gerenciador de dependências)

## Funcionalidades
- Validação de campos de entrada utilizando `@Valid` e anotações de validação.
- Tratamento global de exceções com `@RestControllerAdvice`.
- Endpoints RESTful para criação e manipulação de recursos.
- Retorno de mensagens de erro detalhadas para validações de campos.

## Requisitos
Certifique-se de ter os seguintes pré-requisitos instalados:
- **Java 17** ou superior
- **Maven** 3.6 ou superior

Dependências principais do projeto:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

## Como Executar o Projeto
Siga os passos abaixo para executar o projeto localmente:

1. Clone o repositório:
```xml
git clone https://github.com/flaviahespanhol-zup/retornosAPI.git
   ```

2. Navegue até o diretório do projeto:
```xml
cd retornosAPI
   ```

3. Compile o projeto:
Certifique-se de que todas as dependências estão instaladas e compile o projeto utilizando o Maven:
```xml
mvn clean install
   ```

4. Execute o projeto:
Inicie a aplicação com o comando:
```xml
mvn spring-boot:run
   ```

5. Acesse a API:
Após iniciar o servidor, a API estará disponível em:
```xml
http://localhost:8080
   ```

   