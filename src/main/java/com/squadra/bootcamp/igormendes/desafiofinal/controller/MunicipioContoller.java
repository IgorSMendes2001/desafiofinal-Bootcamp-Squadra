package com.squadra.bootcamp.igormendes.desafiofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/municipio")
    public ResponseEntity<MunicipioDTO> findById(@RequestParam Long codigoMunicipio) {
        MunicipioDTO listMunicipiosDTO = municipioService.findByid(codigoMunicipio);
        if (listMunicipiosDTO.getCodigoMunicipio() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listMunicipiosDTO);
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
	public ResponseEntity<MunicipioDTO> save(@RequestBody MunicipioDTO municipioDTO) {

		municipioDTO = municipioService.save(municipioDTO);
		if (municipioDTO.getCodigoMunicipio() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(municipioDTO);
	}

   

    @PutMapping
	public ResponseEntity<MunicipioDTO> update(@RequestBody MunicipioDTO municipioDTO) {

		municipioDTO = municipioService.update(municipioDTO);

		if (municipioDTO.getCodigoMunicipio() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(municipioDTO);
	}
}
