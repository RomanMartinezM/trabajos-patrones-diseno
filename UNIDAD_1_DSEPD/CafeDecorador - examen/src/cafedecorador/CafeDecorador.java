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
public abstract class CafeDecorador implements Cafe{//toma el papel de Decorador
    protected Cafe cafeDecorador;//son heredados a las clases concretas del decocrador
     
    public CafeDecorador(Cafe decorador){
        this.cafeDecorador = decorador;
    }
     
    @Override
    public int tamanio(){
        return cafeDecorador.tamanio();
    }
    @Override
    public String ingredientes(){
        return cafeDecorador.ingredientes();
    }
    @Override
    public double costo(){
        return cafeDecorador.costo();
    }
    
}
