/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import si.projetourna.Usuário.entity.*;
import si.projetourna.Usuário.entity.repository.*;

/**
 *
 * @author Alvaro
 */
@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent>{
    
    @Autowired
    EleitorRepository elrepo;
    
    @Autowired
    CandidatoRepository canrepo;
    
    @Autowired
    UrnaRepository urrepo;
        
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
         //To change body of generated methods, choose Tools | Templates.
         List<Candidato> Candidatos = canrepo.findAll();
        List<Eleitor> Eleitores = elrepo.findAll();
        List<Urna> Votos = urrepo.findAll();

        if (Eleitores.isEmpty() || Candidatos.isEmpty()|| Votos.isEmpty()){
            System.out.println("banco vazio");
            Eleitor eleitor = new Eleitor("alvaropereira15@gmail.com","12341234");
            Eleitores.add(eleitor);
            elrepo.save(eleitor);
            Candidato candidato = new Candidato("alvaro", "presidente", "bundalele");
            Candidatos.add(candidato);
            canrepo.save(candidato);
            System.out.println("registrado no banco");
        }else System.out.println("banco registrado");
    }
    
    
}
