
package project;

import java.util.*;

public class Medicos extends CentroMedico{
    
    private String espec;
    private int numID;
    private boolean unico;
    private double avaliacao;
    private ArrayList<Double> classificacoes;
    private ArrayList<Integer> numeros;
    private ArrayList<String> datas;
    
    public Medicos(int numID, String espec)
    {
    this.espec = espec;
    this.numID = numID;
    avaliacao = 0.0;
    numeros = new ArrayList<>();
    datas = new ArrayList<>();
    }
    
    public Medicos()
    {
    espec = "";
    avaliacao = 0.0;
    numID = 0;
    numeros = new ArrayList<>();
    datas = new ArrayList<>();
    }
    
    public void setEspec(String especialidade)
    {
    this.espec = especialidade;
    }
    
    public String getEspec()
    {
    return espec;
    }
    
    public void setNumeros(int num)
    {
    numeros.add(num);
    
    }
    public ArrayList getNumeros()
    {
    return numeros;
    }
    
    public int getNum()
    {
    return numID;
    }
    
    public int setNum()
    {
    Random rand = new Random();
    numID = rand.nextInt(1000);
    numID = numID + 345;
    
     if(numeros.contains(numID) == true)
        unico = false;
    else 
        unico = true;
        
    while(unico == false)
    {  
        numID = rand.nextInt(99999);
        numID = numID + 1000;
    
        if(numeros.contains(unico) == true)
            unico = false;
        else
            unico = true;
    }  
    numeros.add(numID);
    return numID;
    
    }
    
    public void adicionaConsultaMedico(String data)
    {
    datas.add(data);
    }
    
    public ArrayList getConsultasMed()
    {
    return datas;
    }
    /*
    public String toString()
    {
    String infoMed;
    infoMed= " Especialidade : " + espec + " ; ";
    infoMed+= " Numero Identificacao : " + numID + " ; ";
    infoMed+= " Avaliacao : " + avaliacao + "\n";
    return infoMed;
    }*/
    
    public String toString()
    {
    String infoMed;
    infoMed= "  " + espec + " ; ";
    infoMed+= "  " + numID + " ; ";
    infoMed+= " " + avaliacao + "\n";
    
    return infoMed;
    }

    public void novoMedico()
    {
    Scanner input=new Scanner(System.in);     
    System.out.print("Especialidade: ");
    espec=input.nextLine();
    numID = setNum();
    }
    
    public void setClassif(double classif)
    {
    classificacoes.add(classif);
    }
    
    public ArrayList getClassif()
    {
    return classificacoes;
    }
    
    public void setAvaliacao(double avaliacao)
    {
    this.avaliacao = avaliacao;
    }
    
    public double getAvaliacao()
    {
    return avaliacao;
    }
    
    public void getClassLista()
    {

    }
/*
    public double media(classif)  // metodo com lista de paramentros de tamanho variavel
    {
        for(int i = 0; i<=classificacao.toArray().length; i++ )
        {
        classificacao.toArray();
        }
        //classif = classif/classificacao.toArray().length;
        return avaliacao;
    }*/
    
    public void mostrarClass()
    {
    Scanner in = new Scanner(System.in);
    System.out.println("A avaliacao actual do medico é :" + getAvaliacao() + "\n");
    System.out.println("Prentende classificar o medico em(de 0 a 5): ");
    avaliacao= in.nextInt(6);
    System.out.println("O medico agora tem a avaliaçao de: " + avaliacao);
    
    }
    
    
}
