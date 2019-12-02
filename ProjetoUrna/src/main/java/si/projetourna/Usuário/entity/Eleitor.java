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
import javax.persistence.JoinColumn;
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
    
    @Column(name = "MAIL", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "SENHA", length = 100, nullable = false, unique = true)
    private String senha;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Role", length = 1, nullable = false, unique = true)
    public Role role;
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
    public Eleitor(long ID, String email, String senha, Role role) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
}
