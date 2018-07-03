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
public class Knjige {
    private String naslov;
    private String autor;
    private int kolicina;

    public static final HashMap<String, Knjige> map = new HashMap<>();
    static {
        map.put("Ana Karenjina", new Knjige("Ana Karenjina", "Lav Tolstoj", 9));
        map.put("Braca Karamazov", new Knjige("Braca Karamazov", "Fjodor Dostojevski",3));
        map.put("Dervis i smrt", new Knjige("Dervis i smrt", "Mesa Selimovic", 1));
        map.put("Necista krv", new Knjige("Necista krv", "Bora Stankovic", 2));
        map.put("Prokleta avlija", new Knjige("Prokleta avlija", "Ivo Andric", 7));
        map.put("Rat i mir", new Knjige("Rat i mir", "Lav Tolstoj", 5));
        map.put("Zlocin i kazna", new Knjige("Zlocin i kazna", "Fjodor Dostojevski", 6));
    }
    
    public Knjige(String naslov, String autor, int kolicina) {
        this.naslov = naslov;
        this.autor = autor;
        this.kolicina = kolicina;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
}
