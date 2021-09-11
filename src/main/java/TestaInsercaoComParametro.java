import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		
		//recuperar a conexao
		Connection connection = new ConnectionFacotry().recuperarConexao();
		connection.setAutoCommit(false);//tira a responsabilidade do JDBC de fazer o commit das transa��es. O commit agora voce dever� explicitar
	
		String sql = "INSERT INTO produto (NOME, DESCRICAO) values (?,?)"; 

		try {
			//preparar o statement: responsabilidade p/ gerenciar os atributos da clausula sql agora s�o do JDBC
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			//adicionar os 2 produtos ou nenhum
			adicionarVariavel("SmartTV", "45 polegadas",  stm);
			adicionarVariavel("Radio", "Radio de bateria",  stm);
			
			connection.commit();//se ocorrer tudo bem na transacao
			
			stm.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//me fala qual foi a exception
			System.out.println("roolback executado");
			connection.rollback();
		}
		
	}

	private static void adicionarVariavel(String nome, String descricao,   PreparedStatement stm)
			throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		if(nome.equals("Radio"))
			throw new RuntimeException("simular erro");
		
		stm.execute();
		
			
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) { //inicia na posicao 0. tem um pr�ximo? sim, faz o la�o, n�o:sai do la�o
			Integer id = rst.getInt(1); //qdo o parametro index, o valor come�a c/ 1 (ID =1)
			System.out.println("O id criado foi:" + id);
			
		}
		
		
		
	}

}
