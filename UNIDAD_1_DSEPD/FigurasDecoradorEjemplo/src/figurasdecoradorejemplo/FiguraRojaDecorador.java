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
public class FiguraRojaDecorador extends FiguraDecorador{ //Clase que toma el papel de DecoradorConcreto
    
    public FiguraRojaDecorador(Figura decoradorFigura) {
        super(decoradorFigura);
    }

    @Override
    public void dibujar() {
        decoradorFigura.dibujar();
        setBordeRojo(decoradorFigura);
    }

    public void setBordeRojo(Figura decoradorFigura) {
        System.out.println("Borde de color rojo");
    }
    
    
}
