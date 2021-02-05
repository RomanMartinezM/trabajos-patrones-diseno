/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositelibro;

/**
 *
 * @author lithium
 */
public abstract class ComponenteLibro {
    
    public void add (ComponenteLibro libroComponente){
    throw new UnsupportedOperationException();
    }
    public void remove (ComponenteLibro libroComponente){
    throw new UnsupportedOperationException();
    }
    public String getTitulo(){
    throw new UnsupportedOperationException();
    }
    
    public ComponenteLibro getHijo(int i){
    throw new UnsupportedOperationException();
    }
    public abstract void listar();
    
    public String getTema(){
    throw new UnsupportedOperationException();
    }
    public String getSubtema(){
    throw new UnsupportedOperationException();
    }
    public boolean isDisponible(){
    throw new UnsupportedOperationException();
    }
    
    public int getPagina(){
    throw new UnsupportedOperationException();
    }
    

    public void print() {
        throw new UnsupportedOperationException();
    }
    public boolean esHijo(){
        throw new UnsupportedOperationException();
    }
    
}
