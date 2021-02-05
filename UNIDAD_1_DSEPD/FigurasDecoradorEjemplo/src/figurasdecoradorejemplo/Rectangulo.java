/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasdecoradorejemplo;

/**
 *
 * @author Martínez Mendoza Román
 */
public class Rectangulo implements Figura{//Clase que toma el papel de ComponenteConcretoA

    @Override
    public void dibujar() {
        System.out.println("Rectangulo se dibuja");
    }
    
}
