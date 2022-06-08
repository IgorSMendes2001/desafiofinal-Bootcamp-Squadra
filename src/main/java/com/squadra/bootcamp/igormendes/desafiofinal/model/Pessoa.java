package com.squadra.bootcamp.igormendes.desafiofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;


import java.util.List;

import javax.persistence.*;


@Data
@Entity
@Table(name = "tb_pessoa")
public class Pessoa{
    @Id
    @GeneratedValue(generator = "pessoa_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "pessoa_sequence",sequenceName = "pes_seq")
    @Column(name = "CODIGO_PESSOA")
    private Long codigoPessoa;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
    @Column(name = "NOME",unique = true)
    private String nome;
    @Column(name = "SOBRENOME")
    private String sobrenome;
    @Column(name = "IDADE")
    private int idade;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "SENHA",unique = true)
    private String senha;
    @Column(name = "STATUS")
    private Integer status;
    public Pessoa(){

    }

}
