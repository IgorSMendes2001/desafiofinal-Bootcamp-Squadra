package com.squadra.bootcamp.igormendes.desafiofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squadra.bootcamp.igormendes.desafiofinal.model.PessoaDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.service.PessoaService;

@RestController
@RequestMapping({"/pessoa"})
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> findAll() {
        List<PessoaDTO> listPessoaDTO = pessoaService.findAll();
        return listPessoaDTO;
    }

    @GetMapping(path = "/{codigoPessoa}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long codigoPessoa) {
        PessoaDTO listPessoaDTO = pessoaService.findByid(codigoPessoa);
        if (listPessoaDTO.getCodigoPessoa() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listPessoaDTO);
    }
    @DeleteMapping(path = "/{codigoPessoa}")
	public ResponseEntity<String> deleteById(@PathVariable Long codigoPessoa) {

		boolean sucesso = pessoaService.deleteByid(codigoPessoa);
		if (sucesso == true) {
			return ResponseEntity.ok("Registro Deletado");
		}
		return ResponseEntity.badRequest().body("Registro contêm vínculos, não pode ser removido");

	}

   
    @PostMapping
	public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoaDTO) {

		pessoaDTO = pessoaService.save(pessoaDTO);	
		if (pessoaDTO.getCodigoPessoa() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);		
	}

   

    @PutMapping
	public ResponseEntity<PessoaDTO> update(@RequestBody PessoaDTO bairroDTO) {

		bairroDTO = pessoaService.update(bairroDTO);

		if (bairroDTO.getCodigoPessoa() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroDTO);		
	}
}
