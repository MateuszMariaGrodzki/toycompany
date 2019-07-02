package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Repository.ToyRepository;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ToyRepository toyRepository;

    @RequestMapping("/{name}")
    public String printToysByCategory(@PathVariable String name, ModelMap modelMap){
        List<Toy> toys = new ArrayList<>();
        toys = toyRepository.getToysByCategoryName(name);
        modelMap.put("toys" , toys);
        return "category";
    }

    @RequestMapping("/toy/{name}")
    public String printToy(@PathVariable String name , ModelMap modelMap){
        Toy toy = toyRepository.getToyByName(name);
        modelMap.put("toy" , toy);
        return "toy";
    }
}



