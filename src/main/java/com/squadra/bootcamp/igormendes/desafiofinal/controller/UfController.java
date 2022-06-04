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

    @GetMapping(path = "/{codigoUf}")
    public ResponseEntity<UfDTO> findById(@PathVariable Long codigoUf) {
        UfDTO listaUfDTO = ufService.findByid(codigoUf);
        if (listaUfDTO.getCodigoUF() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaUfDTO);
    }
    @DeleteMapping(path = "/{codigoUf}")
	public ResponseEntity<String> deleteById(@PathVariable Long codigoUf) {

		boolean sucesso = ufService.deleteByid(codigoUf);
		if (sucesso == true) {
			return ResponseEntity.ok("Registro Deletado");
		}
		return ResponseEntity.badRequest().body("Registro contêm vínculos, não pode ser removido");

	}

   
    @PostMapping
	public ResponseEntity<UfDTO> save(@RequestBody UfDTO ufDTO) {

		ufDTO = ufService.save(ufDTO);	
		if (ufDTO.getCodigoUF() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(ufDTO);		
	}

   

    @PutMapping
	public ResponseEntity<UfDTO> update(@RequestBody UfDTO ufDTO) {

		ufDTO = ufService.update(ufDTO);

		if (ufDTO.getCodigoUF() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(ufDTO);		
	}
}
