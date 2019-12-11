package si.projetourna.Usuário.entity.Controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import si.projetourna.Usuário.entity.Administrador;
import si.projetourna.Usuário.entity.Candidato;
import si.projetourna.Usuário.entity.Eleitor;
import si.projetourna.Usuário.entity.repository.CandidatoRepository;
import si.projetourna.Usuário.entity.repository.EleitorRepository;

@Controller
public class HomeController {
    
    @Autowired
    private CandidatoRepository candidatorepository;
    @Autowired
    private EleitorRepository eleitorrepository;

    public HomeController(CandidatoRepository candidatorepository, EleitorRepository eleitorrepository) {
        this.candidatorepository = candidatorepository;
        this.eleitorrepository = eleitorrepository;
    }
    
    
    
    @GetMapping("/")
    public ModelAndView home() {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/home");
            return mv;

    }
    
    @GetMapping("/1candidato/cadastra")
    public ModelAndView umCCadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("1ccadastro");
        mv.addObject("candidato", new Candidato());
        
        return mv;
    }
    
    @PostMapping("/1candidato/cadastra")
	public ModelAndView ecadastro(@Valid Candidato candidato, BindingResult result) {
		ModelAndView mv = new ModelAndView();
                Candidato candidatos = new Candidato(candidato.getNome(), candidato.getCargo(), candidato.getPartido());
                candidatorepository.save(candidatos);
                mv.setViewName("/clogin");
		
		return mv;
	}
    
     @GetMapping("/1eleitor/cadastra")
    public ModelAndView umeCadastra(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("2cadastra");
        mv.addObject("eleitor", new Eleitor());
        
        return mv;
    }
    
    @PostMapping("/1eleitor/cadastra")
	public ModelAndView ecadastro(@Valid Eleitor eleitor, BindingResult result) {
		ModelAndView mv = new ModelAndView();
                Eleitor Eleitor = new Eleitor(eleitor.getID(), eleitor.getNome(), eleitor.getEmail(), eleitor.getSenha());
                eleitorrepository.save(Eleitor);
                mv.setViewName("/elogin");
		
		return mv;
	}
    
    @GetMapping("/erro")
    public ModelAndView erro() {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("errolog");
            return mv;

    }
    
    /**
     * Tela de menu do admin
     * @return 
     */
    @GetMapping("/conta/adminmenu")
    public String admmenu() {
            return "/conta/adminmenu";
    }
    /**
     * Tela de menu do eleitor
     * @param id
     * @return 
     */
    @GetMapping("/conta/eleitormenu/{id}")
    public ModelAndView Eleitormenu( @PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/conta/eleitormenu");
        mv.addObject("eleitor",id);
        return mv;    

    }
    /**
     * Tela de menu do candidato 
     * @param id
     * @return 
     */
    @GetMapping("/conta/candidatomenu/{id}")
    public ModelAndView candidatomenu(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/conta/candidatomenu");
        mv.addObject("candidato", id);
    return mv;
    }
    /**
     * Apresentação de tela do candidato para login.
     * @return 
     */
    @GetMapping ("/clogin")
    public ModelAndView CandidatoLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("clogin");
        mv.addObject("candidato", new Candidato());
        return mv;
    }
    /**
     * Processo de post que retorna página com o acesso do solitante.
     * @param candidatos
     * @param result
     * @return 
     */
    @PostMapping("/clogin")
	public ModelAndView CandidatoLogar(@Valid Candidato candidatos, BindingResult result) {
		ModelAndView mv = new ModelAndView();
            Candidato candidato = candidatorepository.findByNome(candidatos.getNome());
            if((candidato.getNome().equalsIgnoreCase(candidatos.getNome())) && candidato.getCargo().equalsIgnoreCase(candidatos.getCargo()))
                mv.setViewName("redirect:/Index/Candidato/"+candidato.getId());
            else{
                mv.setViewName("/errolog");
                mv.addObject("erro","Tentativa de Login como candidato esta incorreta.\n Logue-se novamente");
            }
            return mv;
	}
        
        
    @GetMapping ("/elogin")
    public ModelAndView EleitorLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("elogin");
        mv.addObject("eleitor", new Eleitor());
        return mv;
    }    
        
        
    @PostMapping(value = "/elogin")
    public  ModelAndView EleitorLogar(@Valid Eleitor eleitor,BindingResult result){
        ModelAndView mv = new ModelAndView();
        Eleitor Eleitor = eleitorrepository.findByEmail(eleitor.getEmail());
        if(Eleitor.getSenha().equals(eleitor.getSenha())&& Eleitor.getEmail().equalsIgnoreCase(eleitor.getEmail()))
            mv.setViewName("redirect:/Index/Candidato/"+Eleitor.getID());
        else{
            mv.setViewName("/errolog");
            mv.addObject("erro","Tentativa de Login como Eleitor esta incorreta.\n Logue-se novamente");
        }
        return mv;
    }
    
    
    @GetMapping ("/alogin")
    public ModelAndView admLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alogin");
        mv.addObject("adm", new Administrador());
        return mv;
    }    
        
        
    @PostMapping(value = "/alogin")
    public  ModelAndView admLogar(@Valid Administrador administrador,BindingResult result){
        ModelAndView mv = new ModelAndView();
        if(administrador.getSenha().equals("admin")&& administrador.getLogin().equalsIgnoreCase("admin"))
            mv.setViewName("redirect:/Index/Admin");
        else{
            mv.setViewName("/errolog");
            mv.addObject("erro","Tentativa de Login como Administrador esta incorreta.\n Logue-se novamente");
        }
        return mv;
    }
    
     @GetMapping ("/Index/Candidato/{id}")
     public ModelAndView IndexCandidato(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
		Candidato candidato = candidatorepository.getOne(id);
                mv.addObject("candidato",String.valueOf(id));
                mv.setViewName("Index/Candidato");
     return mv;
	}
     @GetMapping ("/Index/Eleitor/{id}")
     public ModelAndView Indexeleitor(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
                mv.addObject("eleitor",String.valueOf(id));
                mv.setViewName("Index/Eleitor");
                
                return mv;
	}
     
     @GetMapping ("/Index/Admin")
     public ModelAndView Indexadm() {
		ModelAndView mv = new ModelAndView();
                mv.setViewName("/Index/Admin");
                
                return mv;
	}
     @GetMapping ("/logado")
     public ModelAndView telamenu() {
		ModelAndView mv = new ModelAndView();
                mv.setViewName("logado");
                
                return mv;
	}
}
