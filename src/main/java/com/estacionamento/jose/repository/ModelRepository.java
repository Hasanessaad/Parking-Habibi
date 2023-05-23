package com.estacionamento.jose.repository;

import com.estacionamento.jose.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>{

    List<Model>findAll();


}
