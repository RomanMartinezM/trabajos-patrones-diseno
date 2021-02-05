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
public class Crema extends CafeDecorador{//toma el papel de DecoradorConcretoB
      protected static Crema instancia, instancia1;
    private static int numIns=0;
    
    protected Crema(Cafe decorador) {
        super(decorador);
      //  getInstancia();
    }
  
    public static Crema getInstancia(Cafe decorador){
        if(instancia == null){
            instancia = new Crema(decorador);
            numIns ++;
            System.out.println("con crema: " + numIns);
        }
        return instancia;
    }
    public static int numIns(){
        return numIns;
    }

   @Override
    public int tamanio() {
        int tamanioCrema = 5;
        return super.cafeDecorador.tamanio() + tamanioCrema;
    }

    @Override
    public String ingredientes() {
        return super.cafeDecorador.ingredientes() + ", con crema";
    }

    @Override
    public double costo() {
        double costoCrema = 2; 
        return super.cafeDecorador.costo() +  costoCrema;
    }
    public void batir(){
        System.out.println("batiendo con crema");
    }
}