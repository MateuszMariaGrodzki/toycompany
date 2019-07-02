package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Repository.CategoryRepository;
import com.toycompany.demo.Model.Repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToyController {

    @Autowired
    ToyRepository toyRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/toys")
    public String displayToys(ModelMap map){
        List<String> categories = categoryRepository.getCategoryNames();
        map.put("categories" , categories);
        return "categories";
    }


    @RequestMapping("/contact")
    public String displayOwnerInformation(){
        return "contact";
    }
}
