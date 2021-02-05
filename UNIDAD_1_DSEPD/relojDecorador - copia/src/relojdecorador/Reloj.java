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
public interface Reloj {
    public void fijarHora(int Hora, int Minutos);
    public void activar();
    public void mostrar();
    public void mostrarDia();
    int getMinutos();
    int getHora();
}
