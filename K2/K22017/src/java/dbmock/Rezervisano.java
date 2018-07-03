/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbmock;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Nikola
 */
public class Rezervisano {
    private String username;
    private String naslov;
    private String status;
    private Date datum;

    public static final ArrayList<Rezervisano> lst = new ArrayList<>();

    static {
        lst.add(new Rezervisano("marko", "Braca Karamazov", "Cekanje", new GregorianCalendar(2017, 11, 24).getTime()));
        lst.add(new Rezervisano("marko", "Rat i mir", "Odobreno", new GregorianCalendar(2017, 11, 8).getTime()));
        lst.add(new Rezervisano("nikola", "Braca Karamazov", "Cekanje", new GregorianCalendar(2017, 11, 23).getTime()));
        lst.add(new Rezervisano("stefan", "Braca Karamazov", "Cekanje", new GregorianCalendar(2017, 11, 22).getTime()));
    }
    
    public Rezervisano(String username, String naslov, String status, Date datum) {
        this.username = username;
        this.naslov = naslov;
        this.status = status;
        this.datum = datum;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
