# loja-virtual-repo2
Anota��es do curso Java e JDBC

## Usando um BD
- biblioteca Java (jar): 
- desenvolvido pela equipe do MySQLconhece o MYSQL e exp�e p/ a aplica��o Java tudo o q for necess�rio p/ comunica��o
- Driver: Mysql/JAva
- Driver SQLServer/Java
- JDBC: camada de abstra��o - p/ n�o alterar o c�digo da aplica��o qdo � alterado o Servidor BD. Basta a aplica��o conhecer o JDBC
	- java.sql.* 

## Conex�o
- necess�rio dependencia mysql-connector-java

## Comandos sSQL
-statements: clausulas select, insert, etc

## ConnectionFactory
- Factory: Design pattern que encapsula e centraliza c�digo que cria objetos. 
- Quando o endponint, usuario ou senha mudar, n�o � mais necess�rio buscar no c�digo todos os locais que abrem conex�o c/ o bd


