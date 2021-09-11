import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		//recuperar a conexao
		Connection connection = new ConnectionFacotry().recuperarConexao();
		
		
		Statement stm = connection.createStatement();
		boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM produto"); //retorna true qdo o retorno é uma lista. Diferente de lista (insert,delete,etc)= false
		//cuidado: o nome da tabela é case sensitive
		
		System.out.println(resultado);
		
		ResultSet rst = stm.getResultSet();//pega os resultados do statement
		
		while(rst.next()) { //inicia na posicao 0. tem um próximo? sim, faz o laço, não:sai do laço
			Integer id = rst.getInt("ID"); //qdo o parametro index, o valor começa c/ 1 (ID =1)
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		
		connection.close();
		
		System.out.println("teste");
		
	}

}
