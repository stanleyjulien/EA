/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcourse;

import javax.persistence.Embeddable;

/**
 *
 * @author midou
 */
@Embeddable
public class Address {
    private String city;
    private String state;
    private int zipCode;

    public Address() {
    }

    public Address(String city, String state, int zipCode) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    
}
