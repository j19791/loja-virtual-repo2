# loja-virtual-repo2
Anotações do curso Java e JDBC

## Usando um BD
- biblioteca Java (jar): 
- desenvolvido pela equipe do MySQLconhece o MYSQL e expõe p/ a aplicação Java tudo o q for necessário p/ comunicação
- Driver: Mysql/JAva
- Driver SQLServer/Java
- JDBC: camada de abstração - p/ não alterar o código da aplicação qdo é alterado o Servidor BD. Basta a aplicação conhecer o JDBC
	- java.sql.* 

## Conexão
- necessário dependencia mysql-connector-java

## Comandos SQL
-statements: clausulas select, insert, etc

## ConnectionFactory
- Factory: Design pattern que encapsula e centraliza código que cria objetos. 
- Quando o endponint, usuario ou senha mudar, não é mais necessário buscar no código todos os locais que abrem conexão c/ o bd

## Evitando SQL Injection
- no statement:  "Mouse sem fio); delete from produto;";` 
- PreparedStatement: valida p/ evitr o sqlInjection
