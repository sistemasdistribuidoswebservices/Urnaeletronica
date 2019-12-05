/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import si.projetourna.Usuário.entity.Eleitor;

/**
 *
 * @author Alvaro
 */
public interface EleitorRepository extends JpaRepository<Eleitor,Long>{
   
}
