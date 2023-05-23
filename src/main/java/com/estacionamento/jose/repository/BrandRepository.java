package com.estacionamento.jose.repository;

import com.estacionamento.jose.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("FROM Brand WHERE ativo = true")
    List<Brand> findByAtivo(@Param("ativo")final boolean ativo);

    @Query("FROM Brand WHERE name = :name AND id = :id")
    List<Brand> findByNomePut(@Param("name") final String name, @Param("id")final Long id);

}