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
public abstract class FiguraDecorador implements Figura{//Clase que toma el papel de Decorador
    protected Figura decoradorFigura;
     
    public FiguraDecorador(Figura decoradorFigura){
        this.decoradorFigura = decoradorFigura;
    }
    
}
