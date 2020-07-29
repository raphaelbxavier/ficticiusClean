# Desafio Java Backend Fluig - “Ficticius Clean”
Criar uma API Rest de cadastro de veículos para armazenar os veículos utilizados pela
empresa para realizar o cálculo de previsão de gastos.

### Ferramentas e Frameworks para testar a API:

É necessário ter instalado o Maven para compilar e executar o projeto.
* [Maven](https://maven.apache.org/) -> Link para fazer o download.

O Spring Boot 2.1.6 foi utilizado como framework starter do projeto.
* [Spring Boot](https://spring.io/) -> Link do site oficial da Spring.


## Primeiro Passo (Baixar o projeto do Git)
Devemos clonar o projeto no gitHub, através do link abaixo:
```
git clone https://github.com/raphaelbxavier/ficticiusClean.git
```

## Segundo Passo (Compilar e Executar o Projeto por linha comando maven)

Deve acessar a pasta do projeto que foi clonado e executar o comando:

```
mvn spring-boot:run
```

## Terceiro Passo (Abrir o Postman ou ferramenta similar para testes de requisição em Api's)

* [Postman](https://www.postman.com/) -> Link para download do Postman.

## Quarto Passo (testar os end-points da API)

Criar uma chamada POST no end-point, http://localhost:8080/veiculo/ , para criar um novo veículo.

Exemplo de requisição:

```
{
	"nome" : "I30",
	"marca": "Hyundai",
	"modelo" : "2012",
	"dataFabricacao": "2012-01-01",
	"consumoMedioCidade": 6,
	"consumoMedioRodovia": 12 
}

```

Resposta esperada:

```
{
  	"id" : 1
	"nome" : "I30",
  	"marca": "Hyundai",
  	"modelo" : "2012",
  	"dataFabricacao": "2012-01-01",
  	"consumoMedioCidade": 6,
  	"consumoMedioRodovia": 12 
}

```

Criar uma chamada GET para: http://localhost:8080/veiculo/calcularGastos?precoGasolina=3.81&totalKmCidade=30&totalKmRodovia=120 , enviando os parâmetros precoGasolina, totalKmCidade e totalKmRodovia via queryParams.

Resposta esperada:

```
{
  	"id": 1,
  	"nome": "I30",
  	"marca": "Hyundai",
  	"modelo": "2012",
  	"dataFabricacao": "2012-01-01",
  	"consumoMedioCidade": 6,
  	"consumoMedioRodovia": 12,
  	"gastoCombustivel": 15,
  	"total": 57.149998 
}

```
