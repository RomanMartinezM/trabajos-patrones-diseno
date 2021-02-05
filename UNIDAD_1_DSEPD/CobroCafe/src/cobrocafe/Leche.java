/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrocafe;

/**
 *
 * @author Anselmo Lorenzo Olivera
 */
public class Leche extends CafeDecorador {
   
    public Leche(Cafe decorador) {
        super(decorador);
    }

    @Override
    public int tamanio() {
        int tamanioLeche = 10;
        return cafeDecorador.tamanio() + tamanioLeche;
    }

    @Override
    public String ingredientes() {
        return cafeDecorador.ingredientes() + "con leche";
    }

    @Override
    public double costo() {
        double costoLeche = 13; 
        return cafeDecorador.costo() +  costoLeche;
    }
}
