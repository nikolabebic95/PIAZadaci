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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milica
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByUsername", query = "SELECT k FROM Korisnik k WHERE k.username = :username")
    , @NamedQuery(name = "Korisnik.findByPassword", query = "SELECT k FROM Korisnik k WHERE k.password = :password")
    , @NamedQuery(name = "Korisnik.findByIme", query = "SELECT k FROM Korisnik k WHERE k.ime = :ime")
    , @NamedQuery(name = "Korisnik.findByPrezime", query = "SELECT k FROM Korisnik k WHERE k.prezime = :prezime")
    , @NamedQuery(name = "Korisnik.findByGodSkijanja", query = "SELECT k FROM Korisnik k WHERE k.godSkijanja = :godSkijanja")
    , @NamedQuery(name = "Korisnik.findByZelimCasove", query = "SELECT k FROM Korisnik k WHERE k.zelimCasove = :zelimCasove")
    , @NamedQuery(name = "Korisnik.findByJeInstruktor", query = "SELECT k FROM Korisnik k WHERE k.jeInstruktor = :jeInstruktor")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "god_skijanja")
    private int godSkijanja;
    @Basic(optional = false)
    @Column(name = "zelim_casove")
    private boolean zelimCasove;
    @Basic(optional = false)
    @Column(name = "je_instruktor")
    private short jeInstruktor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkorisnik")
    private List<Iznajmljivanje> iznajmljivanjeList;

    public Korisnik() {
    }

    public Korisnik(String username) {
        this.username = username;
    }

    public Korisnik(String username, String password, String ime, String prezime, int godSkijanja, boolean zelimCasove, short jeInstruktor) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.godSkijanja = godSkijanja;
        this.zelimCasove = zelimCasove;
        this.jeInstruktor = jeInstruktor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodSkijanja() {
        return godSkijanja;
    }

    public void setGodSkijanja(int godSkijanja) {
        this.godSkijanja = godSkijanja;
    }

    public boolean getZelimCasove() {
        return zelimCasove;
    }

    public void setZelimCasove(boolean zelimCasove) {
        this.zelimCasove = zelimCasove;
    }

    public short getJeInstruktor() {
        return jeInstruktor;
    }

    public void setJeInstruktor(short jeInstruktor) {
        this.jeInstruktor = jeInstruktor;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Korisnik[ username=" + username + " ]";
    }
    
}
