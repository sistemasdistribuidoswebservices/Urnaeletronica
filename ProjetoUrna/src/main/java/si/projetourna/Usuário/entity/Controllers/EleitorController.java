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
    //Visualização de todos os eleitor.
    @GetMapping("/eleitor/eleitores")
    public ModelAndView getEleitores(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("eleitores/2eleitores");
        mv.addObject("eleitorlist", eleitorrepository.findAll());
        return mv;
    }
    
    //busca de somente um eleitor
     @GetMapping("/eleitor/eleitor/{id}")
    public ModelAndView getEleitor(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("eleitores/eleitor");
        mv.addObject("eleitorlist", eleitorrepository.getOne(id));
        return mv;
    }
    
    //Visualização de todos os eleitor.
    @GetMapping("/eleitor/2eleitores")
    public ModelAndView getEleitor2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("eleitores/2eleitores");
        mv.addObject("eleitorlist", eleitorrepository.findAll());
        return mv;
    }
    
    // cadastro de eleitor
    @GetMapping("/eleitor/ecadastra")
    public ModelAndView cadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("eleitores/ecadastra");
        mv.addObject("eleitor", new Eleitor());
        return mv;
    }
    
    @PostMapping(value = "/eleitor/ecadastra")
    public  ModelAndView cadastra(@Valid Eleitor eleitor,BindingResult result){
        ModelAndView mv = new ModelAndView();
        Eleitor Eleitor = new Eleitor(eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
           eleitorrepository.save(Eleitor);
            mv.setViewName("redirect:/eleitor/2eleitores");
        return mv;
    }
    // exclusão de dados do eleitor
    @GetMapping("/eleitor/eexcluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
         ModelAndView mv = new ModelAndView();
        eleitorrepository.deleteById(id);
        mv.setViewName("redirect:/eleitor/eleitores");
        return mv;
	}
    
    // alteração de eleitor.
    @GetMapping("/eleitor/ealterar/{id}")
	public ModelAndView alterar(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
		Eleitor eleitor = eleitorrepository.getOne(id);
                mv.addObject("eleitor", eleitor);
		mv.setViewName("eleitores/ealterar");
		return mv;
	}
	
	@PostMapping("/eleitor/ealterar")
	public ModelAndView alterar(@Valid Eleitor eleitor, BindingResult result) {
		ModelAndView mv = new ModelAndView();
                Eleitor Eleitor = new Eleitor(eleitor.getID(), eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
                System.out.println(Eleitor);
		eleitorrepository.save(Eleitor);
                mv.setViewName("redirect:/eleitor/2eleitores");
		
		return mv;
	}
        @PostMapping("/eleitor/2ealterar")
	public ModelAndView alterares(@Valid Eleitor eleitor, BindingResult result) {
		ModelAndView mv = new ModelAndView();
                Eleitor Eleitor = new Eleitor(eleitor.getID(), eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
                System.out.println(Eleitor);
		eleitorrepository.save(Eleitor);
                mv.setViewName("redirect:/eleitor/2eleitores");
		
		return mv;
	}
}

