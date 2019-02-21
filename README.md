# WirecardChallenge
Projeto desenvolvido para o processo seletivo Pessoa Desenvolvedora de Software da Wirecard do Brasil.
O projeto consisitiu em criar uma aplicação que simule uma API de pagamentos, recebendo as informações de pagamento, processando-as,
e retornando com o resultado da requisição.
A aplicação foi desenvolvida na linguagem Java, utilizando o padrão MVC. Este padrão foi implementado utilizando o Spring MVC com a automatização do Spring Boot. Por padrão estes plugins implementam API gerada com o auxílio destes plugins são RESTful e os resultados
das requisições são retornados no formato JSON. Para a realização do teste o projeto pode ser rodado no Eclipse ou no Spring Tool Suite 4
Vs. 4.1. 
Para o teste pode-se rodar a aplicação que aceitará requisições através da porta 80. Há três requisições que podem ser feitas via Postman, duas passando as informações diretamente e uma requisição GET que retorna uma Checkout page para o input das informações. A mesma página pode ser acessada via navegador.
Para simular as transações via cartão de crédito foi criada uma base de dados com três cartões, dois válidos e um bloqueado. Um objeto StatusVenda é retorna como um JSON apresentando um resumo dos dados da compra que está sendo realizada. Não foi desenvovida uma página para a apresentação des resumo. Mas a integração pode ser feita facilmente utilizando as tecnologias de desenvolvimento frontend.
O arquivo paymentAPI é a base de dados do projeto. O banco de dados utilizado foi o PostgreSQL, para acessá-lo basta fazer um restore no banco com as seguintes informações:
host "localhost" --port "5432" --username "postgres" --no-password --verbose --role "postgres" --format=t --blobs --encoding "UTF8" "paymentAPI"

O foco foi do desenvolvimento foi o funcionamento da aplicação, por isso, validações de campos e de algumas variáveis não foram feitas da maneira apropriada.
