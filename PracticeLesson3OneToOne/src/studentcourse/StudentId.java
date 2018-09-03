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
public class StudentId {
    private int ssn;
    private String firstName;
    private String lastName;

    public StudentId() {
    }

    public int getSsn() {
        return ssn;
    }

    public StudentId(int ssn, String firstName, String lastName) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
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
}
