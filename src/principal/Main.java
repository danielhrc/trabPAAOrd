package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import ordenacao.OrdecaoInterna;
 
public class Main {
 
public static void main(String[] args) throws IOException {
    String filename = "arquivo.txt";
    
    int numeroDoLogger=0;
    String logFileName = "log"+numeroDoLogger+".txt";
    FileWriter arquivoLog;
    PrintWriter printer = null;
    ArrayList<FileWriter> listaLog = new ArrayList<FileWriter> ();
    boolean logController=true;
 
    try {
      FileReader arq = new FileReader(filename);
      BufferedReader lerArq = new BufferedReader(arq); 
      //String linha = String.valueOf(arq.read());
      String linha = lerArq.readLine();
      String[] vetlinha = linha.split(",");
      int x = 0;
      int[] vetint = new int[vetlinha.length]; 
      // Creates the integer array.
      for (int i = 0; i < vetint.length; i++){
    	  vetint[i] = Integer.parseInt(vetlinha[i]); 
    	  //Parses the integer for each string.
      }
      while (x < vetint.length) {
	        System.out.println(vetint[x]); 
	        x += 1;
	      }
      x = 0;
      int j = 1;
      int k = 0;
      int vetx[] = new int [10];
      Object vetvetint[] = new Object [vetint.length] ;
      for(int i = 0; i < vetint.length; i++) {
    	  vetx[j - 1] = vetint[i];
    	  if(j == 10) {   		  
    		  OrdecaoInterna.QuickSort(vetx, 0, vetx.length - 1);
    		  vetvetint[k] = vetx;
    		  while (x < vetx.length) {
    			  if(logController) {
    				  arquivoLog = new FileWriter(logFileName);
    				  
    				  listaLog.add(arquivoLog);
    				  printer = new PrintWriter(listaLog.get(numeroDoLogger));
    				  logController=false;
    				  printer.printf("Inicio Log \n");
        			  
        		  }
    			   System.out.println(vetx[x]); 
    			  
    			   printer.printf( "%d \n", vetx[x]);
    		      
    		        x += 1;
    		      }
    		   		  
    		  
    		  x = 0;
    		  
    		  k++;
    		  j = 1;
    		  //for(int f = 0;f < vetx.length; f++) {
    		//	  vetx[f] = 0;
    		  //}
    	  }
    	  j++;
    	  printer.printf("\n Fim do Log \n");
    	  printer.close();
    	  listaLog.get(numeroDoLogger).close();
    	  numeroDoLogger++;
    	  logController=true;
      }      
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
    }
 
    System.out.println("Exit");
  }
}