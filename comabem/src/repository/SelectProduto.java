package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import comabemdb.Conexao;
import comabemmodel.Produto;

public class SelectProduto {
    private Conexao conexaoDB;
    private Connection conection;

    // Construtor
    public SelectProduto(){
        this.conexaoDB = new Conexao();
        this.conection = this.conexaoDB.getConexao();
    }
    // Realiza Consultas no banco de Dados
    public Produto getProduto(String nomeProduto) {
        try {
            String sql ="SELECT p.nomeProduto, p.valorProduto, p.quantidade, un.descricao FROM produtos AS p INNER JOIN unidademedida AS un WHERE nomeProduto = ? AND un.idUnidadeMedida = p.idUnidadeMedida";
            PreparedStatement stmt = this.conection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, nomeProduto);
            ResultSet resultado = stmt.executeQuery();
            Produto produto = new Produto();
            resultado.first();
            System.out.println("Nome: " +resultado.getString(1)+" Preço: "+resultado.getString(2)+" Quantidade: "+resultado.getString(3)+" "+resultado.getString(4));
            produto.setNome(nomeProduto);
            produto.setPreco(resultado.getString(2));
            produto.setQuantidade(resultado.getString(3));
            produto.setUnidadeMedida(resultado.getString(4));
            return produto;
        } catch (Exception e) {
            System.out.println("Erro ao consultar o produto: " + e.getMessage());
        }
        return null;
    }
    // Realiza Consultas no banco de Dados
    public ArrayList<Produto> getPesquisa(String string){
        String sql = "SELECT p.nomeProduto, p.valorProduto, p.quantidade, un.descricao FROM produtos AS p INNER JOIN unidademedida AS un WHERE p.nomeProduto LIKE '%"+ string +"%' AND p.idUnidadeMedida = un.idUnidadeMedida";
        try {
            Statement stmt = this.conection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            ArrayList<Produto> produtos = new ArrayList<>();
            while(resultado.next()){
                Produto produto = new Produto();
                produto.setNome(resultado.getString(1));
                produto.setPreco(resultado.getString(2));
                produto.setQuantidade(resultado.getString(3));
                produto.setUnidadeMedida(resultado.getString(4));
                produtos.add(produto);
                System.out.println(" Nome do Produto: " + resultado.getString(1)  + " Valor do Produto: " + resultado.getString(2) +" Quantidade: " + resultado.getString(3)+ "   " + resultado.getString(4));
                System.out.println("------------------------------------------------------------");
            }
            return produtos;
        } catch (Exception e) {
            System.out.println("Erro ao consultar o produto: " + e.getMessage());
        }
        return null;
    }
}