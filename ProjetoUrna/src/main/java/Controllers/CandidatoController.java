/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import si.projetourna.Usuário.entity.Candidato;
import si.projetourna.Usuário.entity.Role;
import si.projetourna.Usuário.entity.repository.CandidatoRepository;

/**
 *
 * @author Alvaro
 */
@RestController
public class CandidatoController {
    @Autowired
    CandidatoRepository candController;
    Candidato candidato, candidator;
    
    @RequestMapping(value = "/candidato", method = RequestMethod.POST)
    public String solicitante(){
        return "candidato controller";
    }
   
    @RequestMapping(value = "/candidato/registra/{nome}/{cargo}/{partido}", method = RequestMethod.GET)
    public Candidato CriaCandidato(
            @PathVariable(value = "nome")@Valid @RequestBody String nome,
            @PathVariable(value = "cargo")@Valid @RequestBody String cargo,
            @PathVariable(value = "partdo")@Valid @RequestBody String partido){
        
        candidato = new Candidato(nome, cargo, partido, Role.Candidato);
        candController.save(candidato);
        candController.findById(1);
       return candidato;         
    }
}
