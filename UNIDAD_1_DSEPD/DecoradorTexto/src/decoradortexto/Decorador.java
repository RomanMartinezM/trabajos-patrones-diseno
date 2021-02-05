/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

/**
 *
 * @author Roman
 */
public abstract class Decorador extends Texto{//clase que toma el papel del "Decorador"
    protected Texto buferText;
    
    
    public Decorador(Texto text){
        this.buferText = text;
    }
    @Override
    public void escribir(String[] s) {
         buferText.escribir(s);
    }

    @Override
    public void leer(String[] s) {
         buferText.leer(s);
    }
    
}
