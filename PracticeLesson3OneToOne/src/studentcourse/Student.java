/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcourse;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author midou
 */
@Entity
@Table(name = "StudentEmbedTbl4")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    
    //@EmbeddedId
    //private StudentId studentId;
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Course course;
    private double gpa;
    @Embedded
    private Address address;
    //private History history;

    public Student() {
    }

    public Student(String name, Course course, double gpa) {
        //this.id = id;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    


    /*public Student(StudentId studentId, String name, Course course, double gpa, Address a) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
        this.address = address;
    }
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
}
