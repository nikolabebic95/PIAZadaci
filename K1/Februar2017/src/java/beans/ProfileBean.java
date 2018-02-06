/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entities.Korisnik;
import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public class ProfileBean {
    private String username;
    private String firstName;
    private String lastName;
    private int experience;
    private boolean wantsClasses;
    private boolean isInstructor;

    private double paid;
    private boolean shouldShowPaid;
    
    private ArrayList<GearBean> list = new ArrayList<>();
    
    public ProfileBean() {
    }
    
    public ProfileBean(Korisnik user) {
        username = user.getUsername();
        firstName = user.getIme();
        lastName = user.getPrezime();
        experience = user.getGodSkijanja();
        wantsClasses = user.getZelimCasove();
        isInstructor = user.getJeInstruktor() != 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean getWantsClasses() {
        return wantsClasses;
    }

    public void setWantsClasses(boolean wantsClasses) {
        this.wantsClasses = wantsClasses;
    }

    public boolean getIsInstructor() {
        return isInstructor;
    }

    public void setIsInstructor(boolean isInstructor) {
        this.isInstructor = isInstructor;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public boolean getShouldShowPaid() {
        return shouldShowPaid;
    }

    public void setShouldShowPaid(boolean shouldShowPaid) {
        this.shouldShowPaid = shouldShowPaid;
    }

    public ArrayList<GearBean> getList() {
        return list;
    }

    public void setList(ArrayList<GearBean> list) {
        this.list = list;
    }
    
    public void add(GearBean gearBean) {
        list.add(gearBean);
    }
    
    public void resetGear() {
        setList(new ArrayList<>());
    }
}
