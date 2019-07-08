package com.toycompany.demo.Model.Repository;

import com.toycompany.demo.Model.Toy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ToyRepository {

    private static final List<Toy> TOYS = Arrays.asList(
            new Toy("torgladiator" , "3 czesciowy tor przeszkod z wodą w środku",3000,1),
            new Toy("kosmos" , "duża zjezdzalnia" , 2500 , 0 ),
            new Toy("dzungla" , "prosty dmuchaniec" , 1500 , 2),
            new Toy("eurobungee","eurobungee",3000,3),
            new Toy("kacikmalucha", "kącik przeznaczony dla najmlodszych" , 1000, 4)
    );

    public List<Toy> getAllToys() { return  TOYS;}

    public List<String> getToysNames() {
        List<String> result = new ArrayList<>();
        for (Toy toy : TOYS) {
            result.add(toy.getName());
        }
        return result;
    }

    public String getContentByName(String name) {
        for (Toy toy: TOYS) {
            if(toy.getName().equals(name)) {
                return toy.getContent();
            }
        }
        return null;
    }

    public List<Toy> getToysByCategoryName(String categoryName) {
        List<Toy> toys = new ArrayList<>();
        CategoryRepository categoryRepository = new CategoryRepository();
        int id = categoryRepository.getIdByName(categoryName);
        for(Toy toy : TOYS){
            if(toy.getCategoryId() == id) {
                toys.add(toy);
            }
        }
        return toys;
    }

    public Toy getToyByName(String name){
        for (Toy toy : TOYS) {
            if(toy.getName().equals(name)){
                return toy;
            }
        }
        return null;
    }
}
