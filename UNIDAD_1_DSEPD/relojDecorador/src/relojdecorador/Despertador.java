/*
 * To change this license header, choose License Headers in Project Properties * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojdecorador;

/**
 *
 * @author lithium
 */
public class Despertador extends RelojDecorador{
    public Despertador(Reloj decorador) {
        super(decorador);
    }
    @Override
    public void fijarHora(int Hora, int Minutos) {
        super.relojDecorador.fijarHora(Hora, Minutos);
    }

    @Override
    public void activar() {
            System.out.println("Se activa el despertador a las " +super.relojDecorador.getHora() + " horas con " + super.relojDecorador.getMinutos() + " minutos");
            super.relojDecorador.activar();
       }

    @Override
    public void mostrar() {
        super.relojDecorador.mostrar();
    }

    @Override
    public void mostrarDia() {
        super.relojDecorador.mostrarDia();
    }

    @Override
    public int getMinutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHora() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
