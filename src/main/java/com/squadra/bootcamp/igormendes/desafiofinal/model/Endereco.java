package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull(message = "Código da Pessoa é obrigatório")
    private Pessoa codigoPessoa;
    @ManyToOne
    // @JoinColumn(name="CODIGO_BAIRRO")
    @NotNull(message = "Código do Bairro é obrigatório")
    private Bairro codigoBairro;
    @Column(name = "NOME_RUA")
    @NotNull(message = "Nome da rua é obrigatório")
    @Size(min=1,max = 50)
    private String nomeRua;
    @Column(name = "NUMERO")
    @NotNull(message = "Número é obrigatório")
    private String numero;
    @Column(name = "COMPLEMENTO")
    @Size(min=1,max = 50)
    private String complemento;
    @Column(name = "CEP")
    @NotNull(message = "CEP é obrigatório")
    @Size(min=8,max = 8)
    private String cep;
}
