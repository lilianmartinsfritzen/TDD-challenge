<p align="center">
  <a href="#-sobre">TDD</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-desafio">Desafio</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-resolucao">Resolução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-execucao">Execução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#licenca">Licença</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#desenvolvedora">🙋🏻‍♀️</a>
</p>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=PRs&message=welcome&color=49AA26&labelColor=000000" alt="PRs welcome!" />

  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=49AA26&labelColor=000000" />

</p>

# TDD - Test Driven Development Challenge


## Sobre TDD - Test Driven Development

Consiste em um desenvolvimento guiado por testes, esse método de desenvolver software se apoia em um ciclo curto de repetições e associa-se ao conceito de verificação e validação. O código é escrito a fim de validar as necessidades descritas no teste automatizado juntamente com as do software, portanto, o teste é desenvolvido primeiro e posteriormente é criado um código que inicialmente possa ser validado, sendo refatorado para alcançar padrões aceitáveis.

**Benefícios em sua aplicabilidade:**
- Foco principal nos requisitos.
- Exige uma preocupação maior durante a escrita do código, na intenção atender as necessidades do teste, causando uma melhora o design do código.
- Menos suscetível a erros/quebras na aplicação, mesmo ocorrendo incrementos no projeto.

**Processo básico de desenvolvimento:**
- Desenvolva o teste.
- Escreva o código necessário para que seja validado pelo o teste.
- Execute os teste automatizados.
- Refatore o código, ter um código limpo, legível é importante.

Fonte: [Wikipedia-TDD](https://pt.wikipedia.org/wiki/Test-driven_development#2._Execute_todos_os_testes_e_veja_se_algum_deles_falha "Wikipedia Test-driven development")


## Desafio
O professor Nelio Alves da [Escola DevSuperior](https://devsuperior.com.br/ "Site da Escola DevSuperior") propos como desafio para o final do capítulo 2 - Testes Automatizados do Bootcamp Spring e React a tarefa abaixo.

TAREFA: TDD Event-City

Implemente as funcionalidades necessárias para que os testes do projeto bds02 passem:
https://github.com/devsuperior/bds02

- Teste de Integração CityController: Delete deve excluir a cidade e retornar 204 No Content. 
- Teste de Integração CityController: Delete deve retornar 404 Not Found ao tentar excluir uma cidade com Id inexistente.
- Teste de Integração CityController: FindAll deve retornar uma lista não paginada com todas as cidades ordenadas por nomes na posição ascendente.
- Teste de Integração CityControllerDataIntegrity: Delete deve retornar 400 Bad Request quando a cidade estiver relacionada com um evento.
- Teste de Integração EventController: Update deve retornar o evento atualizado e 200 Ok.
- Teste de Integração EventController: Update deve retornar 404 Not Found na tentativa de atualizar um evento com Id inexistente.

Este é um sistema de eventos e cidades com uma relação N-1 entre eles:
![Sistema de Eventos e Cidades](https://assets/sistema-eventos-cidade.png)


## Resolução

O professor Nélio trouxe as entidades e o DTO de City e Events já implementados, juntamente com os testes.
Após analisar os testes resolvi seguir a seguinte ordem de implementação dos códigos:
- FindAll City
- Delete Id existente City
- Delete Id inexistente City
- Delete com violação de integridade DB City
- Update Id existente Event
- Update Id inexistente Event

### 🚧 FindAll City
Iniciei criando os pacotes repositories, em seguida o controllers e services com a classe City, como a busca não era paginada, não houve necessidade de passar argumentos ao findAll. Utilizei a variação Sort.by para dizer que a lista de cidades deveria retornar ordenadamente por nome. Fiz a checagem usando o Postman antes de passar o Teste. Não foi exigido pelo professor, porém checagem com o Postman é uma boa prática ensinada por ele.

![Postman - FindAll Cities](https://assets/postman-findAll-cities.png)

### 🚧 Delete City Id existente, Id inexistente e violação de integridade DB
Com os pacotes controllers e services já criados escrevi o código voltado ao Delete, implementando a lógica sobre o tratamento de exceção ensinada pelo professor no projeto DSCatalog. Criando um pacote de exceção no controller, adicionando uma classe de Erro Padrão e um Manipulador de Exceções utilizando a annotation @ExceptionHandler e tratando o NOT FOUND e BAD REQUEST. No Services também criei o pacote de exceção tratando a violação de integridade do DB no caso de exclusões de objetos relacionados.

![Postman - Delete City - No Content](https://assets/postman-delete-city-noContent.png)
![Postman - Delete City - Not Found](https://assets/postman-delete-city-notFound.png)
![Postman - Delete City - Bad Request](https://assets/postman-delete-city-badRequest.png)

### 🚧 Update Event Id existente e Id inexistente
No caso do Update, antes de incluí-lo e mesmo não havendo teste para essa funcionalidade, senti a necessidade de trazer uma lista dos eventos bem como buscá-lo pelo Id, de forma que eu conseguisse me certificar usando o Postman de que a atualização foi bem sucedida para então validar o teste.

![Postman - Events FindAll](https://assets/postman-events-findAll.png)
![Postman - Event FindById](https://assets/postman-event-findById.png)
![Postman - Event Update](https://assets/postman-event-updateOk.png)
![Postman - Event FindById após Update](https://assets/postman-findById-event-updateOk.png)
![Postman - Event Update Not Found](https://assets/postman-event-update-notFound.png)

### 👩‍💻 Insert - Porque a gente ❤️ um CRUD!
No desafio não existe teste para essa funcionalidade, nem necessidade de ser implementado para as demais funcionalidades, mas como só faltava o Create (Insert) para um CRUD completo resolvi escrever o código 🤭.

![Postman - Created Event](https://assets/postman-insert201created.png)
![Postman - FindById novo Event](https://assets/postman-event-findByIdEventIsertOk.png)


## 🚀 Tecnologias
- Java 11
- Spring Boot
- JPA
- Maven


## Execução

Pré-requisitos: **Java 11 e Postman (ou a API Client que preferir)**

```bash
# Clonar repositório
git clone https://github.com/lilianmartinsfritzen/TDD-challenge
# Entrar na pasta abaixo
cd bds02-TDD-challenge
# Executar o projeto
./mvnw spring-boot:run

# Caminhos utilizados no Postman
GET - All Cities: http://localhost:8080/cities
GET - All Events: http://localhost:8080/events
GET - Event by Id: http://localhost:8080/events/5
DEL - Delete City Id existente e sem relação: http://localhost:8080/cities/5
DEL - Delete City Id inexistente: http://localhost:8080/cities/50
DEL - Delete City Id existente e com relação: http://localhost:8080/cities/1

# Caminhos utilizados com corpo
PUT - Update Event Id existente: http://localhost:8080/events/1

{
    "name" : "Software Fair",
    "date" : "2021-09-30",
    "url" : "https://softwarefair.com",
    "cityId" : "7"
}

PUT - Update Event Id inexistente: http://localhost:8080/events/1000

{
    "name" : "Software Fair",
    "date" : "2021-09-30",
    "url" : "https://softwarefair.com",
    "cityId" : "7"
}

POST - Insert Event Id existente: http://localhost:8080/events

{
    "name": "Next.js Conf",
    "date": "2021-10-26",
    "url": "nextjs.org/conf",
    "cityId": 9
}

```

## 📃 Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](.github/LICENSE.md) para mais detalhes.

### Desenvolvedora
<img src="assets/images/lilian.png" width="300">

<img src="https://img.shields.io/static/v1?label=Linkedin&message=lilianmartinsfritzen&color=0A66C2&style=for-the-badge&logo=linkedin"></a>














