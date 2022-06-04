package com.squadra.bootcamp.igormendes.desafiofinal.controller;

import com.squadra.bootcamp.igormendes.desafiofinal.model.BairroDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.service.BairroService;
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

    @GetMapping(path = "/{codigoBairro}")
    public ResponseEntity<BairroDTO> findById(@PathVariable Long codigoBairro) {
        BairroDTO listBairroDTO = bairroService.findById(codigoBairro);
        if (listBairroDTO.getCodigoBairro() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listBairroDTO);
    }
    @DeleteMapping(path = "/{codigoBairro}")
	public ResponseEntity<String> deleteById(@PathVariable Long codigoBairro) {

		boolean sucesso = bairroService.deleteByid(codigoBairro);
		if (sucesso == true) {
			return ResponseEntity.ok("Registro Deletado");
		}
		return ResponseEntity.badRequest().body("Registro contêm vínculos, não pode ser removido");

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
