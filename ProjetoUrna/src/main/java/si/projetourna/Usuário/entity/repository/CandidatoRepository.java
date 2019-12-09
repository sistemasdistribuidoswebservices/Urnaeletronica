/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import si.projetourna.Usuário.entity.Candidato;

/**
 *
 * @author Alvaro
 */
public interface CandidatoRepository extends JpaRepository<Candidato,Long>{
    
    Candidato findByNome(String nome);
    Candidato findByCargo(String cargo);
    Candidato findByPartido(String partido);
    @Modifying
    @Query(value = "\"UPDATE candidato SET u.nome = ?2,  u.cargo = ?3, u.partido = ?4 WHERE u.id =  ?1\"", nativeQuery = true)
    Candidato update(long id, String nome,String cargo, String partido);
}
