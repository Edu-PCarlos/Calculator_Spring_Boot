# API de Calculadora

API REST desenvolvida com Spring Boot para o exercício de Controller.

## Executar

Requisitos: Java 17 ou superior e Maven.

```bash
mvn spring-boot:run
```

A API será iniciada em `http://localhost:8080`.

## Endpoints

- `GET /calculadora/somar/10/5`
- `GET /calculadora/subtrair?numero1=20&numero2=8`
- `GET /calculadora/calcular/somar?numero1=10&numero2=5`
- `GET /calculadora/calcular/subtrair?numero1=10&numero2=5`
- `GET /calculadora/calcular/multiplicar?numero1=10&numero2=5`
- `GET /calculadora/calcular/dividir?numero1=10&numero2=3&casasDecimais=2`
- `GET /calculadora/par-ou-impar/10`
- `GET /calculadora/analisar/10`
- `GET /calculadora/media?nota1=7&nota2=8&nota3=6`

Toda a lógica está concentrada em `CalculadoraController`, sem banco de dados, entidades ou camada de serviço.
