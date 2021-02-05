/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
@Table(name = "juegos_usuario", catalog = "juegopalabras", schema = "juegop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuegosUsuario.findAll", query = "SELECT j FROM JuegosUsuario j"),
    @NamedQuery(name = "JuegosUsuario.findByIdJuegousu", query = "SELECT j FROM JuegosUsuario j WHERE j.idJuegousu = :idJuegousu"),
    @NamedQuery(name = "JuegosUsuario.findByIntentosr", query = "SELECT j FROM JuegosUsuario j WHERE j.intentosr = :intentosr"),
    @NamedQuery(name = "JuegosUsuario.findByIntentost", query = "SELECT j FROM JuegosUsuario j WHERE j.intentost = :intentost"),
    @NamedQuery(name = "JuegosUsuario.findByFechaHora", query = "SELECT j FROM JuegosUsuario j WHERE j.fechaHora = :fechaHora")})
public class JuegosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_juegousu")
    private Integer idJuegousu;
    @Column(name = "intentosr")
    private Integer intentosr;
    @Column(name = "intentost")
    private Integer intentost;
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.DATE)
    private Date fechaHora;
    @JoinColumn(name = "idpalabra", referencedColumnName = "id_palabra")
    @ManyToOne
    private Palabras idpalabra;
    @JoinColumn(name = "idusuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idusuario;

    public JuegosUsuario() {
    }

    public JuegosUsuario(Integer idJuegousu) {
        this.idJuegousu = idJuegousu;
    }

    public Integer getIdJuegousu() {
        return idJuegousu;
    }

    public void setIdJuegousu(Integer idJuegousu) {
        this.idJuegousu = idJuegousu;
    }

    public Integer getIntentosr() {
        return intentosr;
    }

    public void setIntentosr(Integer intentosr) {
        this.intentosr = intentosr;
    }

    public Integer getIntentost() {
        return intentost;
    }

    public void setIntentost(Integer intentost) {
        this.intentost = intentost;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Palabras getIdpalabra() {
        return idpalabra;
    }

    public void setIdpalabra(Palabras idpalabra) {
        this.idpalabra = idpalabra;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuegousu != null ? idJuegousu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuegosUsuario)) {
            return false;
        }
        JuegosUsuario other = (JuegosUsuario) object;
        if ((this.idJuegousu == null && other.idJuegousu != null) || (this.idJuegousu != null && !this.idJuegousu.equals(other.idJuegousu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.JuegosUsuario[ idJuegousu=" + idJuegousu + " ]";
    }
    
}
