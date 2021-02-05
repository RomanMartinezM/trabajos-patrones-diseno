/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteradores;

import concretas.Estudiante;
import interfaces.Iterator;

/**
 *
 * @author laibr
 */
public class IteraPasantes implements interfaces.Iterator{
    
    private Estudiante[] pasantes;
    private int numEstudiantes;
    private int posicion = 0;
    
    public IteraPasantes(Estudiante[] la, int n)
    {
        pasantes = la;
        numEstudiantes = n;
    }
    
    @Override
    public boolean hasNext() {
       return posicion < (pasantes.length);
    }

    @Override
    public Estudiante next() {
        return pasantes[posicion++];
    }
    
    
    public Estudiante previous() {
        return pasantes[posicion--];
    }
    
    public void restart() {
        posicion = 0;
    }
    
    public boolean isFirst() {
        return posicion == 0;
    }
}
