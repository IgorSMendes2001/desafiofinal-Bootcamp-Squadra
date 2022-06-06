package com.squadra.bootcamp.igormendes.desafiofinal.service;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Municipio;
import com.squadra.bootcamp.igormendes.desafiofinal.model.MunicipioDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.repository.MunicipioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioService {
    @Autowired
    MunicipioRepository municipioRepository;

    @Autowired
    private ModelMapper modelMapper;

    MunicipioService(MunicipioRepository municipioService){
        this.municipioRepository =municipioService;
    }
    public List<MunicipioDTO> findAll() {

        List<Municipio> listMunicipio = municipioRepository.findAll();

        List<MunicipioDTO> listDto = listMunicipio.stream()
                .map(pedras -> modelMapper.map(pedras, MunicipioDTO.class)).collect(Collectors.toList());

        return listDto;
    }
    public MunicipioDTO findByid(Long id) {

        boolean existe = municipioRepository.existsById(id);
        if (existe == true) {
            Municipio municipio = municipioRepository.getReferenceById(id);
            MunicipioDTO municipioDTO = modelMapper.map(municipio, MunicipioDTO.class);
            return municipioDTO;
        }
        return new MunicipioDTO();

    }


    public boolean deleteByid(Long id) {

        boolean existe = municipioRepository.existsById(id);
        if (existe == true) {
            municipioRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public MunicipioDTO save(MunicipioDTO municipioDTO) {

        try {
            Municipio municipio = modelMapper.map(municipioDTO, Municipio.class);
            Long id = municipioRepository.save(municipio).getCodigoMunicipio();
            municipioDTO.setCodigoMunicipio(id);
            return municipioDTO;

        } catch (Exception e) {
            return new MunicipioDTO();
        }
    }


    public MunicipioDTO update(MunicipioDTO municipioDTO) {

        try {
            Municipio municipio = modelMapper.map(municipioDTO, Municipio.class);
            Long id = municipioRepository.save(municipio).getCodigoMunicipio();
            return municipioDTO;
        } catch (Exception e) {
            return new MunicipioDTO();
        }
    }
}
