/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_salud;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lithium
 */
@Entity
@Table(name = "tipoactividad", catalog = "salud", schema = "cuidadosalud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoactividad.findAll", query = "SELECT t FROM Tipoactividad t"),
    @NamedQuery(name = "Tipoactividad.findByIdTipoA", query = "SELECT t FROM Tipoactividad t WHERE t.idTipoA = :idTipoA"),
    @NamedQuery(name = "Tipoactividad.findByDescripcion", query = "SELECT t FROM Tipoactividad t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tipoactividad.findByFactorh", query = "SELECT t FROM Tipoactividad t WHERE t.factorh = :factorh"),
    @NamedQuery(name = "Tipoactividad.findByFactorm", query = "SELECT t FROM Tipoactividad t WHERE t.factorm = :factorm")})
public class Tipoactividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_a")
    private Integer idTipoA;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "factorh")
    private BigInteger factorh;
    @Column(name = "factorm")
    private BigInteger factorm;
    @OneToMany(mappedBy = "ta")
    private List<Actividadusuario> actividadusuarioList;

    public Tipoactividad() {
    }

    public Tipoactividad(Integer idTipoA) {
        this.idTipoA = idTipoA;
    }

    public Integer getIdTipoA() {
        return idTipoA;
    }

    public void setIdTipoA(Integer idTipoA) {
        this.idTipoA = idTipoA;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getFactorh() {
        return factorh;
    }

    public void setFactorh(BigInteger factorh) {
        this.factorh = factorh;
    }

    public BigInteger getFactorm() {
        return factorm;
    }

    public void setFactorm(BigInteger factorm) {
        this.factorm = factorm;
    }

    @XmlTransient
    public List<Actividadusuario> getActividadusuarioList() {
        return actividadusuarioList;
    }

    public void setActividadusuarioList(List<Actividadusuario> actividadusuarioList) {
        this.actividadusuarioList = actividadusuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoA != null ? idTipoA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoactividad)) {
            return false;
        }
        Tipoactividad other = (Tipoactividad) object;
        if ((this.idTipoA == null && other.idTipoA != null) || (this.idTipoA != null && !this.idTipoA.equals(other.idTipoA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo_salud.Tipoactividad[ idTipoA=" + idTipoA + " ]";
    }
    
}
