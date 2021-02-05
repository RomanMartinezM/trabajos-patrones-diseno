/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concretas;

/**
 *
 * @author laibr
 */
public class Estudiante {
    private int numControl = 100;
    private String nombre;
    private String carrera;
    private int semestre;
    private int creditosCursos;
    private int creditosResidencia;
    
    public Estudiante(int nC, int sem, int cC, int cR, String nom, String car)
    {
        numControl = nC;
        nombre = nom;
        carrera = car;
        semestre = sem;
        creditosCursos = cC;
        creditosResidencia = cR;
    }
    
    public int getNumCont(){return numControl;}
    
    public String getNombre(){return nombre;}
    
    public String getCarrera(){return carrera;}
    
    public int getSemestre(){return semestre;}
    
    public int getCredCursos(){return creditosCursos;}
    
    public int getCredResidencia(){return creditosResidencia;}
    
    

}
