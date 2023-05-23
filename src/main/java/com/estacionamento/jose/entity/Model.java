package com.estacionamento.jose.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "modelo", schema = "public")
public class Model extends AbstractEntity{

    @Getter @Setter
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brandId;

}
