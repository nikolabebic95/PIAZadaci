/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nikola
 */
@Entity
@Table(name = "skioprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skioprema.findAll", query = "SELECT s FROM Skioprema s")
    , @NamedQuery(name = "Skioprema.findByIdopreme", query = "SELECT s FROM Skioprema s WHERE s.idopreme = :idopreme")
    , @NamedQuery(name = "Skioprema.findByNaziv", query = "SELECT s FROM Skioprema s WHERE s.naziv = :naziv")
    , @NamedQuery(name = "Skioprema.findByVrsta", query = "SELECT s FROM Skioprema s WHERE s.vrsta = :vrsta")
    , @NamedQuery(name = "Skioprema.findByKolicina", query = "SELECT s FROM Skioprema s WHERE s.kolicina = :kolicina")
    , @NamedQuery(name = "Skioprema.findByVelicina", query = "SELECT s FROM Skioprema s WHERE s.velicina = :velicina")
    , @NamedQuery(name = "Skioprema.findByCenapodanu", query = "SELECT s FROM Skioprema s WHERE s.cenapodanu = :cenapodanu")})
public class Skioprema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idopreme")
    private Integer idopreme;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "vrsta")
    private String vrsta;
    @Basic(optional = false)
    @Column(name = "kolicina")
    private int kolicina;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "velicina")
    private Double velicina;
    @Basic(optional = false)
    @Column(name = "cenapodanu")
    private double cenapodanu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idopreme")
    private List<Iznajmljivanje> iznajmljivanjeList;

    public Skioprema() {
    }

    public Skioprema(Integer idopreme) {
        this.idopreme = idopreme;
    }

    public Skioprema(Integer idopreme, String naziv, String vrsta, int kolicina, double cenapodanu) {
        this.idopreme = idopreme;
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.kolicina = kolicina;
        this.cenapodanu = cenapodanu;
    }

    public Integer getIdopreme() {
        return idopreme;
    }

    public void setIdopreme(Integer idopreme) {
        this.idopreme = idopreme;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Double getVelicina() {
        return velicina;
    }

    public void setVelicina(Double velicina) {
        this.velicina = velicina;
    }

    public double getCenapodanu() {
        return cenapodanu;
    }

    public void setCenapodanu(double cenapodanu) {
        this.cenapodanu = cenapodanu;
    }

    @XmlTransient
    public List<Iznajmljivanje> getIznajmljivanjeList() {
        return iznajmljivanjeList;
    }

    public void setIznajmljivanjeList(List<Iznajmljivanje> iznajmljivanjeList) {
        this.iznajmljivanjeList = iznajmljivanjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idopreme != null ? idopreme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skioprema)) {
            return false;
        }
        Skioprema other = (Skioprema) object;
        if ((this.idopreme == null && other.idopreme != null) || (this.idopreme != null && !this.idopreme.equals(other.idopreme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Skioprema[ idopreme=" + idopreme + " ]";
    }

}
