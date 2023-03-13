package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(	name = "employee"//        uniqueConstraints = {
////                @UniqueConstraint(columnNames = "username"),
//                @UniqueConstraint(columnNames = "email")
)
public class Employee implements Serializable {
    @Id
    //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idEmployee;
    private String nmatricule;
    private String username;
    private String prenom;
    private String nom;
    @Column(name="email")
    private String email;

    private char sexe;

    @Column(name = "date_naissance")
    private LocalDate datenaissance;
    @Column(name = "date_embauche")
    private LocalDate dateembauche;
    private String function;
    private String domaine;

    private String departement;
    @Column(name = "N+1")
    private String Nplusone;
    @Column(name = "N+2")
    private String Nplustwo;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
