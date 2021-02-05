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
public class CafeSolo implements Cafe{
    double costo = 15;
    int tamanio = 200;

    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public String ingredientes() {
        return "Cafe solo";
    }

    @Override
    public double costo() {
        return costo;
    }
    

    
}
