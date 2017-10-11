/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.edu.elte.alkfejl.entity;

import com.sun.xml.internal.ws.developer.StreamingAttachment;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 *
 * @author kopraei
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false, unique = true)
    private String userName;
    
    @Column(nullable=false)
    private String password;
    
    
    @Column(nullable=false, unique = true)
    private String email;
           
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToMany(targetEntity = Issue.class, mappedBy = "user")
    private List<Issue> issues;
    
    
    public enum Role {
        USER,ADMIN
                
    ;
}
}
