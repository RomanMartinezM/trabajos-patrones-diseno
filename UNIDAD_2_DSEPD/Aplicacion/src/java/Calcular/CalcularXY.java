package Calcular;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edwin
 */
public class CalcularXY {
    private double x=0;
    private double y=0;

    
    public String elevar(double x,double y)
    {
        
        double resultado=0.0;
        resultado=Math.pow(x, y);
        return String.format("%4.2f elevado a la %4.2f es %4.2f",x,y,resultado);
    }
    
    
    
}
