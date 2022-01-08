/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacea_crud;

/**
 *
 * @author Lucas Pimentel Ferreira
 */
public class Terminal {
    
    //Nessa classe tem apenas souts com a interface
    
    public void initialscreen() throws Exception{
        Data limpa = new Data();
        h_screen();
        System.out.println("   Sistema em Terminal de Atualização, Cadastro e Exclusão de Alunos    ");
        System.out.println("");
        System.out.println("                Sistema iniciando, por favor aguarde...");
        b_screen();
        try { Thread.sleep (1500); } catch (InterruptedException ex) {}
        limpa.limpatela();
    }
    
    public void h_screen(){
        System.out.println("________________________________________________________________________");
        System.out.println("          ____________________________________________________          ");
        System.out.println("          |                                                   |         ");
        System.out.println("          |                    S T A C E A                    |         ");
        System.out.println("          |___________________________________________________|         ");
        System.out.println("       ");
    }
    public void b_screen(){
        System.out.println("");
        System.out.println("                      Lucas Pimentel Ferreira, 2021");
        System.out.println("________________________________________________________________________");
    }
    public void options_screen(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("->Digite C para cadastrar novos(as) alunos(as).");
        System.out.println("->Digite A para atualizar os dados.");
        System.out.println("->Digite D para dividir a lista entre alunos/pessoas.");
        System.out.println("->Digite E para excluir algum(a) aluno(a).");
        System.out.println("->Digite M para retornar ao menu.");
        System.out.println("->Digite B para buscar algum dado.");
        System.out.println("->Digite S para sair do sistema.");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("");
    }
}
