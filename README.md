# Desafio Java Backend Fluig - “Ficticius Clean”
Criar uma API Rest de cadastro de veículos para armazenar os veículos utilizados pela
empresa para realizar o cálculo de previsão de gastos.

### É necessário ter instalado o Maven e o Java 8+ para compilar e executar o projeto.

## Primeiro Passo (Download ou Clone do projeto no Git)
 Fazer o download do projeto, ou clonar no gitHub via terminal através do comando abaixo:
```
git clone https://github.com/raphaelbxavier/ficticiusClean.git
```

## Segundo Passo (Compilar e Executar o Projeto por linha comando maven)

Acessar a pasta ficticiusClean que foi clonado e executar o comando:

```
mvn spring-boot:run
```

## Terceiro Passo (Abrir o Postman ou ferramenta similar para testes de requisição em Api's)

* [Postman](https://www.postman.com/) -> Link para download do Postman.

## Quarto Passo (Testar os End-Points)

Criar uma ou várias chamadas POST no end-point, http://localhost:8080/veiculo/ , para criar um ou mais veículo(s) novo(s).

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
