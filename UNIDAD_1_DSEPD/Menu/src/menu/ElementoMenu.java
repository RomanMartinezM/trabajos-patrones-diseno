/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author Roman
 */
public class ElementoMenu extends ComponenteMenu{//Toma el papel de la "Hoja"
    private boolean vegetariano;
   /*
    private String nombre;
    private String descripcion;
    private boolean vegetariano;
    private double precio;

    */
    public ElementoMenu(String nombre, String descripcion, boolean vegetariano, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vegetariano = vegetariano;
        this.precio = precio;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public double getPrecio(){
        return precio;
    }
    public boolean isVegetariano(){
        return vegetariano;
    }
    public void print(){
        System.out.print(" "+getNombre());
        if(isVegetariano()){
            System.out.print("(v)");
        }
        System.out.println(", "+getPrecio());
        System.out.println("      --"+getDescripcion());
    }
    public boolean esHijo(){
        return true;
    }

    
}
    