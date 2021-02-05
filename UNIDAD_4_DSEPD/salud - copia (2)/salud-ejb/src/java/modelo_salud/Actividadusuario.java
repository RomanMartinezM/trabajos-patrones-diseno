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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lithium
 */
@Entity
@Table(name = "actividadusuario", catalog = "salud", schema = "cuidadosalud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividadusuario.findAll", query = "SELECT a FROM Actividadusuario a"),
    @NamedQuery(name = "Actividadusuario.findByIdActusu", query = "SELECT a FROM Actividadusuario a WHERE a.idActusu = :idActusu"),
    @NamedQuery(name = "Actividadusuario.findByDescripcion", query = "SELECT a FROM Actividadusuario a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Actividadusuario.findByFecha1", query = "SELECT a FROM Actividadusuario a WHERE a.fecha1 = :fecha1"),
    @NamedQuery(name = "Actividadusuario.findByFecha2", query = "SELECT a FROM Actividadusuario a WHERE a.fecha2 = :fecha2")})
public class Actividadusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actusu")
    private Integer idActusu;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha1")
    @Temporal(TemporalType.DATE)
    private Date fecha1;
    @Column(name = "fecha2")
    @Temporal(TemporalType.DATE)
    private Date fecha2;
    @JoinColumn(name = "ta", referencedColumnName = "id_tipo_a")
    @ManyToOne
    private Tipoactividad ta;
    @JoinColumn(name = "id_usuar", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuar;

    public Actividadusuario() {
    }

    public Actividadusuario(Integer idActusu) {
        this.idActusu = idActusu;
    }

    public Integer getIdActusu() {
        return idActusu;
    }

    public void setIdActusu(Integer idActusu) {
        this.idActusu = idActusu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Tipoactividad getTa() {
        return ta;
    }

    public void setTa(Tipoactividad ta) {
        this.ta = ta;
    }

    public Usuario getIdUsuar() {
        return idUsuar;
    }

    public void setIdUsuar(Usuario idUsuar) {
        this.idUsuar = idUsuar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActusu != null ? idActusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividadusuario)) {
            return false;
        }
        Actividadusuario other = (Actividadusuario) object;
        if ((this.idActusu == null && other.idActusu != null) || (this.idActusu != null && !this.idActusu.equals(other.idActusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo_salud.Actividadusuario[ idActusu=" + idActusu + " ]";
    }
    
}
