package com.squadra.bootcamp.igormendes.desafiofinal.repository;

import com.squadra.bootcamp.igormendes.desafiofinal.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
