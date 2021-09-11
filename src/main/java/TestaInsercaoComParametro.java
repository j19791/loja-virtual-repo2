import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		//informac��es que vem do usu�rio
		String nome = "Mouse'" ; //aspas simples sao especificas do sql. Erro do usuario. Quabra da aplica��o
		
		String descricao = "Mouse sem fio); delete from produto;"; //injecao de clausula sql
		
		
		//recuperar a conexao
		Connection connection = new ConnectionFacotry().recuperarConexao();
	
		String sql = "INSERT INTO produto (NOME, DESCRICAO) values (?,?)"; 

		//preparar o statement: responsabilidade p/ gerenciar os atributos da clausula sql agora s�o do JDBC
		PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
			
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) { //inicia na posicao 0. tem um pr�ximo? sim, faz o la�o, n�o:sai do la�o
			Integer id = rst.getInt(1); //qdo o parametro index, o valor come�a c/ 1 (ID =1)
			System.out.println("O id criado foi:" + id);
			
		}
		
		
		connection.close();
		
		
		
	}

}
