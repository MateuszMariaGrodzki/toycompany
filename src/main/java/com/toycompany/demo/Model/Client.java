package com.toycompany.demo.Model;

import javax.persistence.*;
import java.util.List;
import com.toycompany.demo.Model.Toy;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String email;
    private String date;
    private Integer phoneNumber;

    @Column
    @ElementCollection(targetClass=Toy.class)
    private List<Toy> reservedToys;

    public Client() {}

    public Client(String name, String email, String date, Integer phoneNumber, List<Toy> reservedToys) {
        this.name = name;
        this.email = email;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.reservedToys = reservedToys;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Toy> getReservedToys() {
        return reservedToys;
    }

    public void setReservedToys(List<Toy> reservedToys) {
        this.reservedToys = reservedToys;
    }
}
