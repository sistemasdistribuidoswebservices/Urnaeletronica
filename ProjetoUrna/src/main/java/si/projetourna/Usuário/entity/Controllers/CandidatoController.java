/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.Controllers;

import javax.validation.Valid;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import si.projetourna.Usuário.entity.Candidato;
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
    
    @GetMapping("/candidatos")
    public ModelAndView getCandidato(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("candidatos");
        mv.addObject("candidatolist", candidatorepository.findAll());
        return mv;
    }
    
    @GetMapping("/bunda")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("menssagem", "messagem do controller");
        return mv;
    }
    @GetMapping("/ccadastra")
    public ModelAndView cadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ccadastra");
        mv.addObject("candidato", new Candidato());
        return mv;
    }
    
    @PostMapping("/ccadastra")
    public  ModelAndView cadastra(@Valid Candidato candidatos,BindingResult result){
        ModelAndView mv = new ModelAndView();
        Candidato candidato = new Candidato(candidatos.getNome(), candidatos.getCargo(), candidatos.getPartido());
//        Candidato candidato1 =  candidatorepository.findByNome(candidato.getNome());
//        if (candidato != null){ result.rejectValue("nome", "","Candidato já cadastrado");}
//        if (result.hasErrors()) {  
//           mv.setViewName("ccadastra");
//           mv.addObject("candidato",candidato);
//        }else {
            candidatorepository.save(candidato);
            mv.setViewName("redirect:/candidatos");
       // }
        return mv;
    }
            
}

