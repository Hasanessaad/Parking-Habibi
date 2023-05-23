package com.estacionamento.jose.util;

import com.estacionamento.jose.dto.MarcaDto;
import com.estacionamento.jose.entity.Marca;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarcaMapper {

//    public Marca toMarca(@NotNull MarcaDto marcaDto) {
//        return Marca.builder().name(marcaDto.getName()).build();
//    }
//    public MarcaDto toMarcaDto(Marca marca) {return new MarcaDto(marca); }

    public List<MarcaDto> toMarcaDto(@NotNull List<Marca> marcaList) {
        return marcaList.stream().map(MarcaDto::new).collect(Collectors.toList());
    }


}
