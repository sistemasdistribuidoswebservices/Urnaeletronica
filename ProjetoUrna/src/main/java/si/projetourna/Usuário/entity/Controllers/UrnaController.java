/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.Controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import si.projetourna.Usuário.entity.Candidato;
import si.projetourna.Usuário.entity.Eleitor;
import si.projetourna.Usuário.entity.Urna;
import si.projetourna.Usuário.entity.Votos;
import si.projetourna.Usuário.entity.repository.CandidatoRepository;
import si.projetourna.Usuário.entity.repository.EleitorRepository;
import si.projetourna.Usuário.entity.repository.UrnaRepository;
import si.projetourna.Usuário.entity.repository.Votosrepository;

/**
 *
 * @author Alvaro
 */

@Controller
public class UrnaController {
    private UrnaRepository urnarepository;
    private EleitorRepository elerepo;
    private CandidatoRepository canrepo;
    private Votosrepository votosrepo;
    
    public UrnaController(UrnaRepository urnarepository,EleitorRepository elerepo,CandidatoRepository canrepo, Votosrepository votosrepo){
        this.urnarepository =  urnarepository;
        this.elerepo  = elerepo;
        this.canrepo = canrepo;
        this.votosrepo = votosrepo;
    }
    
    /**
     * cadastro de eleitor
     * puxa página do eleitor.
     * @param id
     * @return 
     */
    @GetMapping("/urna/registra/{id}")
    public ModelAndView ucadastra(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView();
        if(urnarepository.existsById(id)){
            mv.setViewName("urna/pvotou");
            mv.addObject("eleitor", id);
            
            
        }
        else {
            
            mv.setViewName("urna/registra");
            mv.addObject("urna", new Urna());
            mv.addObject("candidatolist", canrepo.findAll());
            mv.addObject("eleitor", id);
        }
        return mv;
    }
    
    @PostMapping("/urna/cadastra/{ele}/{can}")
    public  ModelAndView ucadastra(@PathVariable("ele") Long ele,@PathVariable("can") Long can){
        ModelAndView mv = new ModelAndView();
        Eleitor eleitor = elerepo.getOne(ele);
        System.out.println(eleitor);
        Candidato candidato = canrepo.getOne(can);
        eleitor.setID(ele);
        candidato.setId(can);
        Urna urna = new Urna(eleitor, candidato);
        
        System.out.println(urna);
        urnarepository.save(urna);
        mv.setViewName("/urna/pvotou");
        return mv;
    }
    
    /**
     * apuração dos votos
     * @return 
     */
    @GetMapping("/urna/votos")
    public ModelAndView votos(){
        ModelAndView mv = new ModelAndView();
        List<Votos> votos = votosrepo.apuracao();
        mv.setViewName("urna/votos");
        System.out.println(votosrepo.apuracao());
        mv.addObject("votoslist",votos );
            
        return mv;
    }
    
}
