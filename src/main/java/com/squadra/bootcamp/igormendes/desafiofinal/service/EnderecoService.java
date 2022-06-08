package com.squadra.bootcamp.igormendes.desafiofinal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Endereco;
import com.squadra.bootcamp.igormendes.desafiofinal.model.EnderecoDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    private ModelMapper modelMapper;

    EnderecoService(EnderecoRepository enderecoService){
        this.enderecoRepository =enderecoService;
    }

    public EnderecoDTO save(EnderecoDTO enderecoDTO) {

        try {
            Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
            Long id = enderecoRepository.save(endereco).getCodigoEndereco();
            enderecoDTO.setCodigoEndereco(id);
            return enderecoDTO;

        } catch (Exception e) {
            return new EnderecoDTO();
        }
    }


    public EnderecoDTO update(EnderecoDTO enderecoDTO) {

        try {
            Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
            enderecoRepository.save(endereco).getCodigoEndereco();
            return enderecoDTO;
        } catch (Exception e) {
            return new EnderecoDTO();
        }
    }

    public List<EnderecoDTO> findByEndereco() {
        List<Endereco> listEndereco = enderecoRepository.findAll();

        List<EnderecoDTO> listDto = listEndereco.stream()
                .map(endereco -> modelMapper.map(endereco, EnderecoDTO.class)).collect(Collectors.toList());

        return listDto;
    }
}
