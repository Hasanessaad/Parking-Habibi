package com.estacionamento.jose.repository;

import com.estacionamento.jose.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    @Query("FROM Marca WHERE ativo = true")
    List<Marca> findByAtivo(@Param("ativo")final boolean ativo);

    @Query("FROM Marca WHERE name = :name AND id = :id")
    List<Marca> findByNomePut(@Param("name") final String name, @Param("id")final Long id);

}