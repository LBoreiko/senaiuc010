//Importação dos pacotes

import comabemmodel.Menu;

import java.io.IOException;

//Classe Principal
public class Main {

    //Função Principal do Programa
    public static void main(String[] args) throws IOException, InterruptedException {
        // Carrega o Menu
        System.out.println("-----------********   Sistema ComaBem    *******------------------\n");
        Menu menu = new Menu();
        menu.menuPrincipal();
    }
}

