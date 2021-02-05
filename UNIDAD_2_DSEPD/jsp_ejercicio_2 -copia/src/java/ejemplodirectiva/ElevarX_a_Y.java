/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodirectiva;

/**
 *
 * @author lithium
 */
public class ElevarX_a_Y {
    private double x;
    private double y;
    public ElevarX_a_Y(double vx, double vy){
        x = vx;
        y = vy;
    }
    public String elevarX_a_la_Y(){
        double xy = 0.0;
        xy = Math.pow(x, y);
        return String.format("%4.2f elevado a la %4.2f es %4.2f",x,y,xy);
    }
}
