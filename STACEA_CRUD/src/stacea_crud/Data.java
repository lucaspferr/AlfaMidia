/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacea_crud;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas Pimentel Ferreira
 */
public class Data {
    private String nome;
    private String telefone;
    private String dat_nasc;
    private String dat_cad;
    private String dat_atu;
    private int mud_status;
    private int nota;
    private String status;
    private String simnao="";
    private String indx;
    private List<String> lista;
    private String separ="";
    private String str_bsc="";
    private String s_lista="";

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the dat_nasc
     */
    public String getDat_nasc() {
        return dat_nasc;
    }

    /**
     * @param dat_nasc the dat_nasc to set
     */
    public void setDat_nasc(String dat_nasc) {
        this.dat_nasc = dat_nasc;
    }

    /**
     * @return the dat_cad
     */
    public String getDat_cad() {
        return dat_cad;
    }

    /**
     * @param dat_cad the dat_cad to set
     */
    public void setDat_cad(String dat_cad) {
        this.dat_cad = dat_cad;
    }

    /**
     * @return the dat_atu
     */
    public String getDat_atu() {
        return dat_atu;
    }

    /**
     * @param dat_atu the dat_atu to set
     */
    public void setDat_atu(String dat_atu) {
        this.dat_atu = dat_atu;
    }

