package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Client;
import com.toycompany.demo.Model.Repository.ToyRepository;
import com.toycompany.demo.Model.Service.ClientService;
import com.toycompany.demo.Model.Service.CurrencyService;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.DecimalFormat;
import java.util.List;

@Controller
@RequestMapping("/login")
public class ClientLoginController {

    @Autowired
    ClientService clientService;

    @Autowired
    ToyRepository toyRepository;

    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/{email}")
    public String showOptionsForClient(@PathVariable String email, ModelMap modelMap){
        Client client = clientService.getClientByEmail(email);
        modelMap.put("client" , client);
        return "clientOptions";
    }
    @RequestMapping("/{email}/showreservation")
    public String showReservationForClient(@PathVariable String email, ModelMap modelMap) {
        Client client = clientService.getClientByEmail(email);
        modelMap.put("client" , client);
        List<Toy> toys = clientService.getToysByClientEmail(email);
        modelMap.put("toys" , toys);
        int hireCost = toyRepository.calculatePricePerHours(toys) * client.getHours();
        modelMap.put("hirecost" , hireCost);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        String hireCostinDolars = String.format("%.2f" ,hireCost * ( 1 / currencyService.getCurrency("usd").getRates().get(0).getBid()));
        modelMap.put("usd" , hireCostinDolars);
        String hireCostInEuro = String.format("%.2f", hireCost * (1 / currencyService.getCurrency("eur").getRates().get(0).getBid()));
        modelMap.put("eur" , hireCostInEuro);
        return "viewClientForClient";
    }


    @RequestMapping("/{name}/deletereservation")
    public String deleteReservationByClient(@PathVariable String name) {
        clientService.deleteClientByName(name);
        return "deleted";
    }
}
