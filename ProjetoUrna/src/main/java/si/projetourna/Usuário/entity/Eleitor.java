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

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "ELEITOR")
public class Eleitor implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 100)
    private long id;
    
    @Column(name = "MAIL", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "nome", length = 100, nullable = false, unique = true)
    private String nome;
    
    @Column(name = "SENHA", length = 100, nullable = false)
    private String senha;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Role", length = 1, nullable = false)
    public Role role;
    
    /**
     * 
     */
    public Eleitor() {
    }
    /**
     * 
     * @param ID
     * @param nome
     * @param email
     * @param senha 
     */
    public Eleitor(long ID, String nome, String email, String senha) {
        this.id = ID;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.role = Role.Eleitor;
    }
    
    /**
     * 
     * @param nome
     * @param email
     * @param senha 
     */
    public Eleitor( String nome, String email,String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.role = Role.Eleitor;
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
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
        
    
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
