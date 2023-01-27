package repository;

import comabemdb.Conexao;
import comabemmodel.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InserirProduto {
    private Conexao conexaoDB;
    private Connection conection;

    public InserirProduto(){
        this.conexaoDB = new Conexao();
        this.conection = this.conexaoDB.getConexao();
    }
    // Realiza o cadastro de um novo produto no banco
    public void inserirProduto(Produto produto) {
        String sql ="INSERT INTO produtos (nomeProduto, valorProduto, quantidade, idUnidadeMedida) VALUES(?, ?, ?, (SELECT idUnidadeMedida  FROM unidademedida WHERE descricao = ?))";
        try {
            PreparedStatement stmt = this.conection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());
            stmt.setString(3, produto.getQuantidade());
            stmt.setString(4, produto.getUnidadeMedida());
            stmt.execute();
            System.out.println("\n" + produto);
            System.out.println("\n Produto cadastrado com sucesso ");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }
}
