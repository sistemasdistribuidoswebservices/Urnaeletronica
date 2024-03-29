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

    /**
     *
     * @param candidatorepository
     */
    public CandidatoController(CandidatoRepository candidatorepository) {
        this.candidatorepository = candidatorepository;
    }
    /**
     * Visualização de somente um candidato.
     * @param id
     * @return  uma lista com todos os candidatos.
     */
    @GetMapping("/candidato/candidato/{id}")
    public ModelAndView getCandidato(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("vcandidato/vcandidato");
        mv.addObject("candidatolist", candidatorepository.getOne(id));
        return mv;
    }
        
    /**
     * Exibe tela de cadastro de somente umcandidato.
     * @return  tela para registro do candidato.
     */
    @GetMapping("/candidato/cadastra")
    public ModelAndView cadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("vcandidato/vcadastra");
        mv.addObject("candidato", new Candidato());
        return mv;
    }
    /**
     * Salva candidato no banco.
     * @param candidatos
     * @param result
     * @return 
     */
    @PostMapping("/candidato/cadastra")
    public  ModelAndView cadastra(@Valid Candidato candidatos,BindingResult result){
            ModelAndView mv = new ModelAndView();
            Candidato candidato = new Candidato(candidatos.getNome(), candidatos.getCargo(), candidatos.getPartido());
            candidatorepository.save(candidato);
            Candidato ccandidato =  candidatorepository.findByNome(candidatos.getNome());
            mv.setViewName("redirect:/candidato/candidato/"+ccandidato.getId());
        return mv;
    }
    /**
     * exclusão de dados do candidato informando o id como base de busca
     * @param id - base de busca
     * @return  para página candidatos com o id exlcuido.
     */
    @GetMapping("/candidato/excluir/{id}")
    public String excluir(@PathVariable("id") long id) {
        System.out.println(id);    
        candidatorepository.deleteById(id);
        System.out.println("excluido"+id);
        return "redirect:home";
	}
    
    /**
     * alteração de candidados.
     * @param id entra com o id para  localização  
     * @return  retorna atributos necessários para carregamento de página.
     */
    @GetMapping("/candidato/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
		Candidato candidato = candidatorepository.getOne(id);
                mv.addObject("candidato", candidato);
                System.out.println(candidato.getId()+" "+candidato.getNome());
		mv.setViewName("vcandidato/valterar");
		return mv;
	}
    /**
     * 
     * @param candidatos recebe dados alterados por método post e os altera no banco.
     * @param result
     * @return  retorna para a página dos candidados com os dados alterados.
     */
    @PostMapping("/candidato/alterar")
    public ModelAndView alterar(@Valid Candidato candidatos, BindingResult result) {
            ModelAndView mv = new ModelAndView();
            Candidato candidato = new Candidato(candidatos.getId(), candidatos.getNome(), candidatos.getCargo(), candidatos.getPartido());
            System.out.println(candidatos.getId());
            candidatorepository.save(candidato);
            mv.setViewName("redirect:/candidato/candidato/"+candidatos.getId());

            return mv;
    }   
    
}

