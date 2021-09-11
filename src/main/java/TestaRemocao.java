import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		//recuperar a conexao
		Connection connection = new ConnectionFacotry().recuperarConexao();		
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE id > ? ");
		
		stm.setInt(1, 2);
		
		stm.execute(); //  		
			
		Integer linhasModificadas = stm.getUpdateCount(); //qtas linhas foram modificadas (deletadas)??
		
		System.out.println("Qtd linhas modificadas: " + linhasModificadas);	
		
		connection.close();
		
		
		
	}

}
