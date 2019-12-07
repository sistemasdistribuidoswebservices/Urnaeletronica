/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.Controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    //Visualização de todos os candidatos.
    @GetMapping("/candidato/candidatos")
    public ModelAndView getCandidato(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("candidato/candidatos");
        mv.addObject("candidatolist", candidatorepository.findAll());
        return mv;
    }
    
    // cadastro de candidatos
    @GetMapping("/candidato/ccadastra")
    public ModelAndView cadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("candidato/ccadastra");
        mv.addObject("candidato", new Candidato());
        return mv;
    }
    
    @PostMapping("/candidato/ccadastra")
    public  ModelAndView cadastra(@Valid Candidato candidatos,BindingResult result){
        ModelAndView mv = new ModelAndView();
        Candidato candidato = new Candidato(candidatos.getNome(), candidatos.getCargo(), candidatos.getPartido());
            candidatorepository.save(candidato);
            mv.setViewName("redirect:/candidato/candidatos");
        return mv;
    }
    // exclusão de dados do candidato
    @GetMapping("/candidato/cexcluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
		candidatorepository.deleteById(id);
                    return "redirect:/candidato/candidatos";
	}
    
    // alteração de candidados.
    @GetMapping("/candidato/calterar/{id}")
	public ModelAndView alterar(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
		Candidato candidato = candidatorepository.getOne(id);
                mv.addObject("candidato", candidato);
                System.out.println(candidato.getId()+" "+candidato.getNome());
		mv.setViewName("candidato/calterar");
		return mv;
	}
	
	@PostMapping("candidato/calterar")
	public ModelAndView alterar(@Valid Candidato candidatos, BindingResult result) {
		ModelAndView mv = new ModelAndView();
                Candidato candidato = new Candidato(candidatos.getId(), candidatos.getNome(), candidatos.getCargo(), candidatos.getPartido());
                System.out.println(candidatos);
		candidatorepository.save(candidato);
                mv.setViewName("redirect:/candidato/candidatos");
		
		return mv;
	}
}

