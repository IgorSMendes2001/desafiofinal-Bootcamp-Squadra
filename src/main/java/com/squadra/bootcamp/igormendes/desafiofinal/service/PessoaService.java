package com.squadra.bootcamp.igormendes.desafiofinal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Pessoa;
import com.squadra.bootcamp.igormendes.desafiofinal.model.PessoaDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    private ModelMapper modelMapper;

    PessoaService(PessoaRepository pessoaService){
        this.pessoaRepository =pessoaService;
    }
    public List<PessoaDTO> findAll() {

        List<Pessoa> listPessoa = pessoaRepository.findAll();

        List<PessoaDTO> listDto = listPessoa.stream()
                .map(pessoas -> modelMapper.map(pessoas, PessoaDTO.class)).collect(Collectors.toList());

        return listDto;
    }
    public PessoaDTO findByid(Long id) {

        boolean existe = pessoaRepository.existsById(id);
        if (existe == true) {
            Pessoa pessoa = pessoaRepository.getReferenceById(id);
            PessoaDTO pessoaDTO = modelMapper.map(pessoa, PessoaDTO.class);
            return pessoaDTO;
        }
        return new PessoaDTO();

    }


    public boolean deleteByid(Long id) {

        boolean existe = pessoaRepository.existsById(id);
        if (existe == true) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public PessoaDTO save(PessoaDTO pessoaDTO) {

        try {
            Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
            Long id = pessoaRepository.save(pessoa).getCodigoPessoa();
            pessoaDTO.setCodigoPessoa(id);
            return pessoaDTO;

        } catch (Exception e) {
            return new PessoaDTO();
        }
    }


    public PessoaDTO update(PessoaDTO pessoaDTO) {

        try {
            Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
            Long id = pessoaRepository.save(pessoa).getCodigoPessoa();
            return pessoaDTO;
        } catch (Exception e) {
            return new PessoaDTO();
        }
    }
}
