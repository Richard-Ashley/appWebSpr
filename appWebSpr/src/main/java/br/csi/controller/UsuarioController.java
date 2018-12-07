/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.UsuarioDAO;
import br.csi.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author Re
 */

@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioDAO dao;     
  
    @RequestMapping("usuarioLogar")    
    public String autenticar(Usuario usuario, Model model){    
                        
        try {            
            if(dao.autenticado(usuario)){
                model.addAttribute("usuarioLogado",usuario);
                return "dashboard";
            }else{
                model.addAttribute("retorno","usuário não logado");
                return "index";
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return "index";
    }
}
