/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import concretas.Estudiante;
import interfaces.Iterator;

/**
 *
 * @author laibr
 */
public interface Estudiantes {
    
    public Iterator getIterador();
    public void addEstudiante(Estudiante est);
}
