/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Roman
 */
public class Archivar extends Decorador{//clase que toma el papel del "DecoradorConcretoD"
    
    public Archivar(Texto text) {
        super(text);
    }
    @Override
    public void leer(String[] s){
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
    
         archivo = new File ("C:\\Users\\lithium\\prueba");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         while((s[0]=br.readLine())!=null)
             super.escribir(s);
        
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
    @Override
    public void escribir(String[] s){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\lithium\\prueba");
            pw = new PrintWriter(fichero);
            pw.write(s[0]);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {

           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }

    }
      
}
