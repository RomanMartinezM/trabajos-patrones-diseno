/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojdecorador;

/**
 *
 * @author lithium
 */
public class RelojC implements Reloj{
    
    protected int Hora=0, Minutos=0;
    protected String []Dia={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
    int k = 0;

    public int getHora() {
        return Hora;
    }

    public int getMinutos() {
        return Minutos;
    }
 
    
    @Override
    public void fijarHora(int Hora, int Minutos) {
        this.Hora = Hora;
        this.Minutos = Minutos;
    }

    @Override
    public void activar() {
        for (int i = 0; i < 24; i++) {
            if (Hora > 23) {
                Hora = 0;
                if (k == 6) {
                    Dia[k] = Dia[k];
                    k=0;
                } else {
                    Dia[k] = Dia[k];
                    k++;
                }
                
            }else{
                Hora++;
            } 
            for (int j = 0; j < 60; j++) {
                if (Minutos > 59) {
                    Minutos = 0;
                   // Minutos++;
                } else {
                    Minutos++;
                }
                
            }
        }
    }

    @Override
    public void mostrar() {
        System.out.println("hora: " + Hora + " minutos: " + Minutos);
    }

    @Override
    public void mostrarDia() {
         System.out.println("hora: " + Hora + " minutos: " + Minutos + " dia: " + Dia[k]);
    }
    
}
