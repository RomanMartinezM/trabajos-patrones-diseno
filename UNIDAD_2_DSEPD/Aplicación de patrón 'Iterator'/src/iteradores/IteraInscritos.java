/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteradores;
import concretas.Estudiante;
import interfaces.Iterator;
import java.util.ArrayList;
/**
 *
 * @author laibr
 */
public class IteraInscritos implements Iterator{
    ArrayList <Estudiante> inscritos;
    int posicion = 0;
    
    public IteraInscritos(ArrayList<Estudiante> est)
    {
        inscritos = est;
    }
    
    @Override
    public boolean hasNext() {
       return posicion < (inscritos.size());
    }

    @Override
    public Estudiante next() {
        return inscritos.get(posicion++);
    }
    
    
    public Estudiante previous() {
        return inscritos.get(posicion--);
    }
    
    public void restart() {
        posicion = 0;
    }
    
    public boolean isFirst() {
        return posicion == 0;
    }
}
