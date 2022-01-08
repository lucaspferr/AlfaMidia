/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacea_crud;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lucas Pimentel Ferreira
 */
public class Operations extends Data {
    
    //Declaracao das variaveis
    private List<String> lista2;
    private String _nome;
    private int _nota;
    private boolean saida=false;
    private boolean lista_div=false;
    private String separ2;
    //private String simnao="";
    private int _cod;
    private boolean rst_bsc=false;
    private List<String> lst_bsc;
    private List<Integer> lst_bsc_indx;
    private List<Integer> lst_bsc_indx2;
    private List<String> lista_alu;
    private List<String> lista_pes;
    private String modific="";
    private int indice_orig;
    public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public LocalDateTime cadhr;   
    public LocalDateTime atuhr;
    
    
    public Operations(){
        lista2 = new ArrayList<>();
        this._nome=_nome;
        //lst_bsc = new ArrayList<>();
        //lst_bsc_indx = new ArrayList();
    }
    
    public void menu() throws Exception{
        //Metodo que faz a listagem de dados e chama a classe Terminal para acrescentar a interface
        limpatela();
        Terminal t1 = new Terminal();
        t1.h_screen();
        t1.options_screen();
        if(lista2.isEmpty()){
            //Verifica se a lista esta vazia, caso true, printa o sout abaixo
            System.out.println("Nenhum dado ainda cadastrado");
            //cadastrar();
        }
        else{
            if(rst_bsc==false){
                //Casi i rst_bsc seja falso, o conteudo da lista original e passado pra lista2 
                lista2=getLista();
            }
            else{
                //Caso o rst_bsc seja verdadeiro, o conteudo da lista de busca (lst_bsc) eh passsado a lista2
                if(rst_bsc==true){
                    lista2=lst_bsc;
                }
                indice_orig = 0;
            }
            if(lista_div==false){
                for(int contlst=0;contlst<lista2.size();contlst++){
                    //Manda para a classe Data, onde fara a separacao das categorias em cada posicao da lista
                    separ2 = lista2.get(contlst);
                    setSepar(separ2);
                    if(rst_bsc==false)System.out.println("Cod.: "+contlst);
                    if(rst_bsc==true){
                        System.out.println("Cod.: "+lst_bsc_indx.get(indice_orig));
                        indice_orig = indice_orig + 1;
                    }
                    separacao();
                    if(contlst!=(lista2.size())-1){
                        //Acrescenta os pontilhados entre itens e garante q n seja acrescentado no ultimo indice
                        System.out.println("");
                        System.out.println("         - - - - - - - - - -");
                    }
                }
            }
            if(lista_div==true) listar_div();
            
        } 
        t1.b_screen();
        //Chama o metodo switch
        rst_bsc=false;
        lista_div=false;
        if(!lista2.isEmpty())lista2=getLista();
        if(lista2.isEmpty()) cadastrar();

        
        direcionamento();
    }
    
    public void direcionamento() throws Exception{
        //Metodo de direcionamento das opcoes do menu
        while(saida==false){
            boolean retorno = true;
            System.out.println("Digite a ação que deseje fazer: ");
            Scanner info2 = new Scanner(System.in);
            String conti = (info2).next();
            switch(conti){
                case "C": case "c":
                    cadastrar();
                    retorno=false;
                    break;
                case "M": case"m":
                    retorno=false;
                    break;
                case "S": case "s":
                    //Quebra o while, causando a terminacao do programa
                    saida=true;
                    break;
                case"A":case"a":
                    atualizar();
                    retorno=false;
                    break;
                case"E":case"e":
                    excluir();
                    retorno=false;
                    break;
                case"B":case"b":
                    buscar();
                    retorno=false;
                    break;
                case"D":case"d":
                    dividir_lista();
                    retorno=false;
                    break;
                default:
                    //System.out.println("Teste");
                    retorno=false;
                    //Chama o menu ao final do direcionamento
                    break;
            }
            if(retorno==false){
                menu();
            }
        }
    }
    
    public void cadastrar(){
        //Método de cadastro de alunos/usuários
        verif_cadast();
        entrada();
        if (getStatus().equals("Aluno(a)")) ins_nota();
        cadhr= LocalDateTime.now();
        atuhr= LocalDateTime.now();
        separ2 = getS_lista();
        lista2.add(separ2+(dtf.format(cadhr))+"---"+(dtf.format(atuhr))+"---"+getStatus()+"---"+getNota());
        //System.out.println(lista2);
        setLista(lista2);
        //System.out.println(getLista());
    }
    
