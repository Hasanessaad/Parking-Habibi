package com.estacionamento.jose.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "modelo", schema = "public")
public class Modelo extends AbstractEntity{
    @Getter @Setter
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "marca")
    private Marca marca;
}
