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
public abstract class ComponenteMenu {//Toma el papel del "Componente"
    protected String nombre;
    protected String descripcion;
    protected double precio;
    
    public ComponenteMenu getHijo(int i){
    throw new UnsupportedOperationException();
    }
    public void add (ComponenteMenu menuComponente){
    throw new UnsupportedOperationException();
    }
    public void remove (ComponenteMenu menuComponente){
    throw new UnsupportedOperationException();
    }
   
    public String getNombre(){
    throw new UnsupportedOperationException();
    }
    public String getDescripcion(){
    throw new UnsupportedOperationException();
    }
    public double getPrecio(){
    throw new UnsupportedOperationException();
    }
    public boolean isVegetariano(){
    throw new UnsupportedOperationException();
    }
    public int getNumElementos(){
    throw new UnsupportedOperationException();
        
    }
    public void print() {
        throw new UnsupportedOperationException();
    }
    public boolean esHijo(){
        throw new UnsupportedOperationException();
    }

}
