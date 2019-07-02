package com.toycompany.demo.Model.Repository;

import com.toycompany.demo.Model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORY = Arrays.asList(
            new Category(0,"Zjezdzalnie"),
            new Category(1,"Tory przeszkód"),
            new Category(2,"Dmuchane zamki do skakania"),
            new Category(3,"Eurobungee"),
            new Category(4 , "Dla najmlodszych")
    );

    public List<Category> getAllCategory() {return ALL_CATEGORY;}

    public String getNameById(int id) {
        for (Category category : ALL_CATEGORY){
            if(category.getId() == id) {
                return category.getName();
            }
        }
        return null;
    }

    public int getIdByName(String name) {
        for(Category category : ALL_CATEGORY){
            if(category.getName().equals(name)) {
                return category.getId();
            }
        }
        return 0;
    }

    public List<String> getCategoryNames(){
        List<String> result = new ArrayList<>();
        for (Category category:ALL_CATEGORY) {
            result.add(category.getName());
        }
        return result;
    }

}
