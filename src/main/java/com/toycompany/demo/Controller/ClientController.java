package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Client;
import com.toycompany.demo.Model.Repository.ClientRepository;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("aaa" ,"cis" , 213 , 1));
        toys.add(new Toy("aaa" ,"cis" , 213 , 1));
        Client client = new Client("aaa" , "aaa" , "aaa" , 213,toys);
        clientRepository.save(client);
        return "saved";
    }
}
