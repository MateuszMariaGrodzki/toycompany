package com.toycompany.demo.Controller;

import com.toycompany.demo.Model.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ClientService clientService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("")
    public String loginview(@RequestParam String message, ModelMap modelMap){
        modelMap.put("message",message);
        return "login";
    }

    @RequestMapping("/check")
    public String check(@RequestParam("email") String email ,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {
        if(email.equals("admin") && password.equals("admin")) {
            return "redirect:/admin/" + password;
        }

        if(!clientService.isEmailInDatabase(email)) {
            redirectAttributes.addAttribute("message" , "Nie ma takiego email w bazie danych");
            return "redirect:/login";
        }

        if( ! bCryptPasswordEncoder.matches(password , clientService.getPasswordByEmail(email)) ) {
            redirectAttributes.addAttribute("message" , "Błędne hasło");
            return "redirect:/login";
        }
        String name = clientService.getNameByEmail(email);
        return  "redirect:/login/" + name;
    }
}