    public void atualizar(){
        //Metodo de atualizacao de determinado posicao na lista
        bsc_cod();
        hr_cadastro(_cod);
        //int mud_stat=0;
        separ2=lista2.get(_cod);
        String dados2[]=separ2.split("---");
        verif_atu();
        String hr_cad = getDat_cad();
        atuhr= LocalDateTime.now();
        //Pega o codigo ja verificado pelo metodo anterior e sobrescreve os dados com o input fornecido
        entrada();
        if(getMud_status()==1 && dados2[5].equals("Aluno(a)")){
            setStatus("Pessoa");
            setNota(20);
        }
        if( getMud_status()==1 && dados2[5].equals("Pessoa")){
            setStatus("Aluno(a)");
            ins_nota();
        }
        if( getMud_status()==0 && dados2[5].equals("Pessoa")){
            setStatus(dados2[5]);
            setNota(20);
        }
        if( getMud_status()==0 && dados2[5].equals("Aluno")){
            setStatus(dados2[5]);
            _nota = Integer.parseInt(dados2[6]);
            setNota(_nota);
        }
        separ2= getS_lista();
        modific=(separ2+hr_cad+"---"+(dtf.format(atuhr))+"---"+getStatus()+"---"+getNota());
        lista2.set(_cod, modific);
        setLista(lista2);
    }
    
    public void excluir(){
        //Metodo de exclusao de alguma posicao da lista
        bsc_cod();
        //Pega o codigo ja verificado pelo metodo anterior e remove ele da lista2, acrescetando depois a lista original(lista)
        lista2.remove(_cod);
        setLista(lista2);
    }
    
    public void bsc_cod(){
        //Metodo que capta dado inserido pelo usuario, verifica se eh um valor numerico,verifica se eh um indice da lista
        //e acrescenta o valor da lista copy (lista2) para uma lista secundaria (lst_bsc)
        System.out.println("Digite o código do aluno(a)/pessoa: ");
        Scanner info4 = new Scanner(System.in);
        String bsc = (info4).next();
        try{
            Integer.parseInt(bsc);
            _cod = Integer.parseInt(bsc);
            if(_cod<0){
                System.out.println("Digite apenas valores positivos.");
                bsc_cod();
            }
            if(_cod<lista2.size()){
                setStr_bsc(lista2.get(_cod));
                lst_bsc.add(getStr_bsc());
                setSepar(getStr_bsc());
                System.out.println(lst_bsc);
                separacao();
                
            }
            else{
                System.out.println("Código inexistente.");
                bsc_cod();
            }
            
        }
        catch(NumberFormatException e){
            System.out.println("Digite um número válido.");
            bsc_cod();
        }
        
    }
    
    public void buscar(){
        //Metodo de busca
        lst_bsc.clear();
        lst_bsc_indx.clear();
        Scanner info5 = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String busca = info5.next();
        for(int contlst=0;contlst<lista2.size();contlst++){
            separ2=lista2.get(contlst);
            if(separ2.matches("(?i).*" + busca + ".*")){
                lst_bsc.add(separ2);
                lst_bsc_indx.add(contlst);
            }  
        }
        rst_bsc=true;
    }    
    
    public void dividir_lista(){
        //Metodo de divisao da divisao da lista entre aluno/pessoa
        dividir();
        if(getSimnao().equalsIgnoreCase("n")){
            System.out.println("Retornando ao menu.");
            try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        }
        if(getSimnao().equalsIgnoreCase("s")){
            lista_alu = new ArrayList<>();
            lista_pes = new ArrayList<>();
            lst_bsc_indx2 = new ArrayList<>();
            lista_div=true;
            lista2=getLista();
            lst_bsc_indx.clear();
            for(int contlst=0;contlst<lista2.size();contlst++){
                separ2=lista2.get(contlst);
                String dados[]=separ2.split("---");
                if(dados[5].equals("Aluno(a)")){
                    lista_alu.add(separ2);
                    lst_bsc_indx.add(contlst);
                }
                if(dados[5].equals("Pessoa")){
                    lista_pes.add(separ2);
                    lst_bsc_indx2.add(contlst);
                }
            }
        }
    }
    
    public void listar_div(){
        System.out.println("                - A L U N O S -");
        for(int contlst=0;contlst<lista_alu.size();contlst++){
            //Manda para a classe Data, onde fara a separacao das categorias em cada posicao da lista
            separ2 = lista_alu.get(contlst);
            setSepar(separ2);
            System.out.println("Cod.: "+lst_bsc_indx.get(indice_orig));
            indice_orig = indice_orig + 1;
            separacao();
            if(contlst!=(lista_alu.size())-1){
                //Acrescenta os pontilhados entre itens e garante q n seja acrescentado no ultimo indice
                System.out.println("");
                System.out.println("         - - - - - - - - - -");
            }
        }
        indice_orig=0;
        System.out.println("                - P E S S O A S -");
        for(int contlst=0;contlst<lista_pes.size();contlst++){
            //Manda para a classe Data, onde fara a separacao das categorias em cada posicao da lista
            separ2 = lista_pes.get(contlst);
            setSepar(separ2);
            System.out.println("Cod.: "+lst_bsc_indx2.get(indice_orig));
            indice_orig = indice_orig + 1;
            separacao();
            if(contlst!=(lista_pes.size())-1){
                //Acrescenta os pontilhados entre itens e garante q n seja acrescentado no ultimo indice
                System.out.println("");
                System.out.println("         - - - - - - - - - -");
            }
        }
    }
}
