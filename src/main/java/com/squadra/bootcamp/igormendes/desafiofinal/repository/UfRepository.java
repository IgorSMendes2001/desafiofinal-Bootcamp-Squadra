package com.squadra.bootcamp.igormendes.desafiofinal.repository;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Uf;

import antlr.collections.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long> {
    Uf findByNome(String nome);
    Uf findByStatus(int status);
    Uf findBySigla(String sigla);
}
