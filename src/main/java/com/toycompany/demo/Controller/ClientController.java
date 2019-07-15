package com.toycompany.demo.Controller;

import com.toycompany.demo.Configuration.WebMvcConfig;
import com.toycompany.demo.Model.Client;
import com.toycompany.demo.Model.Repository.ClientRepository;
import com.toycompany.demo.Model.Service.ClientService;
import com.toycompany.demo.Model.Repository.ToyRepository;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ClientController {
    private String date = "";

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ToyRepository toyRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("")
    public String beginReservation(ModelMap modelMap, @RequestParam String message){
        modelMap.put("message" , message);
        return "reservation";
    }
    /*
    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("aaa" ,"cis" , 213 , 1));
        toys.add(new Toy("aaa" ,"cis" , 213 , 1));
        Client client = new Client("aaa" , "02/06/2019" , "02/06/2019" , 213,toys);
        Client client2 = new Client("aaa" , "aaa" , "bbb" , 213,toys);
        Client client3 = new Client("aaa" , "aaa" , "ccc" , 213,toys);
        clientRepository.save(client);
        clientRepository.save(client2);
        clientRepository.save(client3);
        return "saved";
    }
    */


    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String testDate(@RequestParam("date") String date , RedirectAttributes redirectAttributes){
        if(! isDateAvaible(date)) {
            redirectAttributes.addAttribute("message" , "Niepoprawna data");
            return "redirect:/reservation";
        }

        if(clientService.isDateInDatabase(date)) {
            redirectAttributes.addAttribute("message" , "Termin został już zarezerwowany przez inną osobę");
            return "redirect:/reservation";
        }
        this.date = date;
        return "redirect:/reservation/user";
    }

    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    public String UserData(ModelMap modelMap){
        List<String> toyNames = toyRepository.getToysNames();
        modelMap.put("toys" , toyNames);
        return "userform";
    }

    @RequestMapping(value = "/useradd" , method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("phoneNumber") Integer phoneNumber,
                          @RequestParam("toy") String[] toys,
                          @RequestParam("hours") Integer hours){
        Client client = new Client(name , email , date , phoneNumber , getToyListFromArray(toys) , hours , bCryptPasswordEncoder.encode(password));
        clientRepository.save(client);
        return "saved";
    }

    public List<Toy> getToyListFromArray(String[] toys) {
        List<Toy> result = new ArrayList<>();
        for (String s : toys) {
            result.add(toyRepository.getToyByName(s));
        }
        return result;
    }



    public boolean isDateAvaible(String date){
        List<String> possibleDates = new ArrayList<>();
        possibleDates.add("01/06/2019");
        possibleDates.add("02/06/2019");
        possibleDates.add("07/06/2019");
        possibleDates.add("08/06/2019");
        possibleDates.add("09/06/2019");
        possibleDates.add("14/06/2019");
        possibleDates.add("15/06/2019");
        possibleDates.add("16/06/2019");
        possibleDates.add("21/06/2019");
        possibleDates.add("22/06/2019");
        possibleDates.add("23/06/2019");
        possibleDates.add("28/06/2019");
        possibleDates.add("29/06/2019");
        possibleDates.add("30/06/2019");
        possibleDates.add("05/07/2019");
        possibleDates.add("06/07/2019");
        possibleDates.add("07/07/2019");
        possibleDates.add("12/07/2019");
        possibleDates.add("13/07/2019");
        possibleDates.add("14/07/2019");
        possibleDates.add("19/07/2019");
        possibleDates.add("20/07/2019");
        possibleDates.add("21/07/2019");
        possibleDates.add("26/07/2019");
        possibleDates.add("27/07/2019");
        possibleDates.add("28/07/2019");
        possibleDates.add("02/08/2019");
        possibleDates.add("03/08/2019");
        possibleDates.add("04/08/2019");
        possibleDates.add("09/08/2019");
        possibleDates.add("10/08/2019");
        possibleDates.add("11/08/2019");
        possibleDates.add("16/08/2019");
        possibleDates.add("17/08/2019");
        possibleDates.add("18/08/2019");
        possibleDates.add("23/08/2019");
        possibleDates.add("24/08/2019");
        possibleDates.add("25/08/2019");
        possibleDates.add("30/08/2019");
        possibleDates.add("31/08/2019");
        for(String string : possibleDates){
            if(string.equals(date)) {
                return true;
            }
        }
        return false;
    }

}
