/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafedecorador;

/**
 *
 * @author Román Martínez Mendoza
 */
public class Canela extends CafeDecorador{//toma el papel de DecoradorConcretoA

    public Canela(Cafe decorador) {
        super(decorador);
    }

    @Override
    public int tamanio() {
       int tamanio = 20;
       return super.cafeDecorador.tamanio() + tamanio;
    } 

    @Override
    public String ingredientes() {
        return super.cafeDecorador.ingredientes() + ", con canela";
    }

    @Override
    public double costo() {
        double costoCanela = 1;
        return super.cafeDecorador.costo() + costoCanela;
    }
    
}
