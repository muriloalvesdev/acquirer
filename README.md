### Este projeto está hospedado no Heroku, caso queira consumir as APIs, a URL base é [ https://module-acquirer.herokuapp.com ]

## Utilizei o Swagger para gerar a documentação das APIs deste projeto.
###### URL da documentação das APIs deste projeto: https://module-acquirer.herokuapp.com/swagger-ui.html#/

### Visão Geral das APIs
![Abaixo está a representação da documentação das APIs com o SWAGGER](https://github.com/muriloalvesdev/acquirer/blob/master/src/main/resources/swagger/swagger-documentation.png)


#### Descrição da API findByCnpj
##### Este endpoint é responsável por buscar a Adquirente cadastrada através de seu CNPJ. Abaixo temos um exemplo do response em formato JSON.
![findByCnpj](https://github.com/muriloalvesdev/acquirer/blob/master/src/main/resources/swagger/swagger-find-by-cnpj.png)


#### Descrição da API saleController
##### Este endpoint é responsável por gerar uma venda encaminhando. Seu response ainda está sendo desenvolvido, meu desejo é gerar um comprovante similar ao de uma maquininha comum.
![saleController](https://github.com/muriloalvesdev/acquirer/blob/master/src/main/resources/swagger/swagger-sale-controller.png)


#### Descrição da API findByMerchancode
##### Este endpoint é responsável por buscar um estabelecimento através do merchantcode informado. Abaixo temos um exemplo do response em formato JSON.
![saleController](https://github.com/muriloalvesdev/acquirer/blob/master/src/main/resources/swagger/establishment-find-by-merchantcode.png)
