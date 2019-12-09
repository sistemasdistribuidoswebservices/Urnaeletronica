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
public class EleitoresController {
    private EleitorRepository eleitorrepository;

    public EleitoresController(EleitorRepository eleitorrepository) {
        this.eleitorrepository = eleitorrepository;
    }
    /**
     * Visualização de todos os candidatos
     * @return 
     */
    @GetMapping("/eleitores/eleitores")
    public ModelAndView getCandidato(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/eleitores/eleitores");
        mv.addObject("eleitorlist", eleitorrepository.findAll());
        return mv;
    }
    
    // cadastro de candidatos
    @GetMapping("/eleitores/cadastra")
    public ModelAndView cadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/eleitores/cadastra");
        mv.addObject("eleitor", new Eleitor());
        return mv;
    }
    
    @PostMapping(value = "/eleitores/cadastra")
    public  ModelAndView cadastra(@Valid Eleitor eleitor,BindingResult result){
        ModelAndView mv = new ModelAndView();
        Eleitor Eleitor = new Eleitor(eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
           eleitorrepository.save(Eleitor);
            mv.setViewName("redirect:/eleitores/eleitores");
        return mv;
    }
    // exclusão de dados do candidato
    @GetMapping("eleitores/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
         ModelAndView mv = new ModelAndView();
        eleitorrepository.deleteById(id);
        mv.setViewName("redirect:/eleitores/eleitores");
        return mv;
	}
    
    // alteração de candidados.
    @GetMapping("/eleitores/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
		Eleitor eleitor = eleitorrepository.getOne(id);
                mv.addObject("eleitor", eleitor);
		mv.setViewName("eleitores/alterar");
		return mv;
	}
	
	@PostMapping("/eleitores/alterar")
	public ModelAndView alterar(@Valid Eleitor eleitor, BindingResult result) {
		ModelAndView mv = new ModelAndView();
                Eleitor Eleitor = new Eleitor(eleitor.getID(), eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
                if(eleitor.getSenha().isEmpty()){
                    Eleitor aeleitor = eleitorrepository.getOne(eleitor.getID());
                    Eleitor.setSenha(aeleitor.getSenha());
                }
                System.out.println(Eleitor);
		eleitorrepository.save(Eleitor);
                mv.setViewName("redirect:/eleitores/eleitores");
		
		return mv;
	}
}

