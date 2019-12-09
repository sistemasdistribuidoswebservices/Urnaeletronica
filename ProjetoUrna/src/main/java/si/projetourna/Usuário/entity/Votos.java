/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.web.bind.annotation.Mapping;

/**
 *
 * @author Alvaro
 */
@Entity
public class Votos {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private long voto;
    private String nome,cargo,partido;

    public Votos(long votos, String nome, String cargo, String partido) {
        this.voto = votos;
        this.nome = nome;
        this.cargo = cargo;
        this.partido = partido;
        this.id = id;
    }
    
    
    public Votos(){
        
    }

    public Votos(long voto, String nome, String cargo, String partido, long id) {
        this.id = id;
        this.voto = voto;
        this.nome = nome;
        this.cargo = cargo;
        this.partido = partido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    public long getVoto() {
        return voto;
    }

    public void setVoto(long votos) {
        this.voto = votos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    
    
    
}
