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
    /**
     * Visualização de todos os eleitor
     * @param id
     * @return 
     */
    @GetMapping("/eleitor/eleitor/{id}")
    public ModelAndView getCandidato(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/eleitor/eleitor");
        mv.addObject("eleitorlist", eleitorrepository.getOne(id));
        return mv;
    }
    
    // cadastro de eleitor
    @GetMapping("/eleitor/cadastra")
    public ModelAndView cadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/eleitor/cadastra");
        mv.addObject("eleitor", new Eleitor());
        return mv;
    }    
    
    @PostMapping(value = "/eleitor/cadastra")
    public  ModelAndView cadastra(@Valid Eleitor eleitor,BindingResult result){
        ModelAndView mv = new ModelAndView();
        Eleitor Eleitor = new Eleitor(eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
        eleitorrepository.save(Eleitor);
        Eleitor aux = eleitorrepository.findByEmail(eleitor.getEmail());
        mv.setViewName("redirect:/eleitor/eleitor/"+aux.getID());
        return mv;
    }
    // exclusão de dados do eleitor
    @GetMapping("eleitor/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
         ModelAndView mv = new ModelAndView();
        eleitorrepository.deleteById(id);
        mv.setViewName("/eleitor/excluido");
        return mv;
	}
    
    // alteração de eleitor.
    @GetMapping("/eleitor/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
                mv.addObject("eleitor", eleitorrepository.getOne(id));
		mv.setViewName("eleitor/alterar");
		return mv;
	}
	
	@PostMapping("/eleitor/alterar")
	public ModelAndView alterar(@Valid Eleitor eleitor, BindingResult result) {
		ModelAndView mv = new ModelAndView();
                Eleitor Eleitor = new Eleitor(eleitor.getID(), eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
                if(eleitor.getSenha().isEmpty()){
                    Eleitor aeleitor = eleitorrepository.getOne(eleitor.getID());
                    Eleitor.setSenha(aeleitor.getSenha());
                }
                System.out.println(Eleitor);
		eleitorrepository.save(Eleitor);
                mv.setViewName("redirect:/eleitor/eleitor/" + eleitor.getID() );
		
		return mv;
	}
}

