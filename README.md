# atividade-udesc-jpa
Atividade acadêmica desenvolvida na Universidade do Estado de Santa Catarina (UDESC) com o objetivo de implementar um modelo de entidade-relacionamento utilizando a especificação JPA (Java Persistence API) para persistência de dados em um banco de dados relacional.

## Tecnologias
- **Java 8** (LTS)
- **Maven 3.9.x**
- **JPA / Hibernate 6.x**
- **PostgreSQL 12**

## Configuração

### Pré-requisitos
1. **JDK 8** instalado e configurado no PATH.
2. **Maven** instalado para gerenciamento de dependências e build.
3. **PostgreSQL** em execução localmente.

### Configuração do Ambiente Local
O projeto utiliza o arquivo `persistence.xml` para gerenciar a conexão com o banco de dados.

#### 2. Configuração de Credenciais
Edite o arquivo `src/main/resources/META-INF/persistence.xml` com suas credenciais locais:
```xml
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
  <persistence-unit name="AtividadePU" transaction-type="RESOURCE_LOCAL">
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <class>br.com.udesc.atividade.entidades.SolicitacaoServico</class>
    <class>br.com.udesc.atividade.entidades.Atividades</class>
    <class>br.com.udesc.atividade.entidades.Server</class>
    <class>br.com.udesc.atividade.entidades.DBA</class>
    <properties>
      <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/atividade-udesc-jpa"/>
      <property name="javax.persistence.jdbc.user" value="seu_usuario"/>
      <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"/>
      <property name="javax.persistence.jdbc.password" value="sua_senha"/>
      <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
    </properties>
  </persistence-unit>
</persistence>
```

## Como funciona
O projeto demonstra a implementação prática de mapeamento objeto-relacional (ORM) seguindo os padrões da disciplina de Persistência de Dados:

1. **Mapeamento de Entidades:** Sem a utilização de anotações
2. **Relacionamentos:**
   - **1:N (One-to-Many):** Ex: DBA pode realizar diversas Atividades.
   - **N:1 (Many-to-One):** Ex: Atividades para um Servidor.
   - **N:N (Many-to-Many):** Ex: Múltiplas Atividades para múltiplos Servidores numa solicitação de serviço.
3. **Camada de Persistência (DAO/Repository):** Implementação do padrão Repository para isolar a lógica de acesso a dados (CRUD) utilizando o `EntityManager`.
4. **Ciclo de Vida:** Gerenciamento de estados das entidades (Transient, Managed, Detached, Removed) através de transações controladas.

## Compilação

### Compilar o Projeto
Para baixar as dependências e compilar o código-fonte:
```bash
mvn clean compile
```

### Gerar Artefato (JAR)
Para gerar o arquivo executável na pasta `target/`:
```bash
mvn clean package -DskipTests
```

## Executando

### Modo Desenvolvimento
Para executar a classe principal que popula o banco de dados e realiza as consultas de teste:
```bash
mvn exec:java -Dexec.mainClass="br.com.udesc.atividade.view.Principal.java"
```


