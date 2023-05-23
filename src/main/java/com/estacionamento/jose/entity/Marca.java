package com.estacionamento.jose.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name = "marca", schema = "public")
public class Marca extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 50)
    private String name;

}

