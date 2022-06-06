package com.squadra.bootcamp.igormendes.desafiofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public ResponseEntity<UfDTO> findByCodigoUf(@RequestParam (required = false, defaultValue="") Long codigoUf) {
        UfDTO listaUfDTO = ufService.findByid(codigoUf);
        if (listaUfDTO.getCodigoUF() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaUfDTO);
    }
    @GetMapping(params = "sigla")
    public ResponseEntity<UfDTO> findBySigla(@RequestParam (required = false,defaultValue = "") String sigla) {
        UfDTO listaUfDTO = ufService.findBySigla(sigla);
        if (listaUfDTO.getSigla() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaUfDTO);
    }
    @GetMapping(params = "nome")
    public ResponseEntity<UfDTO> findByNome(@RequestParam (required = false,defaultValue = "") String nome) {
        UfDTO listaUfDTO = ufService.findByNome(nome);
        if (listaUfDTO.getNome() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaUfDTO);
    }
    @GetMapping(params = "status")
    public ResponseEntity<UfDTO> findByStatus(@RequestParam (required = false,defaultValue = "") int status) {
        UfDTO listaUfDTO = ufService.findByStatus(status);
        if (listaUfDTO.getStatus() !=1||listaUfDTO.getStatus()!=2) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaUfDTO);
    }
    @PostMapping
	public ResponseEntity<UfDTO> save(@Valid @RequestBody UfDTO ufDTO) {

		ufDTO = ufService.save(ufDTO);	
		if (ufDTO.getCodigoUF() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ufDTO);		
	}

   

    @PutMapping
	public ResponseEntity<UfDTO> update(@RequestBody UfDTO ufDTO) {

		ufDTO = ufService.update(ufDTO);

		if (ufDTO.getCodigoUF() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ufDTO);		
	}
}
