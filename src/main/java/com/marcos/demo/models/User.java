package com.marcos.demo.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = User.TABLE_NAME)
@Data
public class User {
    public static final String TABLE_NAME ="user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",length = 100,nullable = false, unique = true)
    @NotNull
    @NotEmpty
    @Size(min=2, max=100)
    private String username;

    @Column(name="password",length = 60, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min=8, max=60) 
    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<Task>();
}
