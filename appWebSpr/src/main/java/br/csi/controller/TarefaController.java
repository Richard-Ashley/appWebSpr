/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.TarefaDAO;
import br.csi.modelo.Tarefa;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




/**
 * Galera, quando vocês utilizarem o requestMapping junto do controller, suas ações seguintes ficaram na raiz /tarefas
 * EX1: http://localhost:8080/appWebSpr/tarefas/tarefasEditar?id=3    PARA LISTAR TAREFAS (METODO GET)
 * EX2: http://localhost:8080/appWebSpr/tarefas/tarefasEditar?id=3    PARA EDITAR TAREFAS
 * 
 * sendo assim, é possivel setar o metodo que sera usado, para listar e salvar (get, post)
 * dessa forma fica mais organizado. Mas sempre relembrando, cada um faz da forma que preferir
 * 
 */

//REQUEST MAPPING NA CLASSE CONTROLLER, OUTRA FORMA DE SE MAPEAR AS REQUISIÇÕES
@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    TarefaDAO daoT;

    //SEM CAMINHO = USANDO METODO GET = NO BROWSER FICA O CAMINHO DEFINIDO ACIMA NO CONTROLER (/TAREFA)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listarTarefas(){
        
        ModelAndView modelAndView = new ModelAndView("tarefas-gerenciar");
        try {
            modelAndView.addObject("tarefas", daoT.getTarefas());
        } catch (Exception e) {            
        }        
        return modelAndView;
    }

    //FUNÇÃO RETORNANDO STRING
    @RequestMapping(value = {"/tarefasEditar"})
    public String editar(@RequestParam int id, Model model) throws Exception {        
        model.addAttribute("tarefa", daoT.getTarefa(id));
        return "forward:/tarefas";
    }

     //FUNÇÃO RETORNANDO OBJETO CRIADO E GERENCIADO PELO SPRING (ModelAndView)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Tarefa tarefa, BindingResult result) {

        if(result.hasErrors()) {              
             return listarTarefas();
        }
        
        try {
            if (tarefa.getId() != null) {
                daoT.atualizar(tarefa);
            } else {
                daoT.inserir(tarefa);
            }
        } catch (Exception e) {

        }
        
        ModelAndView mv = new ModelAndView("redirect:tarefas");        

        return mv;
    }

}
