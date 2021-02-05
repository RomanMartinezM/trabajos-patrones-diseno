/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_salud;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lithium
 */
@Entity
@Table(name = "antropometricos", catalog = "salud", schema = "cuidadosalud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antropometricos.findAll", query = "SELECT a FROM Antropometricos a"),
    @NamedQuery(name = "Antropometricos.findByIdAntro", query = "SELECT a FROM Antropometricos a WHERE a.idAntro = :idAntro"),
    @NamedQuery(name = "Antropometricos.findByFecha", query = "SELECT a FROM Antropometricos a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Antropometricos.findByPeso", query = "SELECT a FROM Antropometricos a WHERE a.peso = :peso"),
    @NamedQuery(name = "Antropometricos.findByCintura", query = "SELECT a FROM Antropometricos a WHERE a.cintura = :cintura"),
    @NamedQuery(name = "Antropometricos.findByCadera", query = "SELECT a FROM Antropometricos a WHERE a.cadera = :cadera")})
public class Antropometricos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antro")
    private Integer idAntro;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "cintura")
    private Integer cintura;
    @Column(name = "cadera")
    private Integer cadera;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsu;

    public Antropometricos() {
    }

    public Antropometricos(Integer idAntro) {
        this.idAntro = idAntro;
    }

    public Integer getIdAntro() {
        return idAntro;
    }

    public void setIdAntro(Integer idAntro) {
        this.idAntro = idAntro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Usuario getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuario idUsu) {
        this.idUsu = idUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntro != null ? idAntro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antropometricos)) {
            return false;
        }
        Antropometricos other = (Antropometricos) object;
        if ((this.idAntro == null && other.idAntro != null) || (this.idAntro != null && !this.idAntro.equals(other.idAntro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo_salud.Antropometricos[ idAntro=" + idAntro + " ]";
    }
    
}
