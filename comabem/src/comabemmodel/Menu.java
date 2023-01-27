package comabemmodel;

import repository.DeleteProduto;
import repository.InserirProduto;
import repository.SelectProduto;
import repository.UpdateProduto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Instanciação de Classes
public class Menu {
    Produto produto = new Produto();
    ArrayList<Produto> produtos = new ArrayList<>();
    SelectProduto selectProduto = new SelectProduto();
    InserirProduto insertProduto = new InserirProduto();
    DeleteProduto deleteProduto = new DeleteProduto();
    UpdateProduto updateProduto = new UpdateProduto();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Funções do Menu Principal
    public void menuPrincipal() throws IOException, InterruptedException{

        System.out.println("************************** Menu de Opções **************************\n");

        System.out.println("1 - Cadastro de um novo Produto");
        System.out.println("2 - Consulta de um Produto ");
        System.out.println("3 - Alterar as informações de um Produto");
        System.out.println("4 - Excluir um Produto\n");

        System.out.println("Digite aqui ....");



        String escolha = br.readLine();
        menuEscolha(escolha);
    }

    // Decisão escolhida no menu principal
    public void menuEscolha(String escolha) throws IOException, InterruptedException{
        switch (escolha) {
            case "0":
                menuSecundario();
                break;
            case "1":
                menuInsercao();
                break;

            case "2":
                menuConsulta();
                break;

            case "3":
                menuAlteracao();
                break;

            case "4":
                menuExclusao();
                break;

            default:
                fecharTela();
                break;
        }
    }
    // Limpar Tela
    public void limpaTela() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    // Fechar Sistema
    public void fecharTela() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("exit");
    }

    // Menu secundário
    public void menuSecundario() throws IOException, InterruptedException{
        limpaTela();
        System.out.println("************************   Sistema ComaBem   ************************\n");
        menuPrincipal();;
    }

    // Realiza a consulta no banco de dados.
    public void menuConsulta() throws IOException, InterruptedException{
        limpaTela();
        System.out.println("Digite o nome do produto para consulta: \n");
        String nomeProduto = br.readLine();
        System.out.println("Produto(s) encontrados na pesquisa:\n ");
        produtos = selectProduto.getPesquisa(nomeProduto);
        if (produtos.isEmpty()) {
            System.out.printf("O Produto %s não foi entrado na pesquisa\n", nomeProduto);
            System.out.println("\n Deseja realizar uma nova pesquisa ? ");
            System.out.println("\n 2 - Sim / 0 - Não ");
            String decisao = br.readLine();
            menuEscolha(decisao);
        }
        System.out.println("\n Deseja realizar uma nova pesquisa ? ");
        System.out.println("\n 2 - Sim / 0 - Não ");
        String decisao = br.readLine();
        menuEscolha(decisao);
    }

    // Cadastra um novo produto no banco de dados
    public void menuInsercao() throws IOException, InterruptedException{
        InserirProduto insertProduto = new InserirProduto();

        System.out.println("Qual o nome do produto ?");
        String nome = br.readLine();
        produto.setNome(nome);
        System.out.println("Qual é o valor do produto ?");
        String preco = br.readLine();
        produto.setPreco(preco);
        System.out.println("Qual é a quantidade do produto ?");
        String quantidade = br.readLine();
        produto.setQuantidade(quantidade);
        System.out.println("Qual a descrição da unidade de medida do produto ?\n" +
                "1 - Kilos /  2 - Unidade  / 3 - Litros ");
        String unidademedida = br.readLine();
        unidademedida = unidademedida.substring(0,1).toUpperCase() + unidademedida.substring(1).toLowerCase();
        produto.setUnidadeMedida(unidademedida);
        System.out.println(produto);
        System.out.println("Confirma o cadastro do produto ?  1 - Sim  2 - Não  \n" +
                           "\n  Pressione qualquer tecla: PARA SAIR DO SISTEMA:");
        String decisao = br.readLine();
        if (decisao.contentEquals("1")) {
            limpaTela();
            insertProduto.inserirProduto(produto);
        }else if (decisao.contentEquals("2")){
            menuSecundario();
        }else{
            menuEscolha("S");
        }
        System.out.println("\n Vamos cadastrar um novo produto? ");
        System.out.println(" 1 - Sim / 2 - Não \n" +
                "Aperte qualquer tecla: PARA SAIR DO SISTEMA:");
        String escolhaCadastrar = br.readLine();
        if (escolhaCadastrar.contentEquals("1")) {
            limpaTela();
            menuEscolha(escolhaCadastrar);
        }else if (escolhaCadastrar.contentEquals("2")){
            menuSecundario();
        }else{
            menuEscolha("S");
        }
    }
        // Realiza alterações no cadastro do produto
    public void menuAlteracao()throws IOException, InterruptedException{
        System.out.println("Escolha o produto para Alterar:");
        String nomeProduto = br.readLine();
        System.out.println("Produtos encontrados na pesquisa:\n ");
        produtos = selectProduto.getPesquisa(nomeProduto);
        String nomeAntigo = produtos.get(0).getNome();
        if (produtos.size() > 1) {
            System.out.println("Escolha um dos produtos para alterar:");
            String respostaEscolha = br.readLine();
            limpaTela();
            produto = selectProduto.getProduto(respostaEscolha);
            System.out.println("\n Qual informação deseja alterar ? \n");
            System.out.println("1 - Nome do Produto / 2 - Valor / 3 - Quantidade / 4 - Descrição da Unidade de Medida");
            String respostaInformacao = br.readLine();
            System.out.println("A informacao atual é: " + produtos.get(0).getItem(respostaInformacao));
            System.out.println("\n Digite a nova informação: ");
            String novaInformacao = br.readLine();
            produtos.get(0).setItem(respostaInformacao, novaInformacao);
            produto = updateProduto.atualizarProduto(produtos.get(0), nomeAntigo);
            System.out.println(produto);
            System.out.println(" Gostaria de realizar alteração em outro produto ?  1 -Sim  2 - Não \n" +
                    " Pressione qualquer tecla: PARA SAIR DO SISTEMA:");
            String decisao = br.readLine();
            if (decisao.contentEquals("1")) {
                limpaTela();
                menuEscolha("3");
            }else if (decisao.contentEquals("2")){
                menuSecundario();
            }else{
                menuEscolha("S");
            }
        }else{
            System.out.println("\n Qual informação deseja alterar ? \n");
            System.out.println(" 1 - Nome do Produto / 2 - Valor do Produto / 3 - Quantidade / 4 - Descrição da unidade de medida");
            String respostaInformacao = br.readLine();
            System.out.printf("Informação Nome do Produto: %s \n", produtos.get(0).getNome());
            System.out.println("A informacao atual é: " + produtos.get(0).getItem(respostaInformacao));
            System.out.println("\n Digite a atualização: ");
            String novaInformacao = br.readLine();
            produtos.get(0).setItem(respostaInformacao, novaInformacao);
            produto = updateProduto.atualizarProduto(produtos.get(0), nomeAntigo);
            System.out.println(produto);
            System.out.println(" Deseja realizar alteração em outro produto ?  1 - Sim / 2 - Não \n" +
                    " Pressione qualquer tecla: PARA SAIR DO SISTEMA:");
            String decisao = br.readLine();
            if (decisao.contentEquals("1")) {
                limpaTela();
                menuEscolha("3");
            }else if (decisao.contentEquals("2")){
                menuSecundario();
            }else{
                menuEscolha("S");
            }
        }
    }
        // Exclui produto do cadastro
    public void menuExclusao()throws IOException, InterruptedException{
        System.out.println("Escolha um produto para Excluir:");
        String nomeProduto = br.readLine();
        System.out.println("Produtos encontrados na pesquisa:\n ");
        produtos = selectProduto.getPesquisa(nomeProduto);
        if (produtos.size() > 1) {
            System.out.println("\n Escolha um dos produtos para Excluir:");
            String nomeProdutoExcluir = br.readLine();
            limpaTela();
            produtos = selectProduto.getPesquisa(nomeProdutoExcluir);
            System.out.println("\nConfirma a exclusão do produto " + produtos.get(0).getNome() + "?\n");
            System.out.println("1 - Sim / 2 - Não  \n" +
                    "  Pressione qualquer tecla: PARA SAIR DO SISTEMA:");
            String decisao = br.readLine();
            if (decisao.contentEquals("1")) {
                limpaTela();
                deleteProduto.deleteProduto(nomeProdutoExcluir);
                System.out.println("\n Deseja excluir outro produto ?");
                System.out.println("\n 0 - Menu Principal /  4 - Sim \n " +
                        "Pressione qualquer tecla: PARA SAIR DO SISTEMA:");
                String novaDecisao = br.readLine();
                if (novaDecisao.contentEquals("0") || novaDecisao.contentEquals("4")) {
                    limpaTela();
                    menuEscolha(novaDecisao);
                } else {
                    menuSecundario();
                }
            }else if (decisao.contentEquals("2")){
                menuSecundario();
            }else{
                menuEscolha("S");
            }
        }
        else{
            System.out.println("\n Confirma a exclusão do produto ? " + produtos.get(0).getNome() + "?\n");
            System.out.println("1 - Sim / 2 - Não \n" +
                    "  Pressione qualquer tecla: PARA SAIR DO SISTEMA:");
            String decisao = br.readLine();
            if (decisao.contentEquals("1")) {
                deleteProduto.deleteProduto(produtos.get(0).getNome());
                System.out.println("\n Deseja excluir outro produto ? ");
                System.out.println("\n 0 - Menu Principal /  4 - Sim \n" +
                        " Pressione qualquer tecla: PARA SAIR DO SISTEMA:");
                String novaDecisao = br.readLine();
                if (novaDecisao.contentEquals("0") || novaDecisao.contentEquals("4")) {
                    limpaTela();
                    menuEscolha(novaDecisao);
                } else {
                    menuSecundario();
                }
                String escolhaExcluir = br.readLine();
                menuEscolha(escolhaExcluir);
            }else if (decisao.contentEquals("2")){
                menuSecundario();
            }else{
                menuSecundario();
            }
        }
    }

}
