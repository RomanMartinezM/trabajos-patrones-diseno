/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package manejodatos;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman Martinez Mendoza
 */
public class AccesoDatos {
    private Connection conexion;

    public AccesoDatos(){ 
       //Connection conexion = Conexion.getConexion("jdbc:postgresql://localhost:5432/bdproductos","postgres", "16161364");
       System.out.println("Intento de conexión a la BD"); 
       conexion = Conexion.getConexion("jdbc:postgresql://localhost:5432/bdproductos","postgres", "16161364");
    } 
    
    public List<Object[]> conexionConsultaProductos(String sql){
        //regresa los registros de los productos en una lista
        List<Object[]> datos = new ArrayList<Object[]>();
        try {  
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql); 
            while(rs.next()){ 
                String dat[] = new String[4];
                //Estructura del registro productos pasado como cadena
                dat[0] = String.valueOf((Integer)rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = String.valueOf((Integer)rs.getInt(3)); 
                dat[3] = String.valueOf((Double)rs.getDouble(4));
                datos.add(dat);
            }
        } catch (Exception e) { 
            System.out.println("Error en la conexión consultar productos " + e);
        }
       // Conexion.cerrarConexion();
        return datos;
    }
  
    
    public void visualizar(String sql){
         List <Object[]> consultarDatos = new ArrayList<Object[]>();
         consultarDatos = conexionConsultaProductos(sql);
 
         System.out.println("\n\tIDPROD" + "\t\tDESCRIPCION" + "\t\tCANTIDAD " + "\tPRECIO");
        // System.out.println("total: " + consultarDatos.size());
         for(int i=0; i < consultarDatos.size(); i++ ){
                // System.out.println(""+consultarDatos.get(i)[0] + consultarDatos.get(i)[1] + consultarDatos.get(i)[2] + consultarDatos.get(i)[3]); 
                //System.out.format("%3d %20s %3d %3.2f", consultarDatos.get(i)[0], consultarDatos.get(i)[1],consultarDatos.get(i)[2],consultarDatos.get(i)[3]); 
            System.out.format("%10s %23s %17s %16s %n",consultarDatos.get(i)[0], consultarDatos.get(i)[1],consultarDatos.get(i)[2],consultarDatos.get(i)[3]); 
         }
    }
    
    public boolean actualizaProductos(String sql){
        boolean res = false;
        try {
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            res = true;
            System.out.println("Se inserto "); 
            
        } catch (Exception e) {
             System.out.println(" Error al insertar/ACTUALIZAR " + e);
        }
        return res;
    }
    
}
