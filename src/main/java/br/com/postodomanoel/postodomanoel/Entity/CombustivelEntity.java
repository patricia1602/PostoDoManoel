package br.com.postodomanoel.postodomanoel.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "combustivel")
@Getter
@Setter
@EqualsAndHashCode
public class CombustivelEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "combustivel")
    private String nome;

    @Column(name = "valor_unidade")
    private double valorUnidade;
}
