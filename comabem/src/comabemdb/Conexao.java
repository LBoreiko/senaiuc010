package comabemdb;
import java.sql.*;
// Classe que realiza a conexão com o Banco de Dados
public class Conexao {
    public Conexao(){}

    // Informações de endereço para conexão
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/senaiuc010";

    // Validação de conexão
    public Connection getConexao() {
        try{
            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "Le@@2020");
            return connection;
        }catch (SQLException se){
            se.printStackTrace();
        }
        return null;
    }

}
