/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbmock;

import java.util.HashMap;

/**
 *
 * @author Nikola
 */
public class Korisnik {
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private boolean tip;

    public final static HashMap<String, Korisnik> map = new HashMap<>();
    
    static {
        map.put("bibliotekar1", new Korisnik("Nada", "Bibliotekarka", "bibliotekar1", "sifra123", true));
        map.put("marko", new Korisnik("Marko", "Markovic", "marko", "marko123", false));
        map.put("nikola", new Korisnik("Nikola", "Nikolic", "nikola", "nikola123", false));
        map.put("pera", new Korisnik("Petar", "Petrovic", "pera", "pera123", false));
        map.put("stefan", new Korisnik("Stefan", "Stefanovic", "stefan", "stefan123", false));
    }

    public Korisnik(String ime, String prezime, String username, String password, boolean tip) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.tip = tip;
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

    public boolean isTip() {
        return tip;
    }

    public void setTip(boolean tip) {
        this.tip = tip;
    }
}
