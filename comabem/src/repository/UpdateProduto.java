package repository;

import comabemdb.Conexao;
import comabemmodel.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProduto {
    private Conexao conexaoDB;
    private Connection conection;

    public  UpdateProduto(){
        this.conexaoDB = new Conexao();
        this.conection = this.conexaoDB.getConexao();
    }
        // Realiza atualizações no banco de Dados
    public Produto atualizarProduto(Produto produto, String nomeProduto){
        String sql = "UPDATE produtos p INNER JOIN unidademedida un ON p.idUnidadeMedida = un.idUnidadeMedida SET p.nomeProduto = ?, p.valorProduto = ?, p.quantidade = ?, un.descricao = ? WHERE p.nomeProduto = ?";
        try {
            PreparedStatement stmt = this.conection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());
            stmt.setString(3, produto.getQuantidade());
            stmt.setString(4, produto.getUnidadeMedida());
            stmt.setString(5, nomeProduto);
            stmt.execute();
            System.out.println("\nDados alterados com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
        }
        return produto;
    }
}
