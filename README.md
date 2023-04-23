# Popular House
O Popular House é uma API para auxiliar na seleção de famílias aptas a ganharem casa popular através de pontuação. 

# Objetivo
Gerar uma lista de pessoas aptas a ganhar uma casa popular do governo, tendo como única exigência que essa lista esteja ordenada de forma mais justa possível com um somatório de pontos, analisando aspectos das famílias que estão participando.

# Regras
São considerados os seguintes critérios para a construção das pontuações:
* Renda total da família até 900 reais - valendo 5 pontos;
* Renda total da família de 901 à 1500 reais - valendo 3 pontos;
* Famílias com 3 ou mais dependentes (lembrando que dependentes maiores de 18 anos não contam) - valendo 3 pontos;
* Famílias com 1 ou 2 dependentes (lembrando que dependentes a partir de 18 anos não contam) - valendo 2 pontos.

## Dependências
* Java 11
* Maven (Build)

## Testes
Para testar o projeto:
```
mvn test
```

## Executando o projeto
```
mvn spring-boot:run
```

## Executando via arquivo jar
```
mvn clean install 

java -jar -Dserver.port=8090 ./target/house-0.0.1-SNAPSHOT.jar 
```

## Porta Default
A porta padrão é a 8090, é importante assegurar que a porta não esteja em uso para os testes e execução do projeto.

## Swagger
[http://localhost:8090/swagger-ui/index.html](http://localhost:8090/swagger-ui/index.html)


## Banco de Dados
[http://localhost:8090/h2-console](http://localhost:8090/h2-console)
```
* JDBC URL: jdbc:h2:mem:house_bd
* User: sa
* Pass: 
```

## Sonar
[https://sonarcloud.io/project/overview?id=isacaguiar_popular-house](https://sonarcloud.io/project/overview?id=isacaguiar_popular-house)

## Jacoco
```
<caminho-do-projeto>/target/site/jacoco/index.html
```
---
## APIs

### Lista as famílias cadatradas ordenadas pela pontuação
```
* GET
* /family
```

### Cadastra uma nova família
```
* POST 
* /family
```

### Lista uma família a partir do seu identificador
```
* GET 
* /family/{id}
```

### Apagar o cadastro de uma família
```
* DELETE 
* /family/{id}
```


