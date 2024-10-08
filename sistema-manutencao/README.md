### Manual do Usuário: Sistema de Gestão de Manutenção Preventiva e Corretiva

---

#### Sumário:
1. **Introdução**
2. **Requisitos do Sistema**
3. **Instalação**
4. **Iniciando o Sistema**
5. **Visão Geral das Funcionalidades**
   - 5.1 Cadastro de Usuários
   - 5.2 Cadastro de Equipamentos
   - 5.3 Gerenciamento de Manutenções
   - 5.4 Geração de Relatórios em CSV
6. **Navegando na Interface Gráfica**
   - 6.1 Tela Principal
   - 6.2 Tela de Usuários
   - 6.3 Tela de Equipamentos
   - 6.4 Tela de Manutenções
7. **Solucionando Problemas Comuns**

---

### 1. Introdução

Este documento é o manual do usuário para o **Sistema de Gestão de Manutenção Preventiva e Corretiva**, uma aplicação que permite o cadastro e gerenciamento de usuários, equipamentos e manutenções, além da geração de relatórios em formato CSV. O sistema oferece uma interface gráfica amigável, onde você pode interagir com as principais funcionalidades.

### 2. Requisitos do Sistema

Para executar o sistema, você precisará dos seguintes itens:

- **Java JDK 17 ou superior**
- **PostgreSQL** (banco de dados)
- **Maven** (para gerenciamento de dependências e build)
- Sistema operacional compatível: **Windows**, **MacOS** ou **Linux**

### 3. Instalação

1. **Clone o projeto do GitHub**:
   ```
   git clone https://github.com/seuprojeto/sistema-manutencao.git
   ```

2. **Compile o projeto usando Maven**:
   - No diretório do projeto, execute:
     ```
     mvn clean install
     ```

3. **Configure o Banco de Dados**:
   - Crie um banco de dados no PostgreSQL com o nome desejado.
   - No arquivo `ConexaoDB.java`, configure as credenciais de acesso ao banco de dados (usuário, senha e nome do banco).

4. **Execute a aplicação**:
   - Após a configuração, você pode executar o projeto com o seguinte comando:
     ```
     mvn exec:java
     ```

### 4. Iniciando o Sistema

Assim que a aplicação for iniciada, a **Tela Principal** será exibida, oferecendo acesso às funcionalidades do sistema, como gerenciamento de usuários, equipamentos, manutenções e geração de relatórios.

### 5. Visão Geral das Funcionalidades

#### 5.1 **Cadastro de Usuários**
- **Adicionar**: Permite o cadastro de novos usuários, incluindo nome, email e senha.
- **Editar**: Possibilita modificar os dados de usuários já cadastrados.
- **Excluir**: Remove um usuário do sistema.
- **Visualizar Todos**: Exibe todos os usuários cadastrados no sistema.

#### 5.2 **Cadastro de Equipamentos**
- **Adicionar**: Cadastra novos equipamentos, incluindo nome, descrição, status e data de aquisição.
- **Editar**: Atualiza as informações de equipamentos.
- **Excluir**: Remove equipamentos do sistema.
- **Visualizar Todos**: Lista todos os equipamentos cadastrados.

#### 5.3 **Gerenciamento de Manutenções**
- **Cadastrar Manutenção**: Permite cadastrar manutenções corretivas e preventivas para os equipamentos.
- **Atualizar Manutenção**: Modifica informações sobre manutenções.
- **Visualizar Manutenções**: Exibe uma lista de todas as manutenções registradas.

#### 5.4 **Geração de Relatórios em CSV**
- **Relatório de Equipamentos**: Gera um arquivo CSV com todos os equipamentos cadastrados, que pode ser utilizado para auditorias ou compartilhamento.
- **Relatório de Manutenções**: (opcional) Gera um relatório de manutenções realizadas no sistema.

### 6. Navegando na Interface Gráfica

A interface gráfica é projetada para facilitar o acesso às principais funcionalidades.

#### 6.1 **Tela Principal**
A tela principal oferece acesso a todas as seções do sistema. Você verá botões para acessar os cadastros de usuários, equipamentos e manutenções, além de uma opção para gerar relatórios.

#### 6.2 **Tela de Usuários**
Na tela de usuários, você pode adicionar novos usuários, editar ou remover os já existentes, e visualizar uma lista completa.

#### 6.3 **Tela de Equipamentos**
Aqui você pode gerenciar os equipamentos da empresa. Para cada equipamento, você pode especificar informações detalhadas e adicionar manutenções.

#### 6.4 **Tela de Manutenções**
A tela de manutenções permite criar registros para manutenções preventivas ou corretivas. Além disso, você pode editar manutenções ou removê-las se necessário.

### 7. Solucionando Problemas Comuns

1. **Erro de Conexão com o Banco de Dados**:
   - Verifique se as credenciais no arquivo `ConexaoDB.java` estão corretas e se o banco de dados está em execução.

2. **CSV Não Gerado**:
   - Verifique se o diretório onde o CSV está sendo salvo existe e tem permissões de escrita.

3. **Aplicação Não Inicia**:
   - Certifique-se de que o Maven foi corretamente configurado e todas as dependências estão instaladas. Verifique também o log do console para mensagens de erro.

---

### Contato para Suporte

