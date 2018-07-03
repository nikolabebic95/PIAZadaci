/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import dbmock.Iznajmljeno;
import dbmock.Knjige;
import dbmock.Korisnik;
import dbmock.Rezervisano;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Nikola
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private String username;
    private String password;
    private String loginErrorMessage;
    private boolean loggedIn;
    private Korisnik korisnik;
    private ArrayList<Knjige> books;
    private ArrayList<Boolean> expired;

    private String bookName;
    private String authorName;
    private ArrayList<Knjige> searched;
    
    private ArrayList<Rezervisano> requests;
    
    @PostConstruct
    public void init() {
        books = new ArrayList<>();
        expired = new ArrayList<>();
        searched = new ArrayList<>();
        requests = new ArrayList<>();
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

    public String getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public void setLoginErrorMessage(String loginErrorMessage) {
        this.loginErrorMessage = loginErrorMessage;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public ArrayList<Knjige> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Knjige> books) {
        this.books = books;
    }

    public ArrayList<Boolean> getExpired() {
        return expired;
    }

    public void setExpired(ArrayList<Boolean> expired) {
        this.expired = expired;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public ArrayList<Knjige> getSearched() {
        return searched;
    }

    public void setSearched(ArrayList<Knjige> searched) {
        this.searched = searched;
    }

    public ArrayList<Rezervisano> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Rezervisano> requests) {
        this.requests = requests;
    }
    
    private void renderLibrarian() {
        requests.clear();
        for (Rezervisano r : Rezervisano.lst) {
            if (r.getStatus().equals("Cekanje")) {
                requests.add(r);
            }
        }
    }
    
    private void renderMember() {
        books.clear();
        expired.clear();

        Date today = new Date();

        for (Iznajmljeno i : Iznajmljeno.lst) {
            if (i.getUsername().equals(username)) {
                Knjige b = Knjige.map.get(i.getNaslov());                    
                books.add(b);
                if (today.after(i.getDatumDo())) {
                    expired.add(true);
                } else {
                    expired.add(false);
                }
            }                
        }
    }
    
    private String render() {
        if (korisnik.isTip()) {
            renderLibrarian();
            return "librarian";
        } else {
            renderMember();
            return "member";
        }
    }
    
    public String login() {
        if (!Korisnik.map.containsKey(username)) {
            loginErrorMessage = "User does not exist";
            username = "";
            return "index";
        }
        
        Korisnik k = Korisnik.map.get(username);
        if (!k.getPassword().equals(password)) {
            loginErrorMessage = "Password not correct";
            return "index";
        }
        
        loggedIn = true;
        korisnik = k;
        
        return render();
    }
    
    public String searchBook() {
        if (!loggedIn) return "index";
        
        searched.clear();
        
        for (Knjige k : Knjige.map.values()) {
            if (bookName != null && !bookName.equals("") && !bookName.equals(k.getNaslov())) continue;
            if (authorName != null && !authorName.equals("") && !authorName.equals(k.getAutor())) continue;
            
            searched.add(k);
        }
        
        return "search";
    }
    
    public String reserve(int index) {
        if (!loggedIn) return "index";
        
        Knjige k = searched.get(index);
        Rezervisano r = new Rezervisano(username, k.getNaslov(), "Cekanje", new Date());
        Rezervisano.lst.add(r);
        
        return "member";
    }
    
    public String grantRequest(int index) {
        if (!loggedIn) return "index";
        
        Rezervisano r = requests.get(index);
        Rezervisano.lst.remove(r);
        
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, 20);
        Date after = c.getTime();
        
        Iznajmljeno i = new Iznajmljeno(r.getUsername(), r.getNaslov(), today, after);
        Iznajmljeno.lst.add(i);
        
        return render();
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
}
