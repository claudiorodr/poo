
package project;

import java.util.*;
import java.io.*;

public class CentroMedico{
    
    //variaveis de instancia
    private ArrayList<Utentes> utentes;
    private ArrayList<Medicos> equipaMedica;
    private ArrayList<Consultas> consultas;
    private int numeroMed;
    private String listaUt, listaMed, listaCons;
    //construtor
    public CentroMedico()
    {
    equipaMedica = new ArrayList<>();
    utentes = new ArrayList<>();
    consultas = new ArrayList<>();
    listaUt = " ";
    listaMed = " ";
    listaCons = " ";
    }
    //modificadores e seletores 
    public void adicionaMedicos(Medicos med)
    {
    equipaMedica.add(med);
    }
    
    public ArrayList<Medicos> getMedicos()
    {
    return equipaMedica;
    }
    
    public ArrayList<Utentes> getUtentes()
    {
    return utentes;
    }
    
    public void adicionaUtente(Utentes utente)
    {
    utentes.add(utente);
    }
    
    public int getNumeroMed()
    {
    return numeroMed;
    }
    
    public void adicionaConsulta(Consultas cons)
    {
    consultas.add(cons);
    }
    
    public ArrayList getConsultas()
    {
    return consultas;
    }
    //metodos
    public void escolheMedico()
    {   
    Scanner input=new Scanner(System.in); 
    System.out.print("Numero do Medico: ");
    numeroMed =input.nextInt();
    }
    
    public String getListaUT()
    {
    listaUt = String.valueOf(listaUt);
    return listaUt;
    }
    
    public void procuraNumero()
    {
    String[] linha = listaUt.split(" , ");
    for(int i = 2; i<listaUt.length(); i= i+3)
    {}
    }
}

