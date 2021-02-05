/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concretas;

import interfaces.Estudiantes;
import interfaces.Iterator;
import iteradores.IteraInscritos;
import java.util.ArrayList;

/**
 *
 * @author laibr
 */
public class Inscritos implements Estudiantes{
    private  ArrayList <Estudiante> estudiantes;
    
    public Inscritos()
    {
        estudiantes = new ArrayList<Estudiante>();
    }
    
    @Override
    public Iterator getIterador() {
        return new IteraInscritos(estudiantes);
    }

    @Override
    public void addEstudiante(Estudiante est) {
        estudiantes.add(est);
    }
    
}
