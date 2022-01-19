package Bean;

import java.math.BigDecimal;

public class AbastecimentoBean {

    private Integer id;
    private String idCombustivel;
    private int quantidadeLitro;
    private BigDecimal valorTotal;
    private String idFrentista;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeLitro() {
        return quantidadeLitro;
    }

    public void setQuantidadeLitro(int quantidadeLitro) {
        this.quantidadeLitro = quantidadeLitro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getIdFrentista() {
        return idFrentista;
    }

    public void setIdFrentista(String idFrentista) {
        this.idFrentista = idFrentista;
    }

    public String getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(String idCombustivel) {
        this.idCombustivel = idCombustivel;
    }
    
    
   
}
