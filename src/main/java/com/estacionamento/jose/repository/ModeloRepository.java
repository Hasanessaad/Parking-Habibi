package com.estacionamento.jose.repository;

import com.estacionamento.jose.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long>{

    List<Modelo>findAll();


}
