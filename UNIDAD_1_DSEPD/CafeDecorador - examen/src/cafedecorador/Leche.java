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
public class Leche extends CafeDecorador {//toma el papel de DecoradorConcretoC
    protected static Leche instancia, instancia1;
    private static int numIns=0;
   
    protected Leche(Cafe decorador) {
        super(decorador);
        // getInstancia();
    }
    
   
    public static Leche getInstancia(Cafe decorador){
        if(instancia == null){
            instancia = new Leche(decorador);
            numIns ++;
            System.out.println("con leche: " + numIns);
        }
        return instancia;
    }
    public static int numIns(){
        return numIns;
    }
    
    @Override
    public int tamanio() {
        int tamanioLeche = 10;
        return super.cafeDecorador.tamanio() + tamanioLeche;
    }

    @Override 
    public String ingredientes() {
        return super.cafeDecorador.ingredientes() + ", con leche";
    }

    @Override
    public double costo() {
        double costoLeche = 15; 
        return super.cafeDecorador.costo() +  costoLeche;
    } 

}
 