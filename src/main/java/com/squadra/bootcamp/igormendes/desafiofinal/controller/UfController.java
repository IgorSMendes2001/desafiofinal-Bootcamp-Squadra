package com.squadra.bootcamp.igormendes.desafiofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.squadra.bootcamp.igormendes.desafiofinal.model.UfDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.service.UfService;

@RestController
@RequestMapping({"/uf"})
public class UfController {
    @Autowired
    private UfService ufService;

    @GetMapping
    public List<UfDTO> findAll() {
        List<UfDTO> listaUfDTO = ufService.findAll();
        return listaUfDTO;
    }

    @GetMapping(params = "codigoUf")
    public ResponseEntity<UfDTO> findByCodigoUf(@RequestParam Long codigoUf) {
        UfDTO ufDTO = ufService.findByid(codigoUf);
        return ResponseEntity.ok(ufDTO);
    }
    @GetMapping(params = "sigla")
    public ResponseEntity<UfDTO> findBySigla(@RequestParam  String sigla) {
            UfDTO ufDTO = ufService.findBySigla(sigla);
            return ResponseEntity.ok(ufDTO);
    }
    @GetMapping(params = "nome")
    public ResponseEntity<UfDTO> findByNome(@RequestParam  String nome) {
            UfDTO ufDTO = ufService.findByNome(nome);
            return ResponseEntity.ok(ufDTO);
        }
       
    @GetMapping(params = "status")
    public  List<UfDTO> findByStatus(@RequestParam  Integer status) {
        List<UfDTO> listaUfDTO = ufService.findByStatus(status);
        return listaUfDTO;
    }
    @PostMapping
	public ResponseEntity<UfDTO> save( @RequestBody @Valid UfDTO ufDTO) {
		ufDTO = ufService.save(ufDTO);	
		return ResponseEntity.status(HttpStatus.OK).body(ufDTO);
	}

   

    @PutMapping
	public ResponseEntity<UfDTO> update(@RequestBody @Valid UfDTO ufDTO) {
            ufDTO = ufService.update(ufDTO);
            return ResponseEntity.status(HttpStatus.OK).body(ufDTO);
				
	}
}
