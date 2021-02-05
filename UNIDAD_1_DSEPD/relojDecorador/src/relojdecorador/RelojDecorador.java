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
public abstract class RelojDecorador implements Reloj{
    protected Reloj relojDecorador;
    
     public RelojDecorador(Reloj decorador){
        this.relojDecorador = decorador;
    }
     
    @Override
    public void fijarHora(int Hora, int Minutos) {
        relojDecorador.fijarHora(Hora, Minutos);
    }

    @Override
    public void activar() {
        relojDecorador.activar();
    }

    @Override
    public void mostrar() {
        relojDecorador.mostrar();
    }

    @Override
    public void mostrarDia() {
        relojDecorador.mostrarDia();
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
