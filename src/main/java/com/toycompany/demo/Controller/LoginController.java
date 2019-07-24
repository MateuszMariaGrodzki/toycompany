package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    @Autowired
    ClientService clientService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/log")
    public String loginview(){
        return "login";
    }

    @RequestMapping("/logi")
    public String check(@RequestParam("email") String email) {
        if(email.equals("admin")) {
            return "redirect:/admin/admin";
        }
        return "redirect:/login/" + email;
    }
}
