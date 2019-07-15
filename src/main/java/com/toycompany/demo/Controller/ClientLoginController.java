package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Client;
import com.toycompany.demo.Model.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class ClientLoginController {

    @Autowired
    ClientService clientService;

    @RequestMapping("/{name}")
    public String showOptionsForClient(@PathVariable String name, ModelMap modelMap){
        Client client = clientService.getClientByName(name);
        modelMap.put("client" , client);
        return "clientOptions";
    }
    @ResponseBody
    @RequestMapping("/{name}/showreservation")
    public String showReservationForClient(@PathVariable String name) {
        return "tutaj beda informacje o reserwacji";
    }

    @ResponseBody
    @RequestMapping("/{name}/deletereservation")
    public String deleteReservationByClient(@PathVariable String name) {
        return "tutaj będzie mozliwość usunięcia reserwacji";
    }
}
