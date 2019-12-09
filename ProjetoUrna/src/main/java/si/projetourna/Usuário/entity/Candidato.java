/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "CANDIDATO")
public class Candidato implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 100, nullable = false, unique = true)
    private long id;
    
    @Column(name = "NOME", length = 100, nullable = false, unique = true)
    @NotNull(message = "Nome é obrigatório")
    @Length (min=1, max = 255, message = "O campo deve estar entre 1 e 255 caracteres")
    private String nome;
    
    @Column(name = "Cargo", length = 100, nullable = false)
    @NotNull(message = "Cargo é obrigatório")
    @Length (min=1, max = 255, message = "O campo deve estar entre 1 e 255 caracteres")
    private String cargo;
    
    @Column(name = "Partido", length = 100, nullable = false)
    @NotNull(message = "Partido é  obrigatório")
    @Length (min=1, max = 255, message = "O campo deve estar entre 1 e 255 caracteres")
    private String partido;
    
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Role", length = 2, nullable = false)
    public Role role;
  
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
        this.id = Id;
        this.nome = nome;
        this.cargo = cargo;
        this.partido = partido;
        this.role = Role.Candidato;
    }
    /**
     * 
     * @param nome
     * @param cargo
     * @param partido
     */
    public Candidato(String nome, String cargo, String partido) {
        this.nome = nome;
        this.cargo = cargo;
        this.partido = partido;
        this.role = Role.Candidato;
    }
    
    

    public void setId(long Id) {
        this.id = Id;
    }

    public long getId() {
        return id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
}
