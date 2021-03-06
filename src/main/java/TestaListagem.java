import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		//recuperar a conexao
		Connection connection = new ConnectionFacotry().recuperarConexao();
		
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM produto");
		boolean resultado = stm.execute(); //retorna true qdo o retorno ? uma lista. Diferente de lista (insert,delete,etc)= false
		//cuidado: o nome da tabela ? case sensitive
		
		System.out.println(resultado);
		
		ResultSet rst = stm.getResultSet();//pega os resultados do statement
		
		while(rst.next()) { //inicia na posicao 0. tem um pr?ximo? sim, faz o la?o, n?o:sai do la?o
			Integer id = rst.getInt("ID"); //qdo o parametro index, o valor come?a c/ 1 (ID =1)
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		connection.close();			
	}

}
