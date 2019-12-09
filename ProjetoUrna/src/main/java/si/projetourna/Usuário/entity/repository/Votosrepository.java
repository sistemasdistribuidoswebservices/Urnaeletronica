/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.projetourna.Usuário.entity.Votos;

/**
 *
 * @author Alvaro
 */
public interface Votosrepository extends JpaRepository<Votos, Long>{
    
    @Query(value = "SELECT c.id as id, count(*) as voto ,c.nome as nome , c.cargo as cargo , c.partido as partido  from  urna as u left join candidato as c on c.id = u.candidato GROUP by u.candidato;", nativeQuery = true)
    List<Votos> apuracao();
    
}