    /**
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * @return the lista
     */
    public List<String> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<String> lista) {
        this.lista = lista;
    }
    
    /**
     * @return the separ
     */
    public String getSepar() {
        return separ;
    }

    /**
     * @param separ the separ to set
     */
    public void setSepar(String separ) {
        this.separ = separ;
    }
    
    /**
     * @return the str_bsc
     */
    public String getStr_bsc() {
        return str_bsc;
    }

    /**
     * @param str_bsc the str_bsc to set
     */
    public void setStr_bsc(String str_bsc) {
        this.str_bsc = str_bsc;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the indx
     */
    public String getIndx() {
        return indx;
    }

    /**
     * @param indx the indx to set
     */
    public void setIndx(String indx) {
        this.indx = indx;
    }
    
    /**
     * @return the s_lista
     */
    public String getS_lista() {
        return s_lista;
    }

    /**
     * @param s_lista the s_lista to set
     */
    public void setS_lista(String s_lista) {
        this.s_lista = s_lista;
    }
    
    public void entrada(){
        verif_nome();
        verif_tel();
        verif_nasc();
        setS_lista(getNome()+"---"+getTelefone()+"---"+getDat_nasc()+"---");
    }
    
        /**
     * @return the mud_status
     */
    public int getMud_status() {
        return mud_status;
    }

    /**
     * @param mud_status the mud_status to set
     */
    public void setMud_status(int mud_status) {
        this.mud_status = mud_status;
    }

    /**
     * @return the simnao
     */
    public String getSimnao() {
        return simnao;
    }

    /**
     * @param simnao the simnao to set
     */
    public void setSimnao(String simnao) {
        this.simnao = simnao;
    }
    
    public void separacao(){
        //Faz a separacao de dados entre as categorias
        String dados[]=separ.split("---");
        Arrays.toString(dados);
        System.out.println("Nome: "+dados[0]);
        System.out.println("Status: " +dados[5]);
        String telarray = dados[1];
        //Pega o telefone e acrescenta o ( ) no prefixo.
        telarray = "(" + telarray.substring(0, 2) + ")" + telarray.substring(2,telarray.length());
        System.out.println("Número de telefone: "+telarray);
        System.out.println("Data de nascimento: " +dados[2]);
        System.out.println("Ultima alteração: " +dados[4]);
        System.out.println("Data de cadastro: " +dados[3]);
        int sep_nota = Integer.parseInt(dados[6]);
        if(sep_nota==20){}
        else{
            System.out.println("Nota: " +dados[6]);
        }
    }
    
    public void limpatela() throws IOException, InterruptedException{
        //Metodo que limpa a tela no terminal, nao funciona dentro de IDEs (usar arquivo exe)
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    public void hr_cadastro(int indice){
        //Salva o horario de cadastro da pessoa
        String manip = lista.get(indice);
        String dados[]=manip.split("---");
        Arrays.toString(dados);
        String hr_cad = dados[3];
        setDat_cad(hr_cad);
    }

    public void ins_nota(){
        //Metodo que verifica se o valor da nota eh valido.
        Scanner s_nota = new Scanner(System.in);
        System.out.println("Digite uma nota de 0 a 10:");
        String st_nota = s_nota.nextLine();
        try{
            Integer.parseInt(st_nota);
            nota = Integer.parseInt(st_nota);
            if(nota<0 || nota>10){
                System.out.println("Digite apenas valores válidos.");
                ins_nota();
            }
            if(nota>=0 && nota<=10){
                setNota(nota);
                
            }            
        }
        catch(NumberFormatException e){
            System.out.println("Digite apenas valores válidos.");
            ins_nota();
        }
        
    }
    
    public void verif_tel(){
        //Metodo que verifica se o valor inserido para o telefone eh valido
        Scanner ver_t = new Scanner(System.in);
        System.out.println("Digite o telefone (apenas números):");
        telefone = ver_t.nextLine();
        if(Pattern.matches("[0-9]+", telefone) && telefone.length() > 9 && telefone.length() < 12){
            setTelefone(telefone);
        }
        else{
            System.out.println("Digite um número válido.");
            verif_tel();
        }
    }
    
    public void verif_nasc(){
        //If string.charAt(10) != "/"
        Scanner ver_n = new Scanner(System.in);
        System.out.println("Digite a data de nascimento:");
        dat_nasc= ver_n.nextLine();
        if(dat_nasc.charAt(2)=='/' && dat_nasc.charAt(5)=='/' && dat_nasc.length() == 10){
            setDat_nasc(dat_nasc);
        }
        else{
            System.out.println("Insira algum valor no padrão xx/xx/xxxx");
            verif_nasc();
        }
    }
    
    public void verif_nome(){
        //Metodo que verifica se foi digitado algum numero junto do nome
        Scanner info = new Scanner(System.in);
        System.out.println("Digite o nome:");
        nome = info.nextLine();
        if(nome.length()<3 || nome.matches(".*\\d.*")){
            System.out.println("Digite um nome válido.");
            verif_nome();
        }
        else setNome(nome);
    }
    
    public void verif_cadast(){
        //Faz o set do status
        Scanner info = new Scanner(System.in);
        System.out.println("Digite P para cadastrar como pessoa e A para aluno:");
        String _status = info.nextLine();
        if(_status.equalsIgnoreCase("p")){
            setStatus("Pessoa");
            setNota(20);
        }
        if(_status.equalsIgnoreCase("a")) setStatus("Aluno(a)");
        if(!_status.equalsIgnoreCase("p") && !_status.equalsIgnoreCase("a")){
            System.out.println("Informe uma opção válida.");
            verif_cadast();
        }
    }
    
    public void verif_atu(){
        Scanner _verif = new Scanner(System.in);
        System.out.println("Você deseja alterar o status (aluno/pessoa) atual? (S ou N)");
        setSimnao(_verif.nextLine());
        if(getSimnao().equalsIgnoreCase("s")){
            setMud_status(1);
        }
        if(getSimnao().equalsIgnoreCase("n")){}
        if((!simnao.equalsIgnoreCase("s")) && (!simnao.equalsIgnoreCase("n"))){
            System.out.println("Opção inexistente.");
            verif_atu();
        }
    }
    
    public void dividir(){
        Scanner _divid = new Scanner(System.in);
        System.out.println("Você deseja dividir a lista entre alunos/pessoas? (S ou N)");
        setSimnao(_divid.nextLine());
        if((!simnao.equalsIgnoreCase("s")) && (!simnao.equalsIgnoreCase("n"))){
            System.out.println("Opção inexistente.");
            dividir();
        }
    }
}
