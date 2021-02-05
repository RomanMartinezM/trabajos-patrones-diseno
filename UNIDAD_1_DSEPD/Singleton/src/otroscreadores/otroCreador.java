/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otroscreadores;

import singleton.SingletonClasico;

/** 
 *
 * @author lithium
 */ 
public class otroCreador {
    //se crean dos instancias de SingletonClassic
    private SingletonClasico instanciax, instanciay;
    private SingletonClasico otrainstancia;
    public otroCreador(){
        instanciax = SingletonClasico.getInstancia();
        instanciay = SingletonClasico.getInstancia();
    }
    public int numIns(){
        return otrainstancia.numIns();
    }
}
