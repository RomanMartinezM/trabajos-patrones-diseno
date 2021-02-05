/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

import java.io.BufferedReader;

/**
 *
 * @author Roman
 */
public abstract class Texto {//clase que toma el papel del "Componente"
    protected static BufferedReader bufer;
    public abstract void escribir(String[] s);
    public abstract void leer(String[] s);
}
