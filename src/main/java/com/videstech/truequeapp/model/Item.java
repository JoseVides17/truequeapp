package com.videstech.truequeapp.model;

import com.videstech.truequeapp.model.enums.ItemType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    private String category;

    private String imageUrl;

    private Boolean isAvailable = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "item")
    private List<Favorite> favorites;

}