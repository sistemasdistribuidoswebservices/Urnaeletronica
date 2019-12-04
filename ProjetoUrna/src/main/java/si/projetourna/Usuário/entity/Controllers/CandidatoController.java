/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import si.projetourna.Usuário.entity.repository.CandidatoRepository;

/**
 *
 * @author Alvaro
 */

@Controller
public class CandidatoController {
    private CandidatoRepository candidatorepository;

    public CandidatoController(CandidatoRepository candidatorepository) {
        this.candidatorepository = candidatorepository;
    }
    
    @RequestMapping("/user")
    public String getCandidato(Model model){
        model.addAllAttributes();   
        return "user";
    }
    
}
