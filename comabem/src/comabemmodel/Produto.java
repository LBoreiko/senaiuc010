package comabemmodel;
// Classe Produto
public class Produto {

    private String nomeProduto;
    private String valorProduto;
    private String quantidade;
    private String unidadeMedida;
    private int idUnidadeMedia;

        // Retorna escolha do usuário no menu principal
    public String getItem(String numero){
        if (numero.contentEquals("1")) {
            return this.getNome();
        }
        if (numero.contentEquals("2")) {
            return this.getPreco();
        }
        if (numero.contentEquals("3")) {
            return this.getQuantidade();
        }
        if (numero.contentEquals("4")) {
            return this.getUnidadeMedida();
        } else{
            return "Opção inválida!!!";
        }
    }

    //Função para inserir uma nova informação
    public void setItem(String numero, String novainformacao){
        if (numero.contentEquals("1")) {
            this.setNome(novainformacao);
        }
        if (numero.contentEquals("2")) {
            this.setPreco(novainformacao);
        }
        if (numero.contentEquals("3")) {
            this.setQuantidade(novainformacao);
        }
        if (numero.contentEquals("4")) {
            this.setUnidadeMedida(novainformacao);
        }
    }

    //Representa a classe em String
    public String toString() {
        return "Nome: " +  this.getNome() + " Valor: " + this.getPreco() + " Quantidade: " + this.getQuantidade() + "   " + this.getUnidadeMedida();
    }

    // Getters e Setters
    /**
     * @return String return the nome
     */
    public String getNome() {
        return nomeProduto;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nomeProduto = nome;
    }

    /**
     * @return String return the preco
     */
    public String getPreco() {
        return valorProduto;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.valorProduto = preco;
    }

    /**
     * @return String return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return String return the unidadeMedida
     */
    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    /**
     * @return int return the idUnidadeMedia
     */
    public int getIdUnidadeMedia() {
        return idUnidadeMedia;
    }

    /**
     * @param idUnidadeMedia the idUnidadeMedia to set
     */
    public void setIdUnidadeMedia(int idUnidadeMedia) { this.idUnidadeMedia = idUnidadeMedia;
    }

}