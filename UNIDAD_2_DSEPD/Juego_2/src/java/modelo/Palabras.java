/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lithium
 */
@Entity
@Table(name = "palabras", catalog = "juegopalabras", schema = "juegop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palabras.findAll", query = "SELECT p FROM Palabras p"),
    @NamedQuery(name = "Palabras.findByIdPalabra", query = "SELECT p FROM Palabras p WHERE p.idPalabra = :idPalabra"),
    @NamedQuery(name = "Palabras.findByPalabra", query = "SELECT p FROM Palabras p WHERE p.palabra = :palabra"),
    @NamedQuery(name = "Palabras.findByNivel", query = "SELECT p FROM Palabras p WHERE p.nivel = :nivel")})
public class Palabras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_palabra")
    private Integer idPalabra;
    @Size(max = 30)
    @Column(name = "palabra")
    private String palabra;
    @Column(name = "nivel")
    private Integer nivel;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipos")
    @ManyToOne
    private Tipos tipo;

    public Palabras() {
    }

    public Palabras(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public Integer getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalabra != null ? idPalabra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palabras)) {
            return false;
        }
        Palabras other = (Palabras) object;
        if ((this.idPalabra == null && other.idPalabra != null) || (this.idPalabra != null && !this.idPalabra.equals(other.idPalabra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Palabras[ idPalabra=" + idPalabra + " ]";
    }
    
}
