package project;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;


public class Consultas
{
    private int numConsultasUt;
    private int numConsultasMed;
    private int dia;
    private int mes;
    private int ano;
    private ArrayList<String> ConsultasTotais;
    private String lista, data;
    private boolean exame;
    
    Utentes ut = new Utentes();
    Medicos med = new Medicos();
    
    public String toString()
    {
        String str;
        str = " " + ut.getNum()+ " ; ";
        str+= " " + " ; ";
        str+= " " + getCT() + "\n";
        return str;
    }
    
    public Consultas(int dia,int mes, int ano)
    {
         this.dia = dia;
         this.mes = mes;
         this.ano = ano;
         ConsultasTotais = new ArrayList<>();
         lista = "";
    }
    
    public Consultas()
    {
    dia = 0;
    mes = 0;
    ano = 0;
    ConsultasTotais = new ArrayList<>();
    }
    
    public void setDia(int dia)
    {
        this.dia= dia;
    }
    
    public void setMes(int mes)
    {
        this.mes = mes;
    }
    
    public void setAno(int ano)
    {
        this.ano = ano;
    }
        public int getDia()
    {
        return dia;
    }
    public int getMes()
    {
        return mes;
    }
    public int getAno()
    {
        return ano;
    }
    
    public void guardaCT(String datas)
    {
        ConsultasTotais.add(datas);
    }
    
    public ArrayList getCT()
    {
        return ConsultasTotais;
    }
    
    public String getListaSt()
    {
    lista = String.join(" , ", ConsultasTotais);
    return lista;
    }
    
    public String getConsulta()
    {
    String[] line = lista.split(" , ");
    return lista;
    }
    
    public void dataUser() {
        
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date2 = null;
        
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Sua consulta foi marcada para " + date2);
    }
    
    public void solicitarExame()
    {
        Random rand = new Random();
        exame = rand.nextBoolean();
        if(exame == true)
        {
            System.out.println("O resultado do exame estará pronto daqui a uma semana");
        }
        else
            System.out.println("A consulta esta terminada");   
    }
}
