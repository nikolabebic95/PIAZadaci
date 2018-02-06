/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entities.Korisnik;

/**
 *
 * @author Nikola
 */
public class SkierBean {
    private String username;
    private String firstName;
    private String lastName;
    private int experience;

    public SkierBean() {
    }

    public SkierBean(Korisnik skier) {
        username = skier.getUsername();
        firstName = skier.getIme();
        lastName = skier.getPrezime();
        experience = skier.getGodSkijanja();
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
}
