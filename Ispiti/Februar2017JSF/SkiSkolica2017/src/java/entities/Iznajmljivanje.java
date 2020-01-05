/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author Milica
 */
@Entity
@Table(name = "iznajmljivanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iznajmljivanje.findAll", query = "SELECT i FROM Iznajmljivanje i")
    , @NamedQuery(name = "Iznajmljivanje.findByIdracun", query = "SELECT i FROM Iznajmljivanje i WHERE i.idracun = :idracun")
    , @NamedQuery(name = "Iznajmljivanje.findByDatumpreuz", query = "SELECT i FROM Iznajmljivanje i WHERE i.datumpreuz = :datumpreuz")
    , @NamedQuery(name = "Iznajmljivanje.findByImapopust", query = "SELECT i FROM Iznajmljivanje i WHERE i.imapopust = :imapopust")
    , @NamedQuery(name = "Iznajmljivanje.findByRazduzeno", query = "SELECT i FROM Iznajmljivanje i WHERE i.razduzeno = :razduzeno")
    , @NamedQuery(name = "Iznajmljivanje.findByUkupnoNaplata", query = "SELECT i FROM Iznajmljivanje i WHERE i.ukupnoNaplata = :ukupnoNaplata")
    , @NamedQuery(name = "Iznajmljivanje.findByPlaniranovracanje", query = "SELECT i FROM Iznajmljivanje i WHERE i.planiranovracanje = :planiranovracanje")
    , @NamedQuery(name = "Iznajmljivanje.findByIdKorisnik", query = "SELECT i FROM Iznajmljivanje i WHERE i.idkorisnik.username = :idkorisnik")
    , @NamedQuery(name = "Iznajmljivanje.findByDepozit", query = "SELECT i FROM Iznajmljivanje i WHERE i.depozit = :depozit")})
public class Iznajmljivanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idracun")
    private Integer idracun;
    @Basic(optional = false)
    @Column(name = "datumpreuz")
    @Temporal(TemporalType.DATE)
    private Date datumpreuz;
    @Basic(optional = false)
    @Column(name = "imapopust")
    private boolean imapopust;
    @Basic(optional = false)
    @Column(name = "razduzeno")
    private boolean razduzeno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ukupno_naplata")
    private Double ukupnoNaplata;
    @Basic(optional = false)
    @Column(name = "planiranovracanje")
    @Temporal(TemporalType.DATE)
    private Date planiranovracanje;
    @Basic(optional = false)
    @Column(name = "depozit")
    private int depozit;
    @JoinColumn(name = "idkorisnik", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Korisnik idkorisnik;
    @JoinColumn(name = "idopreme", referencedColumnName = "idopreme")
    @ManyToOne(optional = false)
    private Skioprema idopreme;

    public Iznajmljivanje() {
    }

    public Iznajmljivanje(Integer idracun) {
        this.idracun = idracun;
    }

    public Iznajmljivanje(Integer idracun, Date datumpreuz, boolean imapopust, boolean razduzeno, Date planiranovracanje, int depozit) {
        this.idracun = idracun;
        this.datumpreuz = datumpreuz;
        this.imapopust = imapopust;
        this.razduzeno = razduzeno;
        this.planiranovracanje = planiranovracanje;
        this.depozit = depozit;
    }

    public Integer getIdracun() {
        return idracun;
    }

    public void setIdracun(Integer idracun) {
        this.idracun = idracun;
    }

    public Date getDatumpreuz() {
        return datumpreuz;
    }

    public void setDatumpreuz(Date datumpreuz) {
        this.datumpreuz = datumpreuz;
    }

    public boolean getImapopust() {
        return imapopust;
    }

    public void setImapopust(boolean imapopust) {
        this.imapopust = imapopust;
    }

    public boolean getRazduzeno() {
        return razduzeno;
    }

    public void setRazduzeno(boolean razduzeno) {
        this.razduzeno = razduzeno;
    }

    public Double getUkupnoNaplata() {
        return ukupnoNaplata;
    }

    public void setUkupnoNaplata(Double ukupnoNaplata) {
        this.ukupnoNaplata = ukupnoNaplata;
    }

    public Date getPlaniranovracanje() {
        return planiranovracanje;
    }

    public void setPlaniranovracanje(Date planiranovracanje) {
        this.planiranovracanje = planiranovracanje;
    }

    public int getDepozit() {
        return depozit;
    }

    public void setDepozit(int depozit) {
        this.depozit = depozit;
    }

    public Korisnik getIdkorisnik() {
        return idkorisnik;
    }

    public void setIdkorisnik(Korisnik idkorisnik) {
        this.idkorisnik = idkorisnik;
    }

    public Skioprema getIdopreme() {
        return idopreme;
    }

    public void setIdopreme(Skioprema idopreme) {
        this.idopreme = idopreme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idracun != null ? idracun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iznajmljivanje)) {
            return false;
        }
        Iznajmljivanje other = (Iznajmljivanje) object;
        if ((this.idracun == null && other.idracun != null) || (this.idracun != null && !this.idracun.equals(other.idracun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Iznajmljivanje[ idracun=" + idracun + " ]";
    }
    
}
