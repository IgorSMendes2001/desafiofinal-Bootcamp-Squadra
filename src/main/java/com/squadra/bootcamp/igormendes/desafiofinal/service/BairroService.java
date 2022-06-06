package com.squadra.bootcamp.igormendes.desafiofinal.service;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Bairro;
import com.squadra.bootcamp.igormendes.desafiofinal.model.BairroDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.repository.BairroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BairroService {
    @Autowired
    BairroRepository bairroRepository;

    @Autowired
    private ModelMapper modelMapper;

    BairroService(BairroRepository bairroService){
        this.bairroRepository=bairroService;
    }
    public List<BairroDTO> findAll() {

        List<Bairro> listBairro = bairroRepository.findAll();

        List<BairroDTO> listDto = listBairro.stream()
                .map(pedras -> modelMapper.map(pedras, BairroDTO.class)).collect(Collectors.toList());

        return listDto;
    }
    public BairroDTO findById(Long id) {

        boolean existe = bairroRepository.existsById(id);
        if (existe == true) {
            Bairro bairro = bairroRepository.getReferenceById(id);
            BairroDTO bairroDTO = modelMapper.map(bairro, BairroDTO.class);
            return bairroDTO;
        }
        return new BairroDTO();

    }


    public boolean deleteByid(Long id) {

        boolean existe = bairroRepository.existsById(id);
        if (existe == true) {
            bairroRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public BairroDTO save(BairroDTO bairroDTO) {

        try {
            Bairro bairro = modelMapper.map(bairroDTO, Bairro.class);
            Long id = bairroRepository.save(bairro).getCodigoBairro();
            bairroDTO.setCodigoBairro(id);
            return bairroDTO;

        } catch (Exception e) {
            return new BairroDTO();
        }
    }


    public BairroDTO update(BairroDTO pedrasDto) {

        try {
            Bairro bairro = modelMapper.map(pedrasDto, Bairro.class);
            Long id = bairroRepository.save(bairro).getCodigoBairro();
            return pedrasDto;
        } catch (Exception e) {
            return new BairroDTO();
        }
    }




}
