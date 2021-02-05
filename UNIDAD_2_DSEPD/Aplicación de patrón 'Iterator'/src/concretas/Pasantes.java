/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concretas;
import interfaces.Estudiantes;
import interfaces.Iterator;
import iteradores.IteraPasantes;
/**
 *
 * @author laibr
 */
public class Pasantes implements Estudiantes{
    private Estudiante[] estudiantes;
    
    public Pasantes(int n){estudiantes = new Estudiante[n];}
    
    @Override
    public Iterator getIterador(){
        return new IteraPasantes(estudiantes, estudiantes.length);
    }
    
    @Override
    public void addEstudiante(Estudiante est)
    {
        if(estudiantes[0] == null)
        {
            estudiantes[0] = est;
        }else
        {
            Estudiante[] aux = new Estudiante[estudiantes.length+1];
           for(int i = 0;i<aux.length-1;i++)
           {
               aux[i] = estudiantes[i];
           }
        aux[estudiantes.length] = est;
        estudiantes = aux;
        }
        
        }
    
    
    }
