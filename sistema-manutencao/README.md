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

### **Especificação de Requisitos do Sistema de Gestão de Manutenção Preventiva e Corretiva**

---

#### **1. Introdução**

Este documento descreve a especificação de requisitos para o Sistema de Gestão de Manutenção Preventiva e Corretiva. O sistema foi desenvolvido para gerenciar equipamentos e manutenções de uma empresa, permitindo o controle eficiente do ciclo de vida dos equipamentos, manutenções programadas e corretivas.

---

#### **2. Objetivos do Sistema**

- Facilitar o gerenciamento de equipamentos de uma empresa.
- Permitir o controle de manutenções preventivas e corretivas.
- Gerar relatórios detalhados sobre os equipamentos e manutenções.
- Fornecer uma interface gráfica intuitiva para o usuário realizar operações de cadastro, atualização, consulta e remoção.

---

#### **3. Funcionalidades Principais**

##### **3.1. Módulo de Equipamentos**

- **Cadastro de Equipamentos**: Permitir o registro de novos equipamentos no sistema.
  - Dados obrigatórios: ID, Nome, Marca, Modelo, Ano de Fabricação.
- **Atualização de Equipamentos**: Possibilitar a edição dos dados dos equipamentos cadastrados.
- **Exclusão de Equipamentos**: Permitir a exclusão de equipamentos do sistema.
- **Consulta de Equipamentos**: Listar todos os equipamentos cadastrados ou pesquisar por nome/marca.
- **Exportação de Equipamentos**: Gerar um relatório em formato CSV com a lista de equipamentos.

##### **3.2. Módulo de Manutenções**

- **Agendamento de Manutenção Preventiva**: Permitir que manutenções preventivas sejam agendadas para um equipamento específico.
  - Dados: ID do equipamento, data prevista, descrição do serviço.
- **Registro de Manutenção Corretiva**: Cadastrar manutenções corretivas de equipamentos quando ocorrerem falhas.
  - Dados: ID do equipamento, descrição do problema, data de correção.
- **Consulta de Manutenções**: Listar manutenções agendadas ou realizadas de acordo com o equipamento selecionado.
- **Geração de Relatórios de Manutenção**: Gerar um relatório de manutenções por equipamento ou por período.

##### **3.3. Módulo de Usuários**

- **Cadastro de Usuários**: Permitir o registro de novos usuários no sistema.
  - Dados obrigatórios: Nome, Email, Senha.
- **Autenticação de Usuários**: Permitir login no sistema por meio de email e senha.
- **Gestão de Usuários**: Administrar usuários, com permissões de cadastro, atualização e exclusão.

---

#### **4. Requisitos Funcionais**

1. **Cadastro de Equipamentos**: O sistema deve permitir que o usuário cadastre novos equipamentos com informações como nome, marca, modelo e ano de fabricação.
2. **Cadastro de Manutenções**: O sistema deve permitir agendar manutenções preventivas e registrar manutenções corretivas.
3. **Atualização e Exclusão de Dados**: O sistema deve permitir que os usuários atualizem e excluam os registros de equipamentos e manutenções.
4. **Relatórios**: O sistema deve gerar relatórios sobre os equipamentos e manutenções, exportáveis em CSV.
5. **Controle de Acesso**: O sistema deve implementar um sistema de autenticação com login e senha para diferentes níveis de usuários.

---

#### **5. Requisitos Não Funcionais**

1. **Desempenho**: O sistema deve ser capaz de processar operações de cadastro, consulta e atualização de forma eficiente, sem grandes atrasos.
2. **Segurança**: O sistema deve garantir que somente usuários autenticados possam acessar as funcionalidades.
3. **Usabilidade**: A interface gráfica deve ser intuitiva e fácil de usar, permitindo que os usuários realizem as tarefas sem dificuldades.
4. **Compatibilidade**: O sistema deve ser compatível com múltiplos navegadores e sistemas operacionais.
5. **Manutenibilidade**: O código deve ser modular e organizado, facilitando futuras manutenções e expansões.

---

#### **6. Escopo do Projeto**

O sistema foi projetado para pequenas e médias empresas que necessitam de uma solução para gerenciar equipamentos e suas manutenções. O escopo inclui:
- Cadastro e gerenciamento de equipamentos.
- Controle de manutenções preventivas e corretivas.
- Interface gráfica para interação do usuário.
- Geração de relatórios de equipamentos e manutenções.

Funcionalidades não previstas neste escopo incluem integração com sistemas externos de inventário, notificações automáticas de manutenção, ou um sistema de alerta de falhas.

---

#### **7. Conclusão**

Este documento define os requisitos funcionais e não funcionais que serviram como base para o desenvolvimento do Sistema de Gestão de Manutenção Preventiva e Corretiva. Ele descreve as funcionalidades necessárias para atender às demandas de gerenciamento de equipamentos e manutenções. O sistema foi validado com base nesses requisitos e está pronto para uso em ambientes de produção.
