# Projeto de um micro serviço para gestão de Cursos - README

<img width="30%"  src="./imageREADME/CompassLogo.svg"/>

Este é o repositório do projeto micro serviço para gestão de cursos desenvolvido como parte do estágio na Compass UOL. Abaixo estão as informações do projeto.

## Desenvolvedores

- Elias Mathias Sand: [elias.sand.pb@compasso.com.br](mailto:elias.sand.pb@compasso.com.br)
- Joao Pedro Golenia: [joao.golenia.pb@compasso.com.br](mailto:joao.golenia.pb@compasso.com.br)
- Jonas Roberto Leandro: [jonas.leandro.pb@compasso.com.br](mailto:jonas.leandro.pb@compasso.com.br)
- Lucas Henrique Teixeira Ribeiro [lucas.teixeira.pb@compasso.com.br](mailto:lucas.teixeira.pb@compasso.com.br)

## Instrutores (PO)

- **Rafael Henrique Menegon:** [@devrafamenegon](https://github.com/devrafamenegon)
- **Edmar Miller Gabriel:** [edmarmiller@hotmail.com](mailto:edmarmiller@hotmail.com)
- **Cleiton Fiatkoski Balansin:** [cleiton.balansin@compasso.com.br](mailto:cleiton.balansin@compasso.com.br)
- **Mateus de Oliveira e Silveira:** [@mosilveira](https://github.com/mosilveira)
- **João Caetano Nicoli Tavares:** [jaonicoli@gmail.com](mailto:jaonicoli@gmail.com)
- **Rafael Luz de Queiroz**: [rafinhalq@gmail.com](mailto:rafinhalq@gmail.com)
- **Lucas Magno Peixoto Lima**: [lucasmagno695@gmail.com](mailto:lucasmagno695@gmail.com)
- **Manoel Rosa**: [guiguel@gmail.com](mailto:guiguel@gmail.com)

## Período

- Período de desenvolvimento: 06/05/2024 até 13/05/2024 às 12:00;

## Itens Obrigatórios

- Utilização do Git/GitHub com duas branches fixas: main e dev. (A main só deve receber dados advindas de dev);
- Padronização das branches de funcionalidades com o formato: [nome-do-microserviço]/[feature]-[nome_da_funcionalidade];
- Adoção de commits semânticos;
- Inclusão de documentação abrangente no README (obrigatório a inclusão de uma lista com todos os endpoints da aplicação);
- Uso de boas práticas;
- Utilize banco de dados H2 em arquivo independentes para cada aplicação;
- Todos os micro serviços devem ter documentação de API (Swagger);
- Comunicação entre micro serviços deve ser HTTP (OpenFeign);
- Crie uma collection do Postman e anexe ela ao projeto no GitHub, contendo todos os endpoints e com uma boa organização;
- Os micro serviços devem ter cobertura de teste de no mínimo 30%;
- Todos os endpoints devem obedecer as finalidades de funcionamento dos métodos HTTP, assim como os retornos HTTP status code coerentes.

## Prazo

- O envio do repositório do desafio deve ser enviado até às 12hrs do dia 13/05.

## Requisitos

### Entidades

Curso: nome, quantidade de horas, professor, área do conhecimento, ativo.

### Funcionalidades

1. Cadastrar curso;
2. Inabilitar curso;
3. Alterar professor de um curso já cadastrado.

### Funcionalidades Adicionais
- Curso pode ser ativado novamente;

### Regras

- Nome de cursos não podem se repetir;
- Deve-se criar novas entidades e/ou campos caso necessário;
- Deve-se criar todos os endpoints necessários;
- Todas as validações que o sistema possui devem retornar erros específicos com detalhamento sobre a validação;
- O campo área do conhecimento deve ser um ENUM interno ao projeto com uma lista pré-definida, que deve constar na documentação;

## Etapas de Desenvolvimento

- Criação do pom.xml com as dependências: Spring Data JPA, Spring Web, Spring Boot DevTools, Lombok, H2 Database, ModelMapper, SpringDoc, Validation;

- Criação da estrutura básica do projeto com as entidades;

- Configuração no application.properties do H2 e JPA;

- Implementação dos endpoints solicitados;

- Configuração do Locale no application.properties e criação da classe de configuração do fuso horário;

- Tratamento das exceções;

- Criação da classe SpringDoc para configurar o swagger e adicionar das anotações;

- Realização dos testes;


## Utilização

- Endereço base para requisições: http://localhost:8080;
- Endereço para documentação Swagger: http://localhost:8080/docs-api.html;

- Endereço para acesso do banco de dados h2: http://localhost:8080/h2-console;
- Acesso h2:
- JDBC URL: jdbc:h2:file:./curso;
- User Name: root;
- Password: 1234;
  
### ENUM de Areas de conhecimento
     PROGRAMACAO,
     DESIGN,
     MATEMATICA,
     CIENCIAS,
     HISTORIA,
     LETRAS;

### Endpoints

**POST** - http://localhost:8080/api/v1/cursos
- Cadastra um novo curso;
- No corpo da requisição deve ser informado um nome, quantidade de horas, nome do professor e área de conhecimento de acordo com as áreas de: PROGRAMACAO, DESIGN, MATEMATICA, CIENCIAS, HISTORIA, LETRAS;

Ex. de dados necessários no body:
```Json
{
  "nome": "string",
  "quantidadeDeHoras": 0,
  "professor": "string",
  "areaConhecimento": "PROGRAMACAO"
}
```

<br></br>

**PATCH** - http://localhost:8080/api/v1/cursos/{id}/alterar_professor
- Altera o professor de um curso;
- No endereço url deve ser informado o id do curso e o no corpo da requisição o nome do professor;

<br></br>

**PATCH** - http://localhost:8080/api/v1/cursos/inativar/{id}
- Inativa curso por id;
- No endereço url deve ser informato o id do curso;

<br></br>

**GET** - http://localhost:8080/api/v1/cursos/{nome}
- Busca o curso pelo nome;
- No endereço url deve ser informado o nome do curso;

Ex. dados retornados:
```Json
{
  "id": 0,
  "nome": "string",
  "quantidadeDeHoras": 0,
  "professor": "string",
  "areaConhecimento": "PROGRAMACAO",
  "ativo": true
}
```

<br></br>

**GET** - http://localhost:8080/api/v1/cursos/id/{id}
- Busca o curso pelo id;
- No endereço url deve ser informato o id do curso;

Ex. dados retornados:
```Json
{
  "id": 0,
  "nome": "string",
  "quantidadeDeHoras": 0,
  "professor": "string",
  "areaConhecimento": "PROGRAMACAO",
  "ativo": true
}
```
