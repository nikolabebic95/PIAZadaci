/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.*;
import java.util.*;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Milica
 */
@ManagedBean(name = "user")
@SessionScoped
public class User {
    private String username;
    private String password;
    private String type;
    private String errorMessage = "";
    private String infoMessage = "";
    
    private String firstName;
    private String lastName;
    private int experience;
    private boolean wantLessons;
    
    private List<Skioprema> searched;
    private boolean[] checked;
    private Date returnDate;
    private ArrayList<Iznajmljivanje> rented;
    
    private List<Korisnik> groupA;
    private List<Korisnik> groupB;
    private List<Korisnik> groupC;
    private boolean groupAchecked;
    private boolean groupBchecked;
    private boolean groupCchecked;

    private Collection<SelectItem> possibleTypes = new ArrayList<>();
    
    {
        possibleTypes.add(new SelectItem("Polaznik"));
        possibleTypes.add(new SelectItem("Instruktor"));
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public Collection<SelectItem> getPossibleTypes() {
        return possibleTypes;
    }

    public void setPossibleTypes(Collection<SelectItem> possibleTypes) {
        this.possibleTypes = possibleTypes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isWantLessons() {
        return wantLessons;
    }

    public void setWantLessons(boolean wantLessons) {
        this.wantLessons = wantLessons;
    }
    
    public boolean hasError(){
        return !this.errorMessage.equals("");
    }

    public List<Skioprema> getSearched() {
        return searched;
    }

    public void setSearched(List<Skioprema> searched) {
        this.searched = searched;
    }

    public boolean[] getChecked() {
        return checked;
    }

    public void setChecked(boolean[] checked) {
        this.checked = checked;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public ArrayList<Iznajmljivanje> getRented() {
        return rented;
    }

    public void setRented(ArrayList<Iznajmljivanje> rented) {
        this.rented = rented;
    }

    public List<Korisnik> getGroupA() {
        return groupA;
    }

    public void setGroupA(List<Korisnik> groupA) {
        this.groupA = groupA;
    }

    public List<Korisnik> getGroupB() {
        return groupB;
    }

    public void setGroupB(List<Korisnik> groupB) {
        this.groupB = groupB;
    }

    public List<Korisnik> getGroupC() {
        return groupC;
    }

    public void setGroupC(List<Korisnik> groupC) {
        this.groupC = groupC;
    }

    public boolean isGroupAchecked() {
        return groupAchecked;
    }

    public void setGroupAchecked(boolean groupAchecked) {
        this.groupAchecked = groupAchecked;
    }

    public boolean isGroupBchecked() {
        return groupBchecked;
    }

    public void setGroupBchecked(boolean groupBchecked) {
        this.groupBchecked = groupBchecked;
    }

    public boolean isGroupCchecked() {
        return groupCchecked;
    }

    public void setGroupCchecked(boolean groupCchecked) {
        this.groupCchecked = groupCchecked;
    }

    public String login(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SkiSkolica2017PU");
        EntityManager em = emf.createEntityManager();
        
        this.errorMessage = "";
        
        List<Object> result = em.createNamedQuery("Korisnik.findByUsername").setParameter("username", this.username).getResultList();
        
        if(result.isEmpty()){
            this.errorMessage = "Invalid username!";
            this.username = "";
            return "index";
        }
        
        Korisnik korisnik = (Korisnik)result.get(0);
        if(!korisnik.getPassword().equals(this.password)){
            this.errorMessage = "Invalid password!";
            this.password = "";
            return "index";
        }
        else{
            if(korisnik.getJeInstruktor() != (this.type.equals("Polaznik") ? 0 : 1)){
                this.errorMessage = "Invalid type!";
                return "index";
            }
        }
        
        this.firstName = korisnik.getIme();
        this.lastName = korisnik.getPrezime();
        this.experience = korisnik.getGodSkijanja();
        this.wantLessons = korisnik.getZelimCasove();
        
        if(type.equals("Polaznik")){
            this.rented = new ArrayList<>();
            List<Iznajmljivanje> itemsEverRented = em.createNamedQuery("Iznajmljivanje.findByIdKorisnik", Iznajmljivanje.class).setParameter("idkorisnik", this.username).getResultList();
            for(int i = 0; i < itemsEverRented.size(); i++){
                if(!itemsEverRented.get(i).getRazduzeno())
                    this.rented.add(itemsEverRented.get(i));
            }
            
            return "polaznik";
        }
        else{
            List<Korisnik> lessonsGroup = em.createNamedQuery("Korisnik.findByZelimCasove", Korisnik.class).setParameter("zelimCasove", true).getResultList();
            this.groupA = new ArrayList<>();
            this.groupAchecked = false;
            this.groupB = new ArrayList<>();
            this.groupBchecked = false;
            this.groupC = new ArrayList<>();
            this.groupCchecked = false;
            
            for(int i = 0; i < lessonsGroup.size(); i++){
                if(lessonsGroup.get(i).getGodSkijanja() == 0){
                    groupA.add(lessonsGroup.get(i));
                }
                else if(lessonsGroup.get(i).getGodSkijanja() >= 1 &&lessonsGroup.get(i).getGodSkijanja() <= 3){
                    groupB.add(lessonsGroup.get(i));
                }
                else{
                    groupC.add(lessonsGroup.get(i));
                }
            }
            
            return "instruktor";
        }
    }
    
    public String search(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String name = request.getParameter("search:name");
        String type = request.getParameter("search:type");
        
        this.search(name, type);
        
        return "polaznik";
    }
    
    private void search(String name, String type){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SkiSkolica2017PU");
        EntityManager em = emf.createEntityManager();
        
        if(name.equals("") && type.equals("")){
            this.populateSearched(em.createNamedQuery("Skioprema.findAll").getResultList());
        }
        else if(name.equals("")){
            this.populateSearched(em.createNamedQuery("Skioprema.findByVrsta").setParameter("vrsta", type).getResultList());
        }
        else if(type.equals("")){
            this.populateSearched(em.createNamedQuery("Skioprema.findByNaziv").setParameter("naziv", name).getResultList());
        }
        else{
            this.populateSearched(em.createNamedQuery("Skioprema.findByNazivAndVrsta").setParameter("naziv", name).setParameter("vrsta", type).getResultList());
        }
    }
    
    private void populateSearched(List<Skioprema> searched){
        this.searched = searched;
        this.checked = new boolean[this.searched.size()];
    }
    
    public String reserve(){
        System.out.println(this.checked[0]);
        System.out.println(this.checked[1]);
        System.out.println(this.returnDate.getTime());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SkiSkolica2017PU");
        EntityManager em = emf.createEntityManager();
        
        ArrayList<Skioprema> reserved = new ArrayList<>();
        for(int i = 0; i < this.checked.length; i++){
            if(this.checked[i])
                reserved.add(this.searched.get(i));
        }
        
        if(reserved.size() > 0){
            ArrayList<Iznajmljivanje> rented = new ArrayList<>();
            double discount = (reserved.size() >= 3 ? 0.8 : 1);
            Date currentDate = new Date();
            long numOfDays = (this.returnDate.getTime() - currentDate.getTime()) / (3600 * 24 * 1000);
            double fullDeposit = 0;
            double fullPrice = 0;
            
            ArrayList<Skioprema> equipment = new ArrayList<>();
            
            for(int i = 0; i < reserved.size(); i++){
                Iznajmljivanje newRent = new Iznajmljivanje();
                newRent.setIdkorisnik(em.find(Korisnik.class, this.username));
                newRent.setIdopreme(reserved.get(i));
                newRent.setImapopust(reserved.size() >= 3);
                newRent.setRazduzeno(false);
                newRent.setUkupnoNaplata(null);
                
                double price = numOfDays * reserved.get(i).getCenapodanu() * discount;
                double deposit = price * 0.3;
                fullDeposit += deposit;
                fullPrice += price;
                
                newRent.setDepozit((int)deposit);
                newRent.setDatumpreuz(currentDate);
                newRent.setPlaniranovracanje(this.returnDate);
                
                rented.add(newRent);
                
                Skioprema item = em.find(Skioprema.class, reserved.get(i).getIdopreme());
                equipment.add(item);
            }
        
            em.getTransaction().begin();
            for(int i = 0; i < rented.size(); i++){
                em.persist(rented.get(i));
            }
            for(int i = 0; i < equipment.size(); i++){
                equipment.get(i).setKolicina(equipment.get(i).getKolicina() - 1);
            }
            em.getTransaction().commit();
            
            this.infoMessage = "Renting done! Deposit is " + fullDeposit + ", estimated full price is " + fullPrice;
            
            this.rented = new ArrayList<>();
            List<Iznajmljivanje> itemsEverRented = em.createNamedQuery("Iznajmljivanje.findByIdKorisnik", Iznajmljivanje.class).setParameter("idkorisnik", this.username).getResultList();
            for(int i = 0; i < itemsEverRented.size(); i++){
                if(!itemsEverRented.get(i).getRazduzeno())
                    this.rented.add(itemsEverRented.get(i));
            }
            
            this.searched.clear();
        }
        else{
            this.infoMessage = "Choose items";
        }
        
        return "polaznik";
    }
    
    public String finishRenting(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SkiSkolica2017PU");
        EntityManager em = emf.createEntityManager();
        
        this.rented = new ArrayList<>();
        List<Iznajmljivanje> itemsEverRented = em.createNamedQuery("Iznajmljivanje.findByIdKorisnik", Iznajmljivanje.class).setParameter("idkorisnik", this.username).getResultList();
        for(int i = 0; i < itemsEverRented.size(); i++){
            if(!itemsEverRented.get(i).getRazduzeno())
                this.rented.add(itemsEverRented.get(i));
        }
        
        int toBePaid = 0;
        
        em.getTransaction().begin();
        for(int i = 0; i < this.rented.size(); i++){
            Date currentDate = new Date();
            long numOfDays = (currentDate.getTime() - this.rented.get(i).getDatumpreuz().getTime()) / (24 * 3600 * 1000);
            double discount = this.rented.get(i).getImapopust() ? 0.8 : 1;
            double price = numOfDays * this.rented.get(i).getIdopreme().getCenapodanu() * discount;
            this.rented.get(i).setUkupnoNaplata(price);
            this.rented.get(i).setRazduzeno(true);
            toBePaid += price - this.rented.get(i).getDepozit();
            
            Skioprema item = em.find(Skioprema.class, this.rented.get(i).getIdopreme().getIdopreme());
            item.setKolicina(item.getKolicina() + 1);
        }
        em.getTransaction().commit();
        
        this.infoMessage = "Total: " + toBePaid;
        return "polaznik";
    }
    
    public String completeTraining(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SkiSkolica2017PU");
        EntityManager em = emf.createEntityManager();
        
        List<Korisnik> lessonsGroup = em.createNamedQuery("Korisnik.findByZelimCasove", Korisnik.class).setParameter("zelimCasove", true).getResultList();
        this.groupA = new ArrayList<>();
        this.groupB = new ArrayList<>();
        this.groupC = new ArrayList<>();

        for(int i = 0; i < lessonsGroup.size(); i++){
            if(lessonsGroup.get(i).getGodSkijanja() == 0){
                groupA.add(lessonsGroup.get(i));
            }
            else if(lessonsGroup.get(i).getGodSkijanja() >= 1 &&lessonsGroup.get(i).getGodSkijanja() <= 3){
                groupB.add(lessonsGroup.get(i));
            }
            else{
                groupC.add(lessonsGroup.get(i));
            }
        }
        
        em.getTransaction().begin();
        if(this.groupAchecked){
            System.out.println("a checked");
            for(int i = 0; i < this.groupA.size(); i++){
                this.groupA.get(i).setGodSkijanja(this.groupA.get(i).getGodSkijanja() + 1);
            }
        }
        if(this.groupBchecked){
            for(int i = 0; i < this.groupB.size(); i++){
                this.groupB.get(i).setGodSkijanja(this.groupB.get(i).getGodSkijanja() + 1);
            }
        }
        if(this.groupCchecked){
            for(int i = 0; i < this.groupC.size(); i++){
                this.groupC.get(i).setGodSkijanja(this.groupC.get(i).getGodSkijanja() + 1);
            }
        }
        em.getTransaction().commit();
        
        return "instruktor";
    }
    
    public String changeInterest(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SkiSkolica2017PU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Korisnik user = em.find(Korisnik.class, this.username);
        user.setZelimCasove(!user.getZelimCasove());
        em.getTransaction().commit();
        
        this.wantLessons = !this.wantLessons;
        
        return "polaznik";
    }
}
