
package com.estacionamento.jose.service;

import com.estacionamento.jose.entity.Brand;
import com.estacionamento.jose.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;


    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(@RequestParam("name") final String name,@RequestBody final Brand brand){

        Assert.isTrue(brand.getName() != null, "O nome está faltando");

        this.brandRepository.save(brand);
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(final Brand brand, final Long id){

        final Brand brandBanco = this.brandRepository.findById(id).orElse(null);

        Assert.isTrue(brandBanco != null || brandBanco.getId() == brand.getId(), "Não foi possivel indenficar o registro no banco");

        Assert.isTrue(brand.getName() != null, "O nome está faltando");

        Assert.isTrue(this.brandRepository.findByNomePut(brand.getName(),id).isEmpty(), "ja existe essa marca");

        this.brandRepository.save(brand);
    }


    @Transactional(rollbackFor = Exception.class)

    public void delete(final Brand brand){
        final Brand brandBanco = this.brandRepository.findById(brand.getId()).orElse(null);

        List<Brand> brandAtivo = this.brandRepository.findByAtivo(brand.isAtivo());

        if(brandAtivo.isEmpty()){
            this.brandRepository.delete(brandBanco);
        } else{
            brandBanco.setAtivo(Boolean.FALSE);
            this.brandRepository.save(brand);
        }
    }

}