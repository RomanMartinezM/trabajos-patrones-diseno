/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Roman
 */
public class Menu extends ComponenteMenu{//Toma el papel de "Compuesto"
    ArrayList<ComponenteMenu> menuComponentes=new ArrayList();
    //private String nombre;
    //private String descripcion;
    //double precio;

    public Menu(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
     public void add (ComponenteMenu menuComponente){
        if(!menuComponentes.contains(menuComponente))
            //System.out.print("\nYa fue agregado al menú!!! :'(");
             menuComponentes.add(menuComponente);
           
    }
     public int getNumElementos(){
         return menuComponentes.size();
     }
    
    public void remove (ComponenteMenu menuComponente){
        //if(menuComponentes.indexOf(menuComponente)!= -1)
        menuComponentes.remove(menuComponente);
    }
    public ComponenteMenu getHijo(int i){
        return (ComponenteMenu)menuComponentes.get(i);
    }
     public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public boolean esHijo(){
        return false;
    }
       
    public void print(){
        System.out.print("\n"+getNombre());
        System.out.print(", "+getDescripcion());
        System.out.print("--------------------");
        Iterator iterator=menuComponentes.iterator();
        while (iterator.hasNext()){
            ComponenteMenu menuComponentes= (ComponenteMenu)iterator.next();
            menuComponentes.print();
        }
    }

   
    public double getPrecio(){
        Iterator<ComponenteMenu> it = menuComponentes.iterator();
        int tot = 0;
        while (it.hasNext()) {
            ComponenteMenu next = it.next();
            tot += next.getPrecio();
        }
        return tot;
    }
    
    
     
}
