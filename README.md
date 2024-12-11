# Sistema de Gerenciamento de Medicamentos
Este projeto é um programa gerenciador de estoque de medicamentos desenvolvido em Java. Ele utiliza uma arquitetura orientada a objetos com uma superclasse abstrata Medicamento, que define os atributos compartilhados por todos os tipos de medicamentos, e subclasses que representam categorias específicas de medicamentos. Além disso, o 
sistema possui uma interface gráfica (GUI) para interação com o usuário e se conecta automaticamente a um banco de dados relacional no PhpMyAdmin, hospedado localmente.

## 🚀 Começando

A implementação possui uma interface GUI, utilizando os métodos CRUD aprendidos durante o semestre. Tendo um vasto banco de dados com inúmeros itens já cadastrados no banco, A interface está bem intuitiva, simples de entender, então é possível somente rodar o programa e já começar a inserir informações.

### Funcionalidades

- Cadastro de medicamentos: Inserção de novos medicamentos no sistema.
- Atualização de registros: Alteração de informações de medicamentos já cadastrados.
- Exclusão de medicamentos: Remoção de registros específicos.
- Consulta de medicamentos:
    - Listagem completa.
    - Filtragem por categoria.
    - Visualização de medicamentos próximos ao vencimento.
    - Identificação de medicamentos vencidos.
    - Busca por ID.
    - Consulta de itens com estoque baixo.
- Conexão automática ao banco de dados: Após criar o banco com o comando CREATE DATABASE medicamento_db;, o programa cria e gerencia automaticamente as tabelas necessárias.


🖥️ Interface Gráfica (GUI)

O programa inclui uma interface gráfica intuitiva que permite ao usuário acessar e manipular os dados facilmente. A GUI contém formulários para preenchimento dos atributos obrigatórios e específicos de cada tipo de medicamento, além de filtros para consultas.
## Funcionamento do programa:

**JAVADOC:**
![Imagem do JAVADOC](https://github.com/breno-almeida-dev/PharManager_UPX-2/blob/master/JAVADOC-PharManager.png)

**BANCO DE DADOS:**
![Imagem do banco de dados](https://github.com/breno-almeida-dev/PharManager_UPX-2/blob/master/PharManager-DB.png)


## 📋 Pré-requisitos

Para rodar o projeto, você precisará ter os seguintes softwares instalados:

- **Java JDK** (versão 8 ou superior)
- **IDE Eclipse** ou outra IDE de sua preferência.
- **Banco de dados** construído no seu próprio computador.
- **Driver JDBC** para estabelecer a conexão com o banco de dados.


🔧 Instalação
- Clone este repositório:
    git clone https://github.com/breno-almeida-dev/PharManager_UPX-2.git
  
- Abra o projeto em sua IDE (recomendado o Eclipse).
- Configure as dependências necessárias para o JPA e o driver JDBC.
- Configure as propriedades do banco de dados no arquivo de configuração do JPA. 
- Compile e execute o código diretamente na IDE
  
  

🛠️ Construído com
Ferramentas e bibliotecas utilizadas no projeto:

- **Java SE** - Linguagem de programação.
- **Eclipse IDE** - Ambiente de desenvolvimento.
- **Wampserver** - para criação do banco de dados.



📌 Versão
- Versão 1.0 - Versão inicial do projeto.



✒️ Autores:
   - **Breno Almeida**
   - **Edson Veiga**
   - **Matheus Leone**
   - **Lucas Yoshida**
