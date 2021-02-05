/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 
 *
 *  @author Roman Martinez Mendoza
 */
public class ProcesoDatos implements Runnable{
    private AccesoDatos adatos;
    @Override
    public void run() {
        adatos = new AccesoDatos();
        Random rnd = new Random(); 
        Random rndNumReg = new Random();
        int numPRandom,NumRegistros;
        Object ProRandom[] = new Object[4];
        int cantidad,idproducto;
         try {
             String sql = "SELECT * FROM bd_productos.producto";
             List <Object[]> consultarDatos = new ArrayList<Object[]>();
             consultarDatos = adatos.conexionConsultaProductos(sql);
           
           NumRegistros = rndNumReg.nextInt(consultarDatos.size()); 
           //System.out.println("Numero de registros a modificar: " + NumRegistros);
           for(int i=0; i < NumRegistros; i++ ){
                    numPRandom = rnd.nextInt(consultarDatos.size());
             //       System.out.println("Posicion registro a modificar: " + numPRandom);
                    ProRandom[0] = consultarDatos.get(numPRandom)[0]; 
                    ProRandom[1] = consultarDatos.get(numPRandom)[1];
                    ProRandom[2] = consultarDatos.get(numPRandom)[2];
                    ProRandom[3] = consultarDatos.get(numPRandom)[3];
                 
                    cantidad = Integer.parseInt(ProRandom[2].toString()); 
                    idproducto = Integer.parseInt(ProRandom[0].toString());
                    

                    System.out.println("ANTES DE MODIFICAR");
                    System.out.println("\n\tIDPROD" + "\t\tDESCRIPCION" + "\t\tCANTIDAD " + "\tPRECIO");
                    System.out.format("%10s %23s %17s %16s %n",ProRandom[0], ProRandom[1],ProRandom[2],ProRandom[3]); //producto antes de modificar
 
                    cantidad = cantidad+1;
                    String sqlActualizar = "UPDATE bd_productos.producto SET cantidad=" + cantidad + " WHERE idprod=" + idproducto;
                    System.out.println(adatos.actualizaProductos(sqlActualizar));
 
                    System.out.println("MODIFICADO");
                    adatos.visualizar(sql);
                    
                   //  consultarDatos = adatos.conexionConsultaProductos(sql);
                    
                   // System.out.println("\n\tIDPROD" + "\t\tDESCRIPCION" + "\t\tCANTIDAD " + "\tPRECIO");
                   // System.out.format("%10s %23s %17s %16s %n",consultarDatos.get(consultarDatos.size()-1)[0], consultarDatos.get(consultarDatos.size()-1)[1],consultarDatos.get(consultarDatos.size()-1)[2],consultarDatos.get(consultarDatos.size()-1)[3]); //producto modificado
            }
            
             Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException ex) {
                System.out.println(ex);
        }
    }
    
}
