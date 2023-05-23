
package com.estacionamento.jose.service;

import com.estacionamento.jose.entity.Marca;
import com.estacionamento.jose.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;


    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(@RequestParam("name") final String name,@RequestBody final Marca marca){

        Assert.isTrue(marca.getName() != null, "O nome está faltando");

        this.marcaRepository.save(marca);
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(final Marca marca, final Long id){

        final Marca marcaBanco = this.marcaRepository.findById(id).orElse(null);

        Assert.isTrue(marcaBanco != null || marcaBanco.getId() == marca.getId(), "Não foi possivel indenficar o registro no banco");

        Assert.isTrue(marca.getName() != null, "O nome está faltando");

        Assert.isTrue(this.marcaRepository.findByNomePut(marca.getName(),id).isEmpty(), "ja existe essa marca");

        this.marcaRepository.save(marca);
    }


    @Transactional(rollbackFor = Exception.class)

    public void delete(final Marca marca){
        final Marca marcaBanco = this.marcaRepository.findById(marca.getId()).orElse(null);

        List<Marca> marcaAtivo = this.marcaRepository.findByAtivo(marca.isAtivo());

        if(marcaAtivo.isEmpty()){
            this.marcaRepository.delete(marcaBanco);
        } else{
            marcaBanco.setAtivo(Boolean.FALSE);
            this.marcaRepository.save(marca);
        }
    }

}