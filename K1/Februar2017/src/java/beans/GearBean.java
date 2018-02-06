/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entities.Skioprema;

/**
 *
 * @author Nikola
 */
public class GearBean {
    private int id;
    private String name;
    private String type;
    private int number;
    private Double size;
    private double price;
    private boolean hasSize;

    public GearBean() {
    }
    
    public GearBean(Skioprema gear) {
        id = gear.getIdopreme();
        name = gear.getNaziv();
        type = gear.getVrsta();
        number = gear.getKolicina();
        size = gear.getVelicina();
        price = gear.getCenapodanu();
        hasSize = size != null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getHasSize() {
        return hasSize;
    }

    public void setHasSize(boolean hasSize) {
        this.hasSize = hasSize;
    }
}
