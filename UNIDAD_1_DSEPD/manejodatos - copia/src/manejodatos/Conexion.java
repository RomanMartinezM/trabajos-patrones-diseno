/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodatos;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

/**
 *
 * @author  Roman Martinez Mendoza
 */
public class Conexion {
    private static Connection coneccion; //contenida en el paquete sql
    private static Conexion conexion;
    
    private Conexion(String url, String usuario, String password){
        try {
            //Clase usada para una conexión con PostgreSQL
            Class.forName("org.postgresql.Driver");
            //para MySQL es: "com.mysql.jdbc.Driver"
            try {
                coneccion = (Connection)DriverManager.getConnection(url,usuario,password);
                System.out.println("Conexion establecida");
            } catch (SQLException ex) {
                //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error al tratar de conectarse a la base de datos");
                System.err.println(ex + "");
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex + "");
        }
    }
    
    public static Connection getConexion(String url, String usuario, String password){
        if(conexion == null)
            conexion = new Conexion(url,usuario,password);
        return coneccion;
    }
   /*
    public static void cerrarConexion(){//boolean cerrarConexion(){
          try {
            coneccion.close();     
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    public static boolean cerrarConexion2(){
        try {
            if(conexion != null)
                coneccion.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return true;
    }*/
  
}
