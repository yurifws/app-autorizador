# app-autorizador

Um *autorizador*, que realiza uma série de verificações e análises. Essas também são conhecidas como *regras de autorização*. 

Ao final do processo, o autorizador toma uma decisão, aprovando ou não a transação: 
* se aprovada, o valor da transação é debitado do saldo disponível
* senão, impede a transação de ser feita e o processo se encerra.

A aplicação faz:

 * a criação de cartões (todo cartão é criado com um saldo inicial de R$500,00)
 * a obtenção de saldo do cartão
 * a autorização de transações realizadas usando os cartões previamente criados

Regras de autorização

Uma transação pode ser autorizada se:
   * o cartão existir
   * a senha do cartão for a correta
   * o cartão possuir saldo disponível
Caso uma dessas regras não ser atendida, a transação não será autorizada.


##  FEATURES

- feature/HIS-20230000-configuracao-inicial
- feature/HIS-20231000-fluxo-de-cartoes
- feature/HIS-20232000-fluxo-de-transacoes
- feature/HIS-20233000-testes-integrados
- feature/HIS-20234000-ajustes-finais

##  SOLUÇÃO DA APLICAÇÃO

- Spring Boot com interface totalmente REST;

- Java 17;

- Arquitetura hexagonal para maior desacoplamento, mesmo que so se refira a persistencia em banco. Se tratando de projetos maiores podemos ter comunicação com outros servicos, como kafka(producer, listener), endpoints externos;

- Design pattern strategy para as validacoes de cartão;

- Testes unitários com Mockito;

- Testes integrados com RestAssured;

- Docker;

- Maven;

## Contratos dos serviços
### Criar novo cartão
```
Method: POST
URL: http://localhost:8080/cartoes
Body (json):
{
    "numeroCartao": "6549873025634501",
    "senha": "1234"
}
```
#### Possíveis respostas:
```
Criação com sucesso:
   Status Code: 201
   Body (json):
   {
      "senha": "1234",
      "numeroCartao": "6549873025634501"
   } 
-----------------------------------------
Caso o cartão já exista:
   Status Code: 422
   Body (json):
   {
      "senha": "1234",
      "numeroCartao": "6549873025634501"
   } 
```

### Obter saldo do Cartão
```
Method: GET
URL: http://localhost:8080/cartoes/{numeroCartao} , onde {numeroCartao} é o número do cartão que se deseja consultar
```

#### Possíveis respostas:
```
Obtenção com sucesso:
   Status Code: 200
   Body: 495.15 
-----------------------------------------
Caso o cartão não exista:
   Status Code: 404 
   Sem Body
```

### Realizar uma Transação
```
Method: POST
URL: http://localhost:8080/transacoes
Body (json):
{
    "numeroCartao": "6549873025634501",
    "senhaCartao": "1234",
    "valor": 10.00
}
```

#### Possíveis respostas:
```
Transação realizada com sucesso:
   Status Code: 201
   Body: OK 
-----------------------------------------
Caso alguma regra de autorização tenha barrado a mesma:
   Status Code: 422 
   Body: SALDO_INSUFICIENTE|SENHA_INVALIDA|CARTAO_INEXISTENTE (dependendo da regra que impediu a autorização)
```


##  COMO EXECUTAR

Será necessário instalar:

Java 17 (https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
STS, Eclipse ou Intelij (https://spring.io/tools)
Project Lombok (https://projectlombok.org)
Insomnia (https://insomnia.rest/download) - Para executar os endpoints cuja a collection se encontra na raiz do projeto (COLLECTION_MINI_AUTORIZADOR)

