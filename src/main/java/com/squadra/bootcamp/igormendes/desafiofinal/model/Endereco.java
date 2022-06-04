package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="tb_endereco")
public class Endereco{
    @Id
    @GeneratedValue(generator = "endereco_sequence" ,strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "endereco_sequence")
    private Long codigoEndereco;
    @Column(name = "codigo_pessoa")
    private Pessoa codigoPessoa;
    @Column(name="codigo_bairro")
    private Bairro codigoBairro;
    private String nomeRua;
    private String numero;
    private String complemento;
    private String cep;
}
