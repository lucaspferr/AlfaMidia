/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stacea_crud;

/**
 *
 * @author Lucas Pimentel Ferreira
 */
public class STACEA_CRUD {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws Exception{
        //Criar objetos que serão chamados posteriormente
        Terminal terminal = new Terminal();
        // Terminal: Classe com souts para a implementação da interface
        Operations operations = new Operations();
        //Operations: Classe com os metodos de criacao, atualizacao, exclusao, listagem e direcionamento
        
        terminal.initialscreen();
        operations.menu();
        
    }
    
}
