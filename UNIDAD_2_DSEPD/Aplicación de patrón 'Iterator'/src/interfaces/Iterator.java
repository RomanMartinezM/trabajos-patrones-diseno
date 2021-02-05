/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import concretas.Estudiante;

/**
 *
 * @author laibr
 */
public interface Iterator {
    
  
    public boolean hasNext();
    
    public Estudiante next();
    
    public Estudiante previous();
    
    public void restart();
    
    public boolean isFirst();
}
