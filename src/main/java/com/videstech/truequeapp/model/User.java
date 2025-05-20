package com.videstech.truequeapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(unique = true)
        private String email;

        private String password;

        private String location;

        private String phone;

        private Double reputation = 0.0;

        @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
        private List<Item> items;

        @OneToMany(mappedBy = "user")
        private List<Favorite> favorites;

}

