package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Client;
import com.toycompany.demo.Model.Service.ClientService;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/admin")
public class AdminController {
    @Autowired
    ClientService clientService;

    @RequestMapping("")
    public String adminHome(ModelMap modelMap){
        List<String> clientEmails = clientService.getAllEmails();
        modelMap.put("clientsEmails" , clientEmails);
        return "adminHome";
    }

    @RequestMapping("/{email}")
    public String showUserDetails(@PathVariable String email, ModelMap modelMap){
        Client client = clientService.getClientByEmail(email);
        modelMap.put("client" , client);
        List<Toy> toys = clientService.getToysByClientEmail(email);
        modelMap.put("toys" , toys);
        return "viewClientForAdmin";
    }
    
}
