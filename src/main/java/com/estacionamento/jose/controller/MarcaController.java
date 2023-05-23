package com.estacionamento.jose.controller;
import com.estacionamento.jose.entity.Marca;
import com.estacionamento.jose.entity.Modelo;
import com.estacionamento.jose.repository.MarcaRepository;
import com.estacionamento.jose.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/id")
    public ResponseEntity<?> findById(@RequestParam("id") final Long id){
        Marca cur_marca = this.marcaRepository.findById(id).orElse(null);

        return cur_marca == null
                ? ResponseEntity.badRequest().body("Nenhum valor encontrado")
                : ResponseEntity.ok(cur_marca);
    }
//
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        try{
            List<?> m_marca = marcaRepository.findAll();
            return new ResponseEntity<>(m_marca, HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ativo")
    public ResponseEntity<?> findByAtivo(@Param("ativo") final boolean ativo){
        return ResponseEntity.ok(this.marcaRepository.findByAtivo(ativo));
    }

    @PostMapping("/add")
    public ResponseEntity<?> cadastrar(@RequestBody final Marca marca){
        try {
            this.marcaRepository.save(marca);
            return ResponseEntity.ok("Registrado cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestParam("id") final Long id,@RequestBody final Marca marca){

        try{
            this.marcaService.edit(marca, id);
            return ResponseEntity.ok("Registro atualizacao com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }


    @DeleteMapping
    public ResponseEntity<?> deletar (@RequestParam ("id") final Long id){

        final Marca bb = this.marcaRepository.findById(id).orElse(null);

        this.marcaService.delete(bb);

        return ResponseEntity.ok("Marca deletada com sucesso");
    }
}