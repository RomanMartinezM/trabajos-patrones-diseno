/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import concretas.ControlEscolar;
import concretas.Estudiante;
import concretas.Inscritos;

/**
 *
 * @author laibr
 */
public class TestingIterador {
    
    public static void main(String[] args)
    {
        Inscritos inscritos = new Inscritos();
        inscritos.addEstudiante(new Estudiante(100,1,0,0,"Carlos Mora Diaz","Sistemas"));
        inscritos.addEstudiante(new Estudiante(101,1,0,0,"Maria Cadena Libres","Sistemas"));
        inscritos.addEstudiante(new Estudiante(102,1,0,0,"Estela Lopez Cruz","Sistemas"));
        inscritos.addEstudiante(new Estudiante(103,1,0,0,"Marcos I Matias","Sistemas"));
        inscritos.addEstudiante(new Estudiante(104,1,0,0,"Juana Alonso Rios","Sistemas"));
        inscritos.addEstudiante(new Estudiante(105,1,0,0,"Eteban Cruz Paz","Sistemas"));
        
        ControlEscolar ce = new ControlEscolar(inscritos);
        for(int i = 1; i<=9;i++)
        {
            ce.inscribir();
            ce.imprimir("INSCRITOS");
        }
        
        ce.concluirResidencia();
        ce.imprimir("PASANTES");
        
    }
}
