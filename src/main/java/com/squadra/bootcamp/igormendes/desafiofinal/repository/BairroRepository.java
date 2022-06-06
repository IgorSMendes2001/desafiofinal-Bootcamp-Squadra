package com.squadra.bootcamp.igormendes.desafiofinal.repository;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro,Long> {

}