Se você encontrar problemas ou precisar de mais ajuda, entre em contato com o administrador do sistema ou consulte a documentação técnica fornecida com o projeto.

---

Este manual deve cobrir a maioria das necessidades dos usuários para utilizar o **Sistema de Gestão de Manutenção Preventiva e Corretiva**.

### Escopo do Projeto: Sistema de Gestão de Manutenção Preventiva e Corretiva

---

#### 1. **Objetivo do Projeto**

O objetivo do **Sistema de Gestão de Manutenção Preventiva e Corretiva** é oferecer uma solução para o controle de manutenções de equipamentos em empresas. O sistema permite cadastrar usuários, equipamentos, e manutenções, além de gerar relatórios em formato CSV. A aplicação visa melhorar o acompanhamento de manutenções, evitar falhas inesperadas e garantir que todos os registros sejam devidamente documentados.

---

#### 2. **Funcionalidades Principais**

##### 2.1 **Cadastro de Usuários**
- **Descrição**: Permite o gerenciamento de usuários do sistema, incluindo operações como adicionar, editar, remover e listar.
- **Requisitos**:
  - Inserção de nome, e-mail e senha.
  - Validação de dados.
  - Exibição de lista com todos os usuários cadastrados.

##### 2.2 **Cadastro de Equipamentos**
- **Descrição**: Gerenciamento de equipamentos, permitindo adicionar, editar, remover e visualizar os equipamentos que precisam de manutenção.
- **Requisitos**:
  - Nome do equipamento, descrição, status e data de aquisição.
  - Exibição da lista de equipamentos.

##### 2.3 **Gerenciamento de Manutenções**
- **Descrição**: Controle de manutenções corretivas e preventivas dos equipamentos, com a possibilidade de cadastrar, editar e remover manutenções.
- **Requisitos**:
  - Registro de manutenções preventivas (planejadas) e corretivas (emergenciais).
  - Informações de data, descrição da manutenção, e status.
  - Lista de manutenções por equipamento.

##### 2.4 **Relatórios em CSV**
- **Descrição**: Geração de relatórios em formato CSV dos equipamentos e manutenções registradas no sistema.
- **Requisitos**:
  - Relatório de equipamentos cadastrados.
  - Relatório de manutenções realizadas, com opção de filtragem.

---

#### 3. **Requisitos Funcionais**

- **Cadastro de Usuários**: O sistema deve permitir o cadastro de múltiplos usuários, com operações de CRUD (Create, Read, Update, Delete).
- **Cadastro de Equipamentos**: O sistema deve permitir o cadastro de equipamentos e associá-los a manutenções futuras.
- **Cadastro de Manutenções**: O sistema deve permitir o registro de manutenções preventivas e corretivas para os equipamentos cadastrados.
- **Relatórios em CSV**: O sistema deve exportar os dados de equipamentos e manutenções para arquivos CSV.
- **Persistência de Dados**: Os dados devem ser armazenados em um banco de dados PostgreSQL.

---

#### 4. **Requisitos Não Funcionais**

- **Usabilidade**: A interface gráfica deve ser intuitiva e fácil de usar.
- **Performance**: O sistema deve ser eficiente para lidar com o cadastro de múltiplos equipamentos e manutenções, gerando relatórios em um tempo razoável.
- **Segurança**: O sistema deve garantir que os dados dos usuários estejam protegidos com autenticação e criptografia de senhas.
- **Portabilidade**: O sistema deve ser executável em qualquer plataforma que suporte Java, com configuração mínima para o banco de dados PostgreSQL.

---

#### 5. **Tecnologias Utilizadas**

- **Linguagem de Programação**: Java
- **Banco de Dados**: PostgreSQL
- **Gerenciamento de Dependências**: Maven
- **Biblioteca de Relatórios**: OpenCSV
- **Interface Gráfica**: Swing
- **Controle de Versão**: Git

---

#### 6. **Escopo Excluído (Out of Scope)**

- Integração com APIs externas de manutenção.
- Controle de estoque de peças.
- Monitoramento em tempo real dos equipamentos.
- Geração automática de alertas via e-mail ou SMS.

---

#### 7. **Cronograma Estimado**

1. **Fase 1 - Definição e Planejamento** (1 semana)
   - Definir os requisitos funcionais e não funcionais.
   - Criar o escopo e cronograma do projeto.

2. **Fase 2 - Desenvolvimento** (3 semanas)
   - Implementação do backend (modelos e controle de dados).
   - Implementação da interface gráfica.
   - Integração do sistema com o banco de dados.

3. **Fase 3 - Testes** (1 semana)
   - Testes unitários dos métodos de cadastro e relatórios.
   - Testes de integração com a interface gráfica.

4. **Fase 4 - Documentação e Entrega Final** (1 semana)
   - Finalização da documentação técnica e manual do usuário.
   - Entrega final do código-fonte e artefatos.

---

#### 8. **Conclusão**

Este escopo define os limites e objetivos do **Sistema de Gestão de Manutenção Preventiva e Corretiva**, garantindo que as funcionalidades essenciais para o controle de manutenções de equipamentos sejam implementadas de forma eficiente. O projeto busca oferecer uma solução prática e completa, que pode ser personalizada para atender às necessidades específicas de cada empresa.