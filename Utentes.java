
package project;

import java.util.*;

public class Utentes extends CentroMedico{
    
    private String nome;
    private int idade;
    private int numUnico;
    private boolean isUnico;
    private ArrayList<Integer> conjNumeros;
    private ArrayList<String> datasConsultas;
    
    public Utentes(String nome, int idade)
    {
    this.nome =nome;
    this.idade = idade;
    numUnico = 0;
    conjNumeros = new ArrayList<>();
    datasConsultas = new ArrayList<>();
    }
    
    public Utentes()
    {
    nome = "";
    idade = 0;
    numUnico = 0;
    conjNumeros = new ArrayList<>();
    datasConsultas = new ArrayList<>();
    }
    
 //modificadores e seletores 
    public void setNome(String nome)
    {
    this.nome = nome;
    }
    
    public String getNome()
    {
    return nome;
    }
    
    public void setIdade(int idade)
    {
    this.idade =idade;
    }
    
    public int getIdade()
    {
    return idade;
    }
    
    public int getNum()
    {
    return numUnico;
    }
    
    public ArrayList getconj()
    {
    return conjNumeros;
    }
    
    public void adicionaNum(int num)
    {
    conjNumeros.add(num);
    }
    
    //metodo que gera um numero unico e verifica se este ja esta a ser usado por outro utente
    public int geraNumeroUnico()
    {
    Random numero = new Random();
    numUnico = numero.nextInt(99999);
    numUnico = numUnico + 1000;
    
    if(conjNumeros.contains(numUnico) == true)
        isUnico = false;
    else 
        isUnico = true;
        
    while(isUnico == false)
    {  
        numUnico = numero.nextInt(99999);
        numUnico = numUnico + 1000;
    
        if(conjNumeros.contains(numUnico) == true)
            isUnico = false;
        else
            isUnico = true;
    }  
    conjNumeros.add(numUnico);
    
    return numUnico;
    }
    
    //metodo que permite registar um novo utente 
    public void novoUtente()
    {
    Scanner input=new Scanner(System.in);
    System.out.print("nome:-");
    setNome(input.nextLine());
    try
    {
    System.out.print("idade:-");
    setIdade(input.nextInt());
    }
    catch(InputMismatchException ae)
    {
    System.out.println("o valor inserido nao foi um inteiro!");
    System.out.println("volte a efetuar o registo");
    }
    numUnico = geraNumeroUnico();
    }
    
    //metodo que mostra as informaçoes de um determinado utente

    public String toString()
    {
    String infoUtente;
    infoUtente = " " + nome + " ; ";
    infoUtente += " " + idade + " ; ";
    infoUtente += " " + numUnico + "\n";
    
    return infoUtente;
    }
    public void adicionaConsulta(String data)
    {
        datasConsultas.add(data);
    }
    
    public ArrayList verConsultas()
    {
        return datasConsultas;
    }
    
}
