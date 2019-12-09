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
    UrnaRepository urnarepo;
    
        
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
         //To change body of generated methods, choose Tools | Templates.
         List<Candidato> Candidatos = canrepo.findAll();
        List<Eleitor> Eleitores = elrepo.findAll();
        List<Urna> Urna = urnarepo.findAll();    
        if (Eleitores.isEmpty() || Candidatos.isEmpty()||Urna.isEmpty()){
            System.out.println("banco vazio");
            Eleitor eleitor = new Eleitor("A","a","12341234");
            Eleitores.add(eleitor);
            elrepo.save(eleitor);
            Eleitor eleitor1 = new Eleitor("b","b","12341234");
            Eleitores.add(eleitor1);
            elrepo.save(eleitor1);
            Eleitor eleitor2 = new Eleitor("c","c","12341234");
            Eleitores.add(eleitor2);
            elrepo.save(eleitor2);
            Eleitor eleitor3 = new Eleitor("d","d","12341234");
            Eleitores.add(eleitor3);
            elrepo.save(eleitor3);
            Eleitor eleitor4 = new Eleitor("eo","e","12341234");
            Eleitores.add(eleitor4);
            elrepo.save(eleitor4);
            Eleitor eleitor5 = new Eleitor("f","f","12341234");
            Eleitores.add(eleitor5);
            elrepo.save(eleitor5);
            Eleitor eleitor6 = new Eleitor("g","g","12341234");
            Eleitores.add(eleitor6);
            elrepo.save(eleitor6);
            
            Candidato candidato = new Candidato("alvaro", "presidente", "bundalele");
            Candidatos.add(candidato);
            Candidato candidato1 = new Candidato("Caroline", "Secretári1o", "bundalele");
            Candidatos.add(candidato1);
            Candidato candidato2 = new Candidato("Catharina", "Secretár1io", "bundalele");
            Candidatos.add(candidato2);
            canrepo.saveAll(Candidatos);
            
            Urna urna = new Urna(eleitor,candidato);
            urnarepo.save(urna);
            Urna urna1 = new Urna(eleitor1,candidato);
            urnarepo.save(urna1);
            Urna urna2 = new Urna(eleitor2,candidato);
            urnarepo.save(urna2);
            Urna urna3 = new Urna(eleitor3,candidato1);
            urnarepo.save(urna3);
            Urna urna4 = new Urna(eleitor4,candidato1);
            urnarepo.save(urna4);
            Urna urna5 = new Urna(eleitor5,candidato1);
            urnarepo.save(urna5);
//            Urna urna6 = new Urna(eleitor5,candidato2);
//            urnarepo.save(urna6);
            
            System.out.println("registrado no banco");
        }else System.out.println("banco registrado");
    }
    
    
}
