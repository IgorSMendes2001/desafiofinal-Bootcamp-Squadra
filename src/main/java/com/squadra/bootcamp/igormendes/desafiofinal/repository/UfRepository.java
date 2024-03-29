package com.squadra.bootcamp.igormendes.desafiofinal.repository;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Uf;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long> {
    Uf findByNome(String nome);
    List<Uf> findByStatus(Integer status);
    Uf findBySigla(String sigla);
}
