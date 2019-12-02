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
import javax.persistence.Table;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "CANDIDATO")
public class Candidato implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 100, nullable = false, unique = true)
    private long Id;
    
    @Column(name = "NOME", length = 100, nullable = false, unique = true)
    private String nome;
    
    @Column(name = "Cargo", length = 100, nullable = false, unique = true)
    private String cargo;
    
    @Column(name = "Partido", length = 100, nullable = false, unique = true)
    private String partido;
    /**
     * 
     */
    public Candidato() {
    }
    /**
     * 
     * @param Id
     * @param nome
     * @param cargo
     * @param partido 
     */
    public Candidato(long Id, String nome, String cargo, String partido) {
        this.Id = Id;
        this.nome = nome;
        this.cargo = cargo;
        this.partido = partido;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public long getId() {
        return Id;
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
