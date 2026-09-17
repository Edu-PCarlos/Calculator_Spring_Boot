# API de Calculadora

## Visão geral

Esta API REST foi desenvolvida com Spring Boot para demonstrar o uso de controllers em uma aplicação Java, centralizando operações matemáticas e retornos em formato textual/numérico.

O objetivo principal do projeto é fornecer uma base simples e didática para:

- explorar o padrão MVC em aplicações Spring;
- criar endpoints HTTP para operações matemáticas;
- praticar validação de parâmetros e tratamento de erros básicos;
- servir como exemplo de API funcional para estudo e extensão.

A aplicação foi construída com foco em simplicidade e legibilidade, sem banco de dados, camada de persistência ou serviços externos.

---

## Tecnologias

- Java 17
- Spring Boot 3
- Maven
- REST API

---

## Requisitos

Antes de executar a aplicação, certifique-se de ter instalado:

- Java 21
- Maven

---

## Execução

A partir da raiz do projeto, execute:

```bash
./mvnw spring-boot:run
```

Se o wrapper não estiver disponível no ambiente, utilize:

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

## Endpoints

A API está mapeada sob o prefixo `/calculadora`.

### 1. Soma

```http
GET /calculadora/somar/{numero1}/{numero2}
```

Exemplo:

```bash
curl http://localhost:8080/calculadora/somar/10/5
```

Retorno esperado:

```text
15
```

### 2. Subtração

```http
GET /calculadora/subtrair?numero1=20&numero2=8
```

### 3. Operação genérica

```http
GET /calculadora/calcular/{operacao}?numero1=10&numero2=5&casasDecimais=2
```

Operações aceitas:

- `somar`
- `subtrair`
- `multiplicar`
- `dividir`

Exemplo:

```bash
curl "http://localhost:8080/calculadora/calcular/dividir?numero1=10&numero2=3&casasDecimais=2"
```

### 4. Verificação de par ou ímpar

```http
GET /calculadora/par-ou-impar/{numero}
```

Exemplo:

```bash
curl http://localhost:8080/calculadora/par-ou-impar/10
```

Retorno:

```text
PAR
```

### 5. Análise do número

```http
GET /calculadora/analisar/{numero}
```

Retorna informações sobre:

- paridade;
- sinal;
- dobro;
- metade;
- quadrado.

### 6. Cálculo de média

```http
GET /calculadora/media?nota1=7&nota2=8&nota3=6
```

A resposta indica também a situação do aluno:

- `APROVADO`
- `RECUPERAÇÃO`
- `REPROVADO`

---

## Testes

### Testes manuais via HTTP

A aplicação pode ser validada diretamente com `curl`, por exemplo:

```bash
curl http://localhost:8080/calculadora/somar/10/5
curl "http://localhost:8080/calculadora/calcular/multiplicar?numero1=7&numero2=8"
curl http://localhost:8080/calculadora/par-ou-impar/13
curl "http://localhost:8080/calculadora/media?nota1=7&nota2=8&nota3=6"
```

Esses testes permitem verificar se os endpoints respondem corretamente e se os retornos estão de acordo com a lógica da aplicação.

### Execução de build e validação

Para compilar e validar a aplicação com Maven:

```bash
mvn test
```

Esse comando verifica se o projeto compila corretamente e executa a validação disponível no ambiente. O projeto foi estruturado como uma API simples e, atualmente, a ênfase está na execução e validação funcional dos endpoints.

---

## Estrutura do projeto

```text
Calculator/
├── src/
│   └── main/
│       └── java/
│           └── br/com/calculadora/
│               ├── CalculadoraApplication.java
│               └── CalculadoraController.java
├── pom.xml
├── README.md
└── mvnw
```

Toda a lógica principal está concentrada em `CalculadoraController`, mantendo a arquitetura simples e fácil de entender.

---

## Objetivo do projeto

Este projeto funciona como uma API didática para estudo de:

- criação de endpoints REST;
- funcionamento do Spring Boot;
- tratativa de parâmetros via URL e query string;
- retorno de respostas em texto e valores numéricos;
- desenvolvimento de aplicações Java com foco em aprendizado prático.

---

## Observações

- Não há persistência em banco de dados.
- Não há camada de serviço separada neste exemplo.
- A aplicação é adequada para fins acadêmicos, de estudo e demonstração.
