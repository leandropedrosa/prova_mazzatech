JSF Portal Mazzatech
=========================

Projeto simples de uma aplicação de Portal Virtual com `JSF 1.2`, `Spring 3.x` e `Hibernate 3.5.x` com o objetivo de explanar as principais features de cada tecnologia e como integra-las de maneira produtiva em um projeto real. O projeto é construído durante os cursos e treinamentos de **JSF 1.2, Spring e Hibernate** ministrados pela [Mazzatech](https://www.mazza.tech/).

Configurando o projeto e banco de dados.
----------------------------------------

Por padrão o projeto está configurado para o banco de dados `MySQL`, mas já que se trata de uma aplicação com `Hibernate`, você pode simplesmente configura-lo para trabalhar com qualquer outro banco.

Os passos básicos são:

1. Importe o projeto no [Eclipse Java EE IDE for Web Developers (Galileo)](http://www.eclipse.org/downloads/) ou superior; 
2. Adicione o JDBC Driver no diretório `/WebContent/WEB-INF/lib` caso não pretenda utilizar o `MySQL`;
3. Configure as informações do banco no arquivo `src/jdbc.properties`;
4. Crie o banco de dados `portal` e `portal_test` com a ferramenta de sua preferência (como o `PGAdmin`, no caso do `MySQL`);
5. Faça o deploy no `Apache Tomcat 6.x` e inicie o servidor;
6. Insria um novo usuário no banco (tabela `USUARIO`) para que seja possível logar na aplicação;
7. Acesse a aplicação através da url [http://localhost:8080/portal](http://localhost:8080/portal) ;
8. Faça o login com o usuário criado;

Gerando .war da aplicação
------------------------
1. Para gerar o `.war` da aplicação basta executar o ant script (`build.xml`) no Eclipse ou na linha de comando:

		$ ant

2. Após ter executado o ant script o `.war` será gerado em `/target/war/snapshot/portal.war`;

Informações adicionais
------------------------

* O schema do banco de dados, `portal`, será criado pelo `Hibernate` ao iniciar a aplicação pela primeira vez;
* O schema do banco de dados de testes, `portal_test`, será criado pelo `Hibernate` ao rodar a bateria de testes ou o build pela primeira vez;
* Os diretórios de _source_ `/test/unit` e `/test/integration` possuem as classes de testes automatizados; 
* Dentro do diretório `/lib/app` você encontra todas as libs e dependências organizadas de cada framework;
* Dentro do diretório `/lib/app/jdbc` é possível encontrar alguns drivers já disponíveis, como `MySQL` e `PostgreSQL`;

Mais informações
----------------

**Leandro Pedrosa**
- Meu [Linkedin](https://www.linkedin.com/in/leandro-p-a28291103/)
