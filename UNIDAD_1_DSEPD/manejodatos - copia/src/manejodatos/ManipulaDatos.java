/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodatos;

/**
 *
 * @author lithium
 */ 
public class ManipulaDatos { 
     public static void main(String[] args) {
        AccesoDatos ad = new AccesoDatos();
        String consulta = "SELECT * FROM bd_productos.producto";
        ad.visualizar(consulta);
        
        Object producto[] = {11,"bicolores",65,12.50};
        //Object producto2[] = {11,"bicolores",100,15.50};
         
        ad.insertarProducto(producto);
        
        System.out.println("\nPRODUCTOS INSERTADOS");
        ad.visualizar(consulta);
        
        /*
        ad.actualizar(producto2);
        
         System.out.println("\nPRODUCTOS ACTUALIDOS");
        ad.visualizar(consulta);*/
        
    }
}
