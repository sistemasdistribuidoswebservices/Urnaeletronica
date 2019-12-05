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
import si.projetourna.Usuário.entity.Eleitor;
import si.projetourna.Usuário.entity.repository.EleitorRepository;

/**
 *
 * @author Alvaro
 */

@Controller
public class EleitorController {
    private EleitorRepository eleitorrepository;

    public EleitorController(EleitorRepository eleitorrepository) {
        this.eleitorrepository = eleitorrepository;
    }
    //Visualização de todos os candidatos.
    @GetMapping("/eleitores")
    public ModelAndView getCandidato(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("eleitores");
        mv.addObject("eleitorlist", eleitorrepository.findAll());
        return mv;
    }
    
    // cadastro de candidatos
    @GetMapping("/ecadastra")
    public ModelAndView cadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ecadastra");
        mv.addObject("eleitor", new Eleitor());
        return mv;
    }
    
    @PostMapping("/ecadastra")
    public  ModelAndView cadastra(@Valid Eleitor eleitor,BindingResult result){
        ModelAndView mv = new ModelAndView();
        Eleitor Eleitor = new Eleitor(eleitor.getNome(), eleitor.getNome(), eleitor.getSenha());
            eleitorrepository.save(Eleitor);
            mv.setViewName("redirect:/eleitores");
       // }
        return mv;
    }
//    // exclusão de dados do candidato
//    @GetMapping("/excluir/{id}")
//    public String excluir(@PathVariable("id") Long id) {
//		eleitorrepository.deleteById(id);
//		return "redirect:candidatos";
//	}
//    
//    // alteração de candidados.
//    @GetMapping("/alterar/{id}")
//	public ModelAndView alterar(@PathVariable("id") long id) {
//		ModelAndView mv = new ModelAndView();
//		eleitor eleitor = eleitorrepository.getOne(id);
//                mv.addObject("eleitor", eleitor);
//                System.out.println(candidato.getId()+" "+candidato.getNome());
//		mv.setViewName("calterar");
//		return mv;
//	}
//	
//	@PostMapping("/alterar")
//	public ModelAndView alterar(@Valid Candidato candidatos, BindingResult result) {
//		ModelAndView mv = new ModelAndView();
//                Candidato candidato = new Candidato(candidatos.getId(), candidatos.getNome(), candidatos.getCargo(), candidatos.getPartido());
//                System.out.println(candidatos);
//		eleitorrepository.save(candidato);
//                mv.setViewName("redirect:/candidatos");
//		
//		return mv;
//	}
}

