/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.projetourna.Usuário.entity;

/**
 *
 * @author Álvaro pereira do Nascimento.
 */
public enum Role {
    Eleitor(1),Candidato(2),Administrador(3);
    private int role;

    private Role(int role) {
        this.role = role;
    }
    
    
    
}
