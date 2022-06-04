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

import com.squadra.bootcamp.igormendes.desafiofinal.model.MunicipioDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.service.MunicipioService;

@RestController
@RequestMapping({"/municipio"})
public class MunicipioContoller {
    @Autowired
    private MunicipioService municipioService;

    @GetMapping
    public List<MunicipioDTO> findAll() {
        List<MunicipioDTO> listMunicipiosDTO = municipioService.findAll();
        return listMunicipiosDTO;
    }

    @GetMapping(path = "/{codigoMunicipio}")
    public ResponseEntity<MunicipioDTO> findById(@PathVariable Long codigoMunicipio) {
        MunicipioDTO listBairroDTO = municipioService.findByid(codigoMunicipio);
        if (listBairroDTO.getCodigoMunicipio() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listBairroDTO);
    }
    @DeleteMapping(path = "/{codigoMunicipio}")
	public ResponseEntity<String> deleteById(@PathVariable Long codigoMunicipio) {

		boolean sucesso = municipioService.deleteByid(codigoMunicipio);
		if (sucesso == true) {
			return ResponseEntity.ok("Registro Deletado");
		}
		return ResponseEntity.badRequest().body("Registro contêm vínculos, não pode ser removido");

	}

   
    @PostMapping
	public ResponseEntity<MunicipioDTO> save(@RequestBody MunicipioDTO bairroDTO) {

		bairroDTO = municipioService.save(bairroDTO);	
		if (bairroDTO.getCodigoMunicipio() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroDTO);		
	}

   

    @PutMapping
	public ResponseEntity<MunicipioDTO> update(@RequestBody MunicipioDTO bairroDTO) {

		bairroDTO = municipioService.update(bairroDTO);

		if (bairroDTO.getCodigoMunicipio() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroDTO);		
	}
}
