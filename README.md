# Controle de Estoque - Aplicação de Gerenciamento

Esta aplicação é parte de um sistema de controle de estoque e foi desenvolvida para gerenciar informações de clientes, fornecedores e produtos. Ela permite adicionar novos clientes, fornecedores e produtos, pesquisar registros existentes com base em critérios específicos e exibir os resultados em tabelas. A aplicação foi desenvolvida utilizando a linguagem de programação Java e a estrutura Spring Boot. Além disso, é possível acessar a aplicação por meio de uma interface web.

## Funcionalidades

A aplicação possui as seguintes funcionalidades:

1. **Gerenciamento de Clientes:**
    - **Adicionar Cliente:** Permite adicionar um novo cliente fornecendo informações como nome, telefone, endereço, email e CPF/CNPJ.
    - **Pesquisar Cliente:** Possibilita pesquisar clientes existentes com base em critérios como ID ou nome e exibir os resultados em uma tabela.

2. **Gerenciamento de Fornecedores:**
    - **Adicionar Fornecedor:** Permite adicionar um novo fornecedor informando detalhes como nome, telefone, cnpj, endereço e email.
    - **Pesquisar Fornecedor:** Possibilita pesquisar fornecedores existentes com base em critérios como ID ou nome e exibir os resultados em uma tabela.

3. **Gerenciamento de Produtos:**
    - **Adicionar Produto:** Permite adicionar um novo produto com informações como nome, descrição, preço, quantidade em estoque e tipo de produto.
    - **Pesquisar Produto:** Possibilita pesquisar produtos existentes com base em critérios como ID ou nome e exibir os resultados em uma tabela.

## Estrutura do Código

A estrutura do código é organizada em três partes principais:

1. **Controladores (Controllers):**
   - `ClienteController`: Gerencia as operações relacionadas aos clientes.
   - `FornecedorController`: Gerencia as operações relacionadas aos fornecedores.
   - `ProdutoController`: Gerencia as operações relacionadas aos produtos.

2. **Entidades (Entities):**
   - `Cliente`: Representa a entidade de cliente com atributos como nome, telefone, endereço, email e CPF/CNPJ.
   - `Fornecedor`: Representa a entidade de fornecedor com atributos como nome, telefone, endereço e email.
   - `Produto`: Representa a entidade de produto com atributos como nome, descrição, preço, quantidade em estoque e fornecedor associado.

3. **Repositórios (Repositories):**
   - `ClienteRepository`: Realiza consultas personalizadas relacionadas aos clientes.
   - `FornecedorRepository`: Realiza consultas personalizadas relacionadas aos fornecedores.
   - `ProdutoRepository`: Realiza consultas personalizadas relacionadas aos produtos.

Com essas funcionalidades, a aplicação oferece um conjunto abrangente de recursos para o gerenciamento eficiente de clientes, fornecedores e produtos em um ambiente de controle de estoque.
