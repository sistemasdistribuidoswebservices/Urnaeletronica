/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "URNA")
public class Urna implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 100, nullable = false, unique = true)
    private long Id;
    
    @PrimaryKeyJoinColumn(foreignKey = @ForeignKey)
    @OneToOne    
    @Column(name = "Eleitor", length = 100, nullable = false, unique = true)
    private long eleitor;
    
    @PrimaryKeyJoinColumn(foreignKey = @ForeignKey)
    @OneToOne
    @Column(name = "caditato", length = 100, nullable = false, unique = true)
    private long candidato;
    
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
    public Urna(long Id, long eleitor, long candidato) {
        this.Id = Id;
        this.eleitor = eleitor;
        this.candidato = candidato;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getEleitor() {
        return eleitor;
    }

    public void setEleitor(long eleitor) {
        this.eleitor = eleitor;
    }

    public long getCandidato() {
        return candidato;
    }

    public void setCandidato(long candidato) {
        this.candidato = candidato;
    }
    
    
}
