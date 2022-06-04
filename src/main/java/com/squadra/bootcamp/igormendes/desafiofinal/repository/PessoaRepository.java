package com.squadra.bootcamp.igormendes.desafiofinal.repository;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    
}
