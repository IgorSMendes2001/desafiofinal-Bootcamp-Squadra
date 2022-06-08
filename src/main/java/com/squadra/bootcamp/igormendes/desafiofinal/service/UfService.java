package com.squadra.bootcamp.igormendes.desafiofinal.service;

import java.util.List;
import java.util.stream.Collectors;

import com.squadra.bootcamp.igormendes.desafiofinal.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Uf;
import com.squadra.bootcamp.igormendes.desafiofinal.model.UfDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.repository.UfRepository;

@Service
public class UfService {
    @Autowired
    UfRepository ufRepository;

    @Autowired
    private ModelMapper modelMapper;

    UfService(UfRepository ufService){
        this.ufRepository =ufService;
    }
    public List<UfDTO> findAll() {

        List<Uf> listUf = ufRepository.findAll();

        List<UfDTO> listDto = listUf.stream()
                .map(uf -> modelMapper.map(uf, UfDTO.class)).collect(Collectors.toList());

        return listDto;
    }
    public UfDTO findByid(Long id) {

        boolean existe = ufRepository.existsById(id);
        if (existe == true) {
            Uf uf = ufRepository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException("Recurso não encontrado"+id));
            UfDTO ufDTO = modelMapper.map(uf, UfDTO.class);
            return ufDTO;
        }
        return new UfDTO();

    }

    public UfDTO save(UfDTO ufDTO) {

        try {
            Uf uf = modelMapper.map(ufDTO, Uf.class);
            Long id = ufRepository.save(uf).getCodigoUF();
            ufDTO.setCodigoUF(id);
            return ufDTO;

        } catch (Exception e) {
            return new UfDTO();
        }
    }


    public UfDTO update(UfDTO pessoaDTO) {

        try {
             modelMapper.map(pessoaDTO, Uf.class);
            return pessoaDTO;
        } catch (Exception e) {
            return new UfDTO();
        }
    }

    public UfDTO findBySigla(String sigla) {
            Uf uf = ufRepository.findBySigla(sigla);
            UfDTO ufDTO = modelMapper.map(uf, UfDTO.class);
            return ufDTO;
    }
    public UfDTO findByNome(String nome) {
        Uf uf = ufRepository.findByNome(nome);
        UfDTO ufDTO = modelMapper.map(uf, UfDTO.class);
        return ufDTO;
    }
    public List<UfDTO> findByStatus(Integer status) {
        List<Uf> listUf = ufRepository.findByStatus(status);
        List<UfDTO> listUfDTO = listUf.stream()
                .map(uf -> modelMapper.map(uf, UfDTO.class)).collect(Collectors.toList());
        return listUfDTO;
    }
}
