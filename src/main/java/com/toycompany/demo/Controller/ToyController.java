package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Repository.ToyRepository;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToyController {

    @Autowired
    ToyRepository toyRepository;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/toys")
    public String displayToys(ModelMap map){
        List<Toy> toys = toyRepository.getAllToys();
        map.put("toys" , toys);
        return "toys";
    }

    @RequestMapping("/toy/{name}")
    @ResponseBody
    public String displayToy(@PathVariable String name){
        String result = toyRepository.getContentByName(name);
        return result;
    }

    @RequestMapping("/contact")
    public String displayOwnerInformation(){
        return "contact";
    }
}
