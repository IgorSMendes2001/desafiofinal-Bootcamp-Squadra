package com.squadra.bootcamp.igormendes.desafiofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.squadra.bootcamp.igormendes.desafiofinal.error.ErrorDetail;
//import com.squadra.bootcamp.igormendes.desafiofinal.exception.ResourceNotFoundException;
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

    @GetMapping(params = "codigoMunicipio")
    public ResponseEntity<MunicipioDTO> findById(@RequestParam (defaultValue = "") Long codigoMunicipio) {
        MunicipioDTO listMunicipiosDTO = municipioService.findById(codigoMunicipio);
        if (listMunicipiosDTO.getCodigoMunicipio() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listMunicipiosDTO);
    }
    @GetMapping(params = "codigoUf")
    public ResponseEntity<MunicipioDTO> findByUf(@RequestParam (defaultValue = "") Long codigoUf) {
        MunicipioDTO listMunicipiosDTO = municipioService.findByCodigoUf(codigoUf);
        if (listMunicipiosDTO.getCodigoUF() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listMunicipiosDTO);
    }



    @PostMapping
    public ResponseEntity<MunicipioDTO> save(@RequestBody MunicipioDTO municipioDTO) {

        municipioDTO = municipioService.save(municipioDTO);
        if (municipioDTO.getCodigoMunicipio() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(municipioDTO);
    }



    @PutMapping
    public ResponseEntity<MunicipioDTO> update(@RequestBody MunicipioDTO municipioDTO) {

        municipioDTO = municipioService.update(municipioDTO);

        if (municipioDTO.getCodigoMunicipio() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(municipioDTO);
    }
}