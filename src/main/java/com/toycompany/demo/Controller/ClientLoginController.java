package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Client;
import com.toycompany.demo.Model.Repository.ToyRepository;
import com.toycompany.demo.Model.Service.ClientService;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/login")
public class ClientLoginController {

    @Autowired
    ClientService clientService;

    @Autowired
    ToyRepository toyRepository;

    @RequestMapping("/{name}")
    public String showOptionsForClient(@PathVariable String name, ModelMap modelMap){
        Client client = clientService.getClientByName(name);
        modelMap.put("client" , client);
        return "clientOptions";
    }
    @RequestMapping("/{name}/showreservation")
    public String showReservationForClient(@PathVariable String name, ModelMap modelMap) {
        Client client = clientService.getClientByName(name);
        modelMap.put("client" , client);
        List<Toy> toys = clientService.getToysByClientName(name);
        modelMap.put("toys" , toys);
        int hireCost = toyRepository.calculatePricePerHours(toys) * client.getHours();
        modelMap.put("hirecost" , hireCost);
        return "viewClientForClient";
    }


    @RequestMapping("/{name}/deletereservation")
    public String deleteReservationByClient(@PathVariable String name) {
        clientService.deleteClientByName(name);
        return "deleted";
    }
}
