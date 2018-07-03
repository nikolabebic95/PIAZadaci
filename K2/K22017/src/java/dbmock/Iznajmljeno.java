/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbmock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Nikola
 */
public class Iznajmljeno {
    private String username;
    private String naslov;
    private Date datumOd;
    private Date datumDo;

    public static final ArrayList<Iznajmljeno> lst = new ArrayList<>();
    static {
        lst.add(new Iznajmljeno("marko", "Rat i mir", new GregorianCalendar(2017, 11, 9).getTime(), new GregorianCalendar(2018, 11, 29).getTime()));
        lst.add(new Iznajmljeno("marko", "Zlocin i kazna", new GregorianCalendar(2017, 11, 9).getTime(), new GregorianCalendar(2017, 11, 29).getTime()));
        lst.add(new Iznajmljeno("pera", "Ana Karenjina", new GregorianCalendar(2017, 11, 10).getTime(), new GregorianCalendar(2017, 11, 30).getTime()));
        lst.add(new Iznajmljeno("pera", "Prokleta avlija", new GregorianCalendar(2017, 11, 4).getTime(), new GregorianCalendar(2017, 11, 24).getTime()));
        lst.add(new Iznajmljeno("pera", "Rat i mir", new GregorianCalendar(2017, 11, 10).getTime(), new GregorianCalendar(2018, 11, 30).getTime()));
    }
    
    public Iznajmljeno(String username, String naslov, Date datumOd, Date datumDo) {
        this.username = username;
        this.naslov = naslov;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
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

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }
}
