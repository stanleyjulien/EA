/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myentity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author midou
 */
@Entity
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
            
    private double gpa;
    private List<Notebook> notebook;
    
    public Student()
    {
        
    }
    
    public Student(String name, double gpa)
    {
        this.setName(name);
        this.gpa = gpa;
    }
    
    public Student(List<Notebook> notebook)
    {
        this.notebook = notebook;
    }
    
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<Notebook> getNotebook() {
        return notebook;
    }

    public void setNotebook(List<Notebook> notebook) {
        this.notebook = notebook;
    }
    
    
}
