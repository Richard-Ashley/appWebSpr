
package br.csi.controller;

import br.csi.dao.RecomendaDAO;
import br.csi.modelo.Filme;
import br.csi.modelo.Usuario;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class RecomendacaoController {
    
    
    @RequestMapping("recomendacao")
    public String paginaRecomendacao(HttpSession session, Model model) throws IOException, TasteException {

        System.out.println("foi no recomendaÃ§Ã£o");

        RecomendaDAO dao = new RecomendaDAO();

        Usuario autenticado = (Usuario) session.getAttribute("usuarioLogado");

        System.out.println("usuario logado: " + autenticado.getCodigo());

        //model.addAttribute("recomendacao",dao.recomenda(usuarioAutenticado));

        return "trabRecomendacao/paginaRecomendacao";

    }

    @RequestMapping("recomendarItens")//usado no java script pra lista todas as solicitacoes
    public ResponseEntity<ArrayList<Filme>> exibirTodasSolicitacoes(HttpSession session) throws TasteException, IOException {

        Usuario autenticado = (Usuario) session.getAttribute("usuarioLogado");
        System.out.println("usuario logado: " + autenticado.getLogin());

        return new ResponseEntity<ArrayList<Filme>>((ArrayList<Filme>) new RecomendaDAO().recomenda(autenticado.getCodigo()), HttpStatus.OK);

    }
    @RequestMapping("darNota" )
    public String darNota(@RequestBody Filme filme, HttpSession session) throws IOException {

        Usuario autenticado = (Usuario) session.getAttribute("usuarioLogado");
        filme.setIdUsuario(String.valueOf(autenticado.getCodigo()));
        System.out.println("filme: " + filme);

        RecomendaDAO dao = new RecomendaDAO();
        dao.salvaNota(filme);

        return "ok";
    }
    
}
