/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodatos;

import java.util.Scanner;

/**
 *
 *  @author Roman Martinez Mendoza
 */ 
public class ManipulaDatos { 
     public static void main(String[] args) {
         
        Scanner opUpd = new Scanner(System.in);
        Scanner dato = new Scanner(System.in);
        Scanner opcion = new Scanner(System.in);
        int eleccion;
        int escogido;
        int idproducto = 0, cantidad = 0;
        String descripcion = "";
        double precio = 0.0; 
        
        AccesoDatos ad = new AccesoDatos();  
 
      
       do{
           System.out.println("Seleccione una opción" +"\n1.- Insertar producto\n2.- Actualizar producto\n3.- Listar productos\n4.- Salir\n");
           eleccion=opcion.nextInt();
           
            switch (eleccion){ 
                                    
                case 1: 

                        System.out.println("\n\n\n----------------INSERTAR--------------------");  
              
                        System.out.println("INGRESE LOS SIGUIENTES DATOS ");

                        System.out.println("Introduzca el id del producto");
                        idproducto = Integer.parseInt(dato.nextLine());

                        System.out.println("Introduzca la descripción del producto");
                        descripcion = (dato.nextLine());

                        System.out.println("Introduzca la cantidad del producto");
                        cantidad = Integer.parseInt(dato.nextLine());

                        System.out.println("Introduzca el precio del producto");
                        precio = Double.parseDouble(dato.nextLine());

                         String sql = "INSERT INTO bd_productos.producto(idprod,descripcion,cantidad,precio)VALUES(" +idproducto + ",'" + descripcion + "'," + cantidad + "," + precio + ")";
              
                         System.out.println(ad.actualizaProductos(sql));
              
                         break;
                case 2:
                        
                        System.out.println("\n\n\n-----------------ACTUALIZAR-------------------");

                        
                        System.out.println("Introduzca el id del producto");
                        idproducto = Integer.parseInt(dato.nextLine());
                        
                        System.out.println("¿Desea modificar la descripción del producto?\n1.- Si\n2.-No");
                        escogido = Integer.parseInt(opUpd.nextLine());
                        if(escogido == 1){
                                System.out.println("Introduzca la cantidad del producto");
                                descripcion = dato.nextLine();

                                String sqlActualizar = "UPDATE bd_productos.producto SET descripcion=" + descripcion + " WHERE idprod=" + idproducto;

                                System.out.println(ad.actualizaProductos(sqlActualizar));

                        }
                        
                        System.out.println("¿Desea modificar la cantidad del producto?\n1.- Si\n2.-No");
                        escogido = Integer.parseInt(opUpd.nextLine());
                        if(escogido == 1){
                                System.out.println("Introduzca la cantidad del producto");
                                cantidad = Integer.parseInt(dato.nextLine());

                                String sqlActualizar = "UPDATE bd_productos.producto SET cantidad=" + cantidad + " WHERE idprod=" + idproducto;

                                System.out.println(ad.actualizaProductos(sqlActualizar));

                        }
                        System.out.println("¿Desea modificar el precio del producto?\n1.- Si\n2.-No");
                        escogido = Integer.parseInt(opUpd.nextLine());
                        if(escogido == 1){
                                System.out.println("Introduzca el precio del producto");
                                precio = Double.parseDouble(dato.nextLine());
                               
                                String sqlActualizar = "UPDATE bd_productos.producto SET precio=" + precio + " WHERE idprod=" + idproducto;

                                System.out.println(ad.actualizaProductos(sqlActualizar));

                        }
                        break;
                case 3:
                         System.out.println("\n\n\n-----------------LISTAR-------------------");
                         String consulta = "SELECT * FROM bd_productos.producto";
                         ad.visualizar(consulta);
                case 4:
                        break;
                default:
                        System.out.println( "Opción inválida");
                        break;
            }
                            
       }while(eleccion != 4);
             
    }
}
