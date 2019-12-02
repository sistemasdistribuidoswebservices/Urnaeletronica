/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity;

import java.io.Serializable;
import java.util.Set;
import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "ELEITOR")
public class Eleitor implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 100, nullable = false, unique = true)
    private long ID;
    
    @Column(name = "E-MAIL", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "SENHA", length = 100, nullable = false, unique = true)
    private String senha;
    
    @OneToOne
    @Column(name = "ROLE", length = 2, nullable = false, unique = true)
    private Set<Role> role;
    /**
     * 
     */
    public Eleitor() {
    }
    /**
     * 
     * @param ID
     * @param email
     * @param senha
     * @param role 
     */
    public Eleitor(long ID, String email, String senha, Set<Role> role) {
        this.ID = ID;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    
    
}
