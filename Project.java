
package project;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;

public class Project {
    
    private static int conta1 =1, conta2 = 1, contaLinhas = 0;
    private static int escolha, j,c1,c2,c3, opcao=1,s1=1,s2=1,s3=1;
    private static String escolhemed, datas;
    
    public static void main(String[] args) throws IOException, ParseException {
        String months[] = { "Jan", "FeV", "Mar", "Abr", "Maio", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        String ficheiro = "Medicos.txt";
        String ficheiro1 = "Utentes.txt";
        String ficheiro2 = "Consultas.txt";
        
        //Instanciaçao de classes
        Medicos med ;
        Utentes ut ;
        CentroMedico Ce = new CentroMedico();
        Consultas cn = new Consultas();
        Scanner input = new Scanner(System.in); 
        Calendar calendar = Calendar.getInstance();
        
        //ciclo de leitura do ficheiro dos utentes
        FileReader inStream = new FileReader(ficheiro1);
        BufferedReader bR =  new BufferedReader(inStream);
        String linha = bR.readLine();
        //Ce.adicionaUtente(linha);
        while(linha != null)
        {
        linha = bR.readLine();
        }
        bR.close();
        
        // Display Inicial
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                          ***CLINICA MEDICA***");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Data: "+ calendar.get(Calendar.DATE)+ " " + months[calendar.get(Calendar.MONTH)]+ " "+ calendar.get(Calendar.YEAR));
    
 while (opcao == 1) {
            System.out.println("\n                                    MAIN MENU");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("1.MEDICO  2. UTENTE 3.DIA SEGUINTE  4.SAIR");
            System.out.println("--------------------------------------------------------------------------------");
            escolha = input.nextInt();
            
switch(escolha)
{
    case 1:
   {
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("                      **MEDICOS**");
    System.out.println("--------------------------------------------------------------------------------");
    s1=1;
    while(s1==1)
   {
        System.out.println(" 1.Novo Registo \n 2.Lista de Medicos ");
        c1=input.nextInt();
        switch(c1)
        {
            case 1:
            {
                //escrita das caracteristicas do medico no ficheiro de texto
                BufferedWriter bufWr = new BufferedWriter(new FileWriter(ficheiro, true));
                PrintWriter pW = new PrintWriter(bufWr);
                
                med = new Medicos(); 
                med.novoMedico();
                pW.println(med);
                Ce.adicionaMedicos(med); 
                pW.close();
                //System.out.println("");
                
            break;
            }
            
            case 2:
            {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("NUMERO IDENTIFICAÇAO \t ESPECIALIDADE \t AVALIACAO");
            System.out.println("--------------------------------------------------------------------------------");
            
            System.out.println(Ce.getMedicos());
            break;
            }
        }  
     
     System.out.println("RETURN BACK press (1/0) for more");
     s1=input.nextInt();
    }
    break;
 }
case 2:
{
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     **UTENTE**");
        System.out.println("--------------------------------------------------------------------------------");
        s2=1;
        
    while(s2==1)
    {
        System.out.println(" 1.Novo Registo \n 2.Lista de Pacientes \n 3. Inserir Utentes a partir de um ficheiro \n 4. Sair da Aplicacao \n");
        c1=input.nextInt();
    switch(c1)
    {
    case 1:
    { 
        BufferedWriter bW = new BufferedWriter(new FileWriter(ficheiro1, true));
        PrintWriter out = new PrintWriter(bW);
        
        ut = new Utentes();
        ut.novoUtente();
        out.println(ut);
        Ce.adicionaUtente(ut);
        out.close();
        System.out.println(" 1. Efetuar Consulta \n 2.Sair da Aplicacao");
        c2 = input.nextInt();
        
        switch(c2)
        {
            case 1: 
            {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("                    ** CONSULTAS DIAGNOSTICO ** ");
            System.out.println("--------------------------------------------------------------------------------");
            s3 =1;
            while(s3 == 1)
            {
                System.out.println(" 1. Escolher Medico ");
                c2= input.nextInt();
            
                switch(c2)
                {
                    case 1:
                    {
                        Scanner cons = new Scanner(System.in);
                        System.out.println(Ce.getMedicos());
                        Ce.escolheMedico();
                        //med.getNumeros().contains(Ce.getNumeroMed());
                        
                        System.out.println("Irá ter consulta com o Dr. de numero " + Ce.getNumeroMed() + " numa data a marcar : \n");
                        System.out.println("Deverá inserir a data no seguinte formato : dia-mes-ano");
                        String date = cons.nextLine();
                        String[] line = date.split("-");
                        int dia = Integer.valueOf(line[0]);
                            if(dia > 32 || dia < 1)
                            {System.out.println("O valor inserido nao foi valido");
                            break;
                            }
                        int mes = Integer.valueOf(line[1]);
                            if(mes > 13 || mes < 1)
                            {System.out.println("O valor inserido nao foi valido");
                            break;
                            }
                        int ano = Integer.valueOf(line[2]);
                            if(ano < calendar.get(Calendar.YEAR)|| ano > calendar.get(Calendar.YEAR) +1)
                            {
                                System.out.println("O valor inserido nao foi valido");
                                break;
                            }
                        System.out.printf("Tem a seguinte consulta no dia: \n %s-%s-%s \n \n", dia, mes, ano);
                        date += " , " + ut.getNum();
                        date += " , " + Ce.getNumeroMed();
                        
                        cn.guardaCT(date);
                        System.out.println(cn.getListaSt());
                        s3 = 0;
                        
                        break;
                        }
                    default:
                        System.out.println("Opcao errada!");
                        break;
                    }
            }
            break;
        }
             case 2:
                    {
                    System.out.println("Escolheu sair da aplicacao!");
                    break;
                    }
    }
        break;
    }
    case 2:
    {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("IDENTIFICACAO \t NOME \t IDADE \t NUMERO UTENTE");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(Ce.getUtentes());
        break;
    }
    
    case 3:
        {
            break;
        }
    case 4:
        {   
            break;
        }
    default :
        System.out.println("Opcao errada!");
        break;
    }
    s2=0;
    }
    break;
    }
        case 3: {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    System.out.print("Data: " + calendar.get(Calendar.DATE) + " " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR));
                }
        case 4:
            {
                break;
            }
            
            default:
                {
                System.out.println("Opçao errada!");
                }
                
            System.out.println("RETURN MAIN MENU press (1/0) for more");
            opcao=input.nextInt();
            }
        }
    }
}
