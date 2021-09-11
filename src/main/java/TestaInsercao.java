import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		//recuperar a conexao
		Connection connection = new ConnectionFacotry().recuperarConexao();
		
		
		Statement stm = connection.createStatement();
		
		
		stm.execute("INSERT INTO produto (NOME, DESCRICAO) values ('Nouse', 'Mouse sem fio') "
				, Statement.RETURN_GENERATED_KEYS); //qual id do produto criado ?  
		//cuidado: o nome da tabela é case sensitive
		
			
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) { //inicia na posicao 0. tem um próximo? sim, faz o laço, não:sai do laço
			Integer id = rst.getInt(1); //qdo o parametro index, o valor começa c/ 1 (ID =1)
			System.out.println("O id criado foi:" + id);
			
		}
		
		
		connection.close();
		
		
		
	}

}
