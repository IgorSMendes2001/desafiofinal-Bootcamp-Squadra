package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="tb_endereco")
public class Endereco{
    @Id
    @Column(name = "CODIGO_ENDERECO")
    @GeneratedValue(generator = "endereco_sequence" ,strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "endereco_sequence",sequenceName="end_seq")
    private Long codigoEndereco;
    @ManyToOne
    @JoinColumn(name = "CODIGO_PESSOA")
    private Pessoa codigoPessoa;
    @ManyToOne
    // @JoinColumn(name="CODIGO_BAIRRO")
    private Bairro codigoBairro;
    @Column(name = "NOME_RUA")
    private String nomeRua;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "CEP")
    private String cep;
}
