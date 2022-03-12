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
@Table(name = "abastecimento")
@Getter
@Setter
@EqualsAndHashCode
public class AbastecimentoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "id_combustivel")
    private Integer combustivel;

    @Column(name = "id_frentista")
    private Integer frentista;

    @Column(name = "quantidade_litro")
    private int qtdLitro;

    @Column(name = "valor_total")
    private double valorTotal;

}
