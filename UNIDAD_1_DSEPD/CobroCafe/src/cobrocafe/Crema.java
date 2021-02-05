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
public class Crema extends CafeDecorador{

    public Crema(Cafe decorador) {
        super(decorador);
    }


    @Override
    public int tamanio() {
        int tamanioCrema = 5;
        return cafeDecorador.tamanio() + tamanioCrema;
    }

    @Override
    public String ingredientes() {
        return cafeDecorador.ingredientes() + "con crema";
    }

    @Override
    public double costo() {
        double costoCrema = 10; 
        return cafeDecorador.costo() +  costoCrema;
    }
}
