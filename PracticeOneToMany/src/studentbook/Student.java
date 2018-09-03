/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentbook;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author midou
 */
@Entity
//@Table(name = "StudentEmbedTbl4")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name = "IdBook")
    private List<Book> books = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
    
    public void addBook(Book book)
    {
        books.add(book);
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", books=" + books + '}';
    }

    
    
    
}
