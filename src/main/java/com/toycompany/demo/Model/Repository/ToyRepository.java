package com.toycompany.demo.Model.Repository;

import com.toycompany.demo.Model.Toy;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ToyRepository {

    private List<Toy> toys = Arrays.asList(
            new Toy("torgladiator" , "3 czesciowy tor przeszkod z wodą w środku"),
            new Toy("kosmos" , "duża zjezdzalnia" )
    );

    public List<Toy> getAllToys() { return  toys;}

    public String getContentByName(String name) {
        for (Toy toy: toys) {
            if(toy.getName().equals(name)) {
                return toy.getContent();
            }
        }
        return null;
    }
}
