/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.projetourna.Usuário.entity.Candidato;

/**
 *
 * @author Alvaro
 */
public interface CandidatoRepository extends JpaRepository<Candidato,Long>{

    public void findOne(Candidato candidato);
    
}
