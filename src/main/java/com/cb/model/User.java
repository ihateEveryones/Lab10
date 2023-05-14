package com.cb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();

    public User(String name, String email, String password, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }*/ @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_roles")
    private Roles id_roles;

    public User(String name, String email, String password, Roles id_roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id_roles = id_roles;
    }
}
