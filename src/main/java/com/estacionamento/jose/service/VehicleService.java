package com.estacionamento.jose.service;

import com.estacionamento.jose.entity.Brand;
import com.estacionamento.jose.entity.Vehicle;
import com.estacionamento.jose.repository.BrandRepository;
import com.estacionamento.jose.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional(rollbackFor = Exception.class)
    public void register(@RequestParam("plate") final String plate, @RequestBody final Vehicle vehicle){

        Assert.isTrue(vehicle.getPlate() != null, "A placa está faltando");

        this.vehicleRepository.save(vehicle);
    }

}
