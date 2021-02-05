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
public class Canela extends CafeDecorador{

    public Canela(Cafe decorador) {
        super(decorador);
    }

    @Override
    public int tamanio() {
        int tamanio = 20;
       return cafeDecorador.tamanio() + tamanio;
    }

    @Override
    public String ingredientes() {
        return cafeDecorador.ingredientes() + "con canela";
    }

    @Override
    public double costo() {
        double costoCanela = 0.50;
        return cafeDecorador.costo() + costoCanela;
    }
    
}
