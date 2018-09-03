/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexampractice1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author midou
 */
@Entity
public class Roles {
    @Id
    @Column(name = "roleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    /*
    @JoinTable
        ( name = "UserRole",
            joinColumns = {@JoinColumn(name = "roleid", referencedColumnName = "roleid")},
            inverseJoinColumns = {@JoinColumn(name = "userid", referencedColumnName = "userid")}
    )*/
    
    @ManyToMany(mappedBy = "userroles") 
    List<User> users = new ArrayList<>();

    public Roles() {
    }

    public Roles(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
    
    public void addUser(User user)
    {
        users.add(user);
    }
}
