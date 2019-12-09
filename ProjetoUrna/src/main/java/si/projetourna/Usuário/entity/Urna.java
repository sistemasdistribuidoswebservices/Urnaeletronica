/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "URNA")
public class Urna implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 100, nullable = false, unique = true)
    private long Id;
    
    @JoinColumn (name = "Eleitor",nullable = false, unique = true)
    @OneToOne
    private Eleitor eleitor;
    
    
    @JoinColumn(name = "candidato",nullable = false)
    @OneToOne
    private Candidato candidato;
    
    /**
     *  Construtor vazio para o sistema.
     */
    public Urna() {
    }
    
    /**
     * Construtor com dados necessários para criação de acesso.
     * @param Id
     * @param eleitor
     * @param candidato 
     */
    public Urna(long Id, Eleitor eleitor, Candidato candidato) {
        this.Id = Id;
        this.eleitor = eleitor;
        this.candidato = candidato;
    }
    

    /**
     * 
     * @param eleitor
     * @param candidato 
     */
    public Urna(Eleitor eleitor, Candidato candidato) {
        this.eleitor = eleitor;
        this.candidato = candidato;
    }
    
    /**
     * Construtor com dados necessários para criação de acesso.
     * @param votos
     * @param candidato 
     */
    public Urna(long votos,Candidato candidato) {
        this.Id = votos;
        this.eleitor = null;
        this.candidato = candidato;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    
}
