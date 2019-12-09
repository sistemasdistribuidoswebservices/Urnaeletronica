package si.projetourna.Usuário.entity.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.projetourna.Usuário.entity.Urna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public interface UrnaRepository extends JpaRepository<Urna, Long>{
    Urna findByCandidato(String id);
    Urna findByEleitor(String id);
    
}
