<p align="center">
  <a href="#sobre">TDD</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#desafio">Desafio</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#resolucao">Resolução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#execucao">Execução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#licenca">Licença</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#desenvolvedora">🙋🏻‍♀️</a>
</p>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=PRs&message=welcome&color=49AA26&labelColor=000000" alt="PRs welcome!" />

  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=49AA26&labelColor=000000" />

</p>

# TDD - Test Driven Development Challenge

<h2 id="sobre">Sobre TDD - Test Driven Development</h2> 

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


<h2 id="desafio">Desafio</h2> 

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
<img src="https://user-images.githubusercontent.com/83084256/134748894-84cfbf7e-d32b-4cce-b4c1-965c2ccc848f.png" width="450"/>


<h2 id="resolucao">Resolução</h2> 

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

<img src="https://user-images.githubusercontent.com/83084256/134752571-774a1518-c6a7-4ac6-876e-bddf19429b0b.png" width="250" height="200" />

### 🚧 Delete City Id existente, Id inexistente e violação de integridade DB
Com os pacotes controllers e services já criados escrevi o código voltado ao Delete, implementando a lógica sobre o tratamento de exceção ensinada pelo professor no projeto DSCatalog. Criando um pacote de exceção no controller, adicionando uma classe de Erro Padrão e um Manipulador de Exceções utilizando a annotation @ExceptionHandler e tratando o NOT FOUND e BAD REQUEST. No Services também criei o pacote de exceção tratando a violação de integridade do DB no caso de exclusões de objetos relacionados.

<img src="https://user-images.githubusercontent.com/83084256/134749186-de793542-3c50-4466-89f8-a80f4d71e282.png" width="250" height="200" />
<img src="https://user-images.githubusercontent.com/83084256/134749217-9b308716-7810-49e0-b6fc-17f1fd374933.png" width="250" height="200" />
<img src="https://user-images.githubusercontent.com/83084256/134749358-d9443f9b-f5f4-4a83-85bb-b6b35efe7ad0.png" width="250" height="200" />

### 🚧 Update Event Id existente e Id inexistente
No caso do Update, antes de incluí-lo e mesmo não havendo teste para essa funcionalidade, senti a necessidade de trazer uma lista dos eventos bem como buscá-lo pelo Id, de forma que eu conseguisse me certificar usando o Postman de que a atualização foi bem sucedida para então validar o teste.

<img src="https://user-images.githubusercontent.com/83084256/134749408-9f491e77-bbfe-4705-9c01-3f0eac00afcf.png" width="250" height="200" />
<img src="https://user-images.githubusercontent.com/83084256/134749487-b84bbcc9-d5a1-463e-b48d-838a1e88abbd.png" width="250" height="200" />
<img src="https://user-images.githubusercontent.com/83084256/134749436-9a30f801-8f01-42cd-8817-092d1e78d6db.png" width="250" height="200" />
<img src="https://user-images.githubusercontent.com/83084256/134749532-62cc9232-c150-4b7a-9e29-924ed1d6815a.png" width="250" height="200" />
<img src="https://user-images.githubusercontent.com/83084256/134749551-5001f1d5-d9f8-48e0-938c-dc69a9fe1c16.png" width="250" height="200" />

### 👩‍💻 Insert - Porque a gente ❤️ um CRUD!
No desafio não existe teste para essa funcionalidade, nem necessidade de ser implementado para as demais funcionalidades, mas como só faltava o Create (Insert) para um CRUD completo resolvi escrever o código 🤭.

<img src="https://user-images.githubusercontent.com/83084256/134749606-d153cb93-5c67-4c26-b790-51f51ba39f62.png" width="250" height="200" />
<img src="https://user-images.githubusercontent.com/83084256/134749640-1f0c6454-bb63-442f-8b2a-4393d8d2fef9.png" width="250" height="200" />


<h2 id="tecnologias">🚀 Tecnologias</h2> 

- Java 11
- Spring Boot
- JPA
- Maven


<h2 id="execucao">Execução</h2> 

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

<h2 id="licenca">📃 Licença</h2> 

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](.github/LICENSE.md) para mais detalhes.

<h2 id="desenvolvedora">Desenvolvedora</h2> 
<img src="https://user-images.githubusercontent.com/83084256/134750093-acf555ae-b1b0-4a4e-a22c-421bf98f15a0.png" width="150" border-radius="50%" />
<br>
<a href="https://www.linkedin.com/in/lilian-martins-fritzen/">
    <img src="https://img.shields.io/static/v1?label=Linkedin&message=lilianmartinsfritzen&color=0A66C2&style=for-the-badge&logo=linkedin" />
</a>
