package com.squadra.bootcamp.igormendes.desafiofinal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="tb_endereco")
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(generator = "endereco_sequence" ,strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "endereco_sequence",sequenceName="end_seq")
    @Column(name = "CODIGO_ENDERECO")
    private Long codigoEndereco;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CODIGO_PESSOA")
    private Pessoa codigoPessoa;
    @ManyToOne
     @JoinColumn(name="CODIGO_BAIRRO")
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
