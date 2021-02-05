/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerationiteratoradapterexample;

/**
 *
 * @author Roman Martinez Mendoza
 */
public interface Enumeration {//Interfaz que toma el papel de "Adaptada"
    public boolean hasMoreElements();
    public Object nextElement();
}
