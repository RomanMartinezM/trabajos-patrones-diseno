/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorejemploadaptador;

/**
 *
 * @author Martinez Mendoza Roman
 */
public class Aplicacion {
    
     private void usarMotorComun() {
        Motor motor = new MotorComun();
        //motor = new MotorComun();
        motor.encender();
        motor.acelerar();
        motor.apagar();
    }
    private void usarMotorElectrico() {
        Motor motor = new MotorElectricoAdapter() ;
        motor.encender();
        motor.acelerar();
        motor.apagar();
    } 
    private void usarMotorEconomico() {
        Motor motor = new MotorEconomico();
        motor.encender();
        motor.acelerar();
        motor.apagar();
    }
     public static void main(String[] args) {
       Aplicacion ap = new Aplicacion();
       System.out.println("\n\nMotor Comun");
       ap.usarMotorComun();
       System.out.println("\n\nMotor Economico");
       ap.usarMotorEconomico();
       System.out.println("\n\nMotor Electrico");
       ap.usarMotorElectrico();
    }

}
