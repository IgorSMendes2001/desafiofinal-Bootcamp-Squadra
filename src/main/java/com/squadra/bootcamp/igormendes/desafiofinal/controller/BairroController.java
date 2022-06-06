package com.squadra.bootcamp.igormendes.desafiofinal.controller;

import com.squadra.bootcamp.igormendes.desafiofinal.model.BairroDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/bairro"})
public class BairroController {
    @Autowired
    private BairroService bairroService;

    @GetMapping
    public List<BairroDTO> findAll() {
        List<BairroDTO> listBairroDTO = bairroService.findAll();
        return listBairroDTO;
    }

    @GetMapping(params = "codigoBairro")

    public ResponseEntity<BairroDTO> findById(@RequestParam (defaultValue = "") Long codigoBairro) {
        BairroDTO listBairroDTO = bairroService.findById(codigoBairro);
        if (listBairroDTO.getCodigoBairro() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listBairroDTO);
    }
    @GetMapping(params = "codigoMunicipio")

    public ResponseEntity<BairroDTO> findByCodigoMunicipio(@RequestParam (defaultValue = "") Long codigoMunicipio) {
        BairroDTO listBairroDTO = bairroService.findById(codigoMunicipio);
        if (listBairroDTO.getCodigoMunicipio() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listBairroDTO);
    }

    @PostMapping
	public ResponseEntity<BairroDTO> save(@RequestBody BairroDTO bairroDTO) {

		bairroDTO = bairroService.save(bairroDTO);	
		if (bairroDTO.getCodigoBairro() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroDTO);		
	}

   

    @PutMapping
	public ResponseEntity<BairroDTO> update(@RequestBody BairroDTO bairroDTO) {

		bairroDTO = bairroService.update(bairroDTO);

		if (bairroDTO.getCodigoBairro() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroDTO);		
	}

}
