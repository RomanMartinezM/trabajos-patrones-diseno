/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concretas;

import interfaces.Estudiantes;
import interfaces.Iterator;
import iteradores.IteraInscritos;

/**
 *
 * @author laibr
 */
public class ControlEscolar {
    private Estudiantes estudiantes;
    private Estudiantes pasantes;
    
    public ControlEscolar(Inscritos i){estudiantes = i; pasantes = new Pasantes(1);}
    
    public void inscribir()
    {
        Estudiantes aux = estudiantes;
        estudiantes = new Inscritos();
        Iterator iI = aux.getIterador();
        while(iI.hasNext()){
            Estudiante e = iI.next();
            if(e.getSemestre()<8)
            {
                estudiantes.addEstudiante(new Estudiante(e.getNumCont(),e.getSemestre()+1,e.getCredCursos()+30,e.getCredResidencia(),e.getNombre(),e.getCarrera()));
            }else
            {
                pasantes.addEstudiante(new Estudiante(e.getNumCont(),e.getSemestre()+1,e.getCredCursos()+30,e.getCredResidencia(),e.getNombre(),e.getCarrera()));
            }
            
        }
        //iI.restart();
    }
    
    public void concluirResidencia()
    {
        Estudiantes aux = pasantes;
        pasantes = new Pasantes(1);
        Iterator iI = aux.getIterador();
        while(iI.hasNext()){
            Estudiante e = iI.next();
            pasantes.addEstudiante(new Estudiante(e.getNumCont(),e.getSemestre()+1,e.getCredCursos(),e.getCredResidencia()+20,e.getNombre(),e.getCarrera()));   
        }
    }
    
    public void imprimir(String str)
    {
        if(str.equalsIgnoreCase("INSCRITOS"))
                {
                    System.out.println("Relacion de estudiantes " + str);
                    System.out.println("NUM. CONTROL         NOMBRE                     CARRERA          SEMESTRE        CRED. CURSOS         CRED. RESIDENCIA");
                    Iterator iI = estudiantes.getIterador();
                  while(iI.hasNext())
                     {
                    Estudiante e = iI.next();
                    String formato = String.format("    %d             %s            %s           %d             %d                 %d", e.getNumCont(),e.getNombre(),e.getCarrera(),e.getSemestre(),e.getCredCursos(),e.getCredResidencia());
                        
                    System.out.println(formato);
                     }
               }else if (str.equalsIgnoreCase("PASANTES"))
               {
                    System.out.println("Relacion de estudiantes " + str);
                    System.out.println("NUM. CONTROL     NOMBRE       CARRERA      SEMESTRE     CRED. CURSOS     CRED. RESIDENCIA");
                    Iterator iI = pasantes.getIterador();
                   while(iI.hasNext())
                      {
                    Estudiante e = iI.next();
                    String formato = String.format("    %d             %s            %s           %d             %d                 %d", e.getNumCont(),e.getNombre(),e.getCarrera(),e.getSemestre(),e.getCredCursos(),e.getCredResidencia());
                        
                    System.out.println(formato);
                      }
               }
    }
}
