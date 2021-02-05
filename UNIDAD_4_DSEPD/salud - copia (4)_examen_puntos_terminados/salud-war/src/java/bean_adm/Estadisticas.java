/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean_adm;

import java.util.Date;

/**
 *
 * @author lithium
 */
public class Estadisticas {
    public double imc;
    public double icc;
    public Date fecha;
    public int estatura;
    public Integer peso;
    public Integer cintura;
    public Integer cadera;
    
    public Estadisticas(double imc, double icc, Date fecha, int estatura, Integer peso, Integer cintura, Integer cadera){
        this.imc = imc;
        this.icc = icc;
        this.fecha = fecha;
        this.estatura = estatura;
        this.peso = peso;
        this.cintura = cintura;
        this.cadera = cadera;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getIcc() {
        return icc;
    }

    public void setIcc(double icc) {
        this.icc = icc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Integer getCadera() {
        return cadera;
    }

    public void setCadera(Integer cadera) {
        this.cadera = cadera;
    }
    
}
