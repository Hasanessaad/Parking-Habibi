package com.estacionamento.jose.controller;

import com.estacionamento.jose.entity.Marca;
import com.estacionamento.jose.entity.Modelo;
import com.estacionamento.jose.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/modelo")
public class ModeloController {
    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        try{
            List<?> m_marca = modeloRepository.findAll();
            return new ResponseEntity<>(m_marca, HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> cadastrar(@RequestBody final Modelo modelo){
        try {
            this.modeloRepository.save(modelo);
            return ResponseEntity.ok("Registrado cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
