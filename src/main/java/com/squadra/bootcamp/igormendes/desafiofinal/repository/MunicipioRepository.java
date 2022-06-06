package com.squadra.bootcamp.igormendes.desafiofinal.repository;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Long> {

}
