/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


/**
 *
 * @author Re
 */

@Controller
public class PrimeiroController {        
    
    @RequestMapping("home")
    public String home(){       
        return "index";
    }    
    
    @RequestMapping({"","/"})
    public String i2(){       
        return "redirect:home";
    } 
    
    //@RequestMapping(value = {"","/"})
    public RedirectView inicial(){         
        return new RedirectView("home", true);
    }
    
    @RequestMapping("/primeiroControlador")
    public String executar(){
        System.out.println("Executou a logica");
        
        return "pagina";
    }
    
}
