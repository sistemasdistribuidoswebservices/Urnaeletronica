/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.Controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import si.projetourna.Usuário.entity.Candidato;
import si.projetourna.Usuário.entity.repository.CandidatoRepository;

/**
 *
 * @author Alvaro
 */
@RestController
public class CandidatoRestController {
    @Autowired
    CandidatoRepository candController;
    
    Candidato candidatos, candidator;
    
    
    @RequestMapping(value = "/candidato", method = RequestMethod.GET)
    public String solicitante(){
        return "candidato controller";
    }
   
    @RequestMapping(value = "/candidato/registra/{nome}/{cargo}/{partido}", method = RequestMethod.GET)
    public Candidato CriaCandidato(
            @PathVariable(value = "nome")@Valid @RequestBody String nome,
            @PathVariable(value = "cargo")@Valid @RequestBody String cargo,
            @PathVariable(value = "partido")@Valid @RequestBody String partido){
        
        candidatos = new Candidato(nome, cargo, partido);
        candController.save(candidatos);
       return candidatos;         
    }
    
    @RequestMapping(value = "/candidatos", method = RequestMethod.GET)
    public List<Candidato> listaCandidato(){
        return candController.findAll();
    }
    
    @RequestMapping(value = "/candidato/{id}", method = RequestMethod.GET)
    public ResponseEntity<Candidato> GetbyID(
            @PathVariable(value = "id")@Valid @RequestBody long id){
            Optional<Candidato> candidato= candController.findById(id);
            
         if(candidato.isPresent())
            return new ResponseEntity<Candidato>(candidato.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
    
    @RequestMapping(value = "/candidato/altera/{id}/{nome}/{cargo}/{partido}", method =  RequestMethod.PUT)
    public ResponseEntity<Candidato> Put(
            @PathVariable(value = "id") @Valid @RequestBody long id, 
            @PathVariable(value = "nome")@Valid @RequestBody String nome,
            @PathVariable(value = "cargo")@Valid @RequestBody String cargo,
            @PathVariable(value = "partido")@Valid @RequestBody String partido)
    {
        Optional<Candidato> candidato = candController.findById(id);
        if(candidato.isPresent()){
            candidator = candidato.get();
            candidator.setNome(nome);
            candidator.setPartido(partido);
            candController.save(candidator);
            return new ResponseEntity<Candidato>(candidator, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/Candidato/deleta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Candidato> candidato = candController.findById(id);
        if(candidato.isPresent()){
            candController.delete(candidato.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
