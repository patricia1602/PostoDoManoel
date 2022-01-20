package Bean;

public class AbastecimentoBean {

    private Integer id;
    private Integer idCombustivel;
    private int quantidadeLitro;
    private double valorTotal;
    private Integer idFrentista;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(Integer idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public int getQuantidadeLitro() {
        return quantidadeLitro;
    }

    public void setQuantidadeLitro(int quantidadeLitro) {
        this.quantidadeLitro = quantidadeLitro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getIdFrentista() {
        return idFrentista;
    }

    public void setIdFrentista(Integer idFrentista) {
        this.idFrentista = idFrentista;
    }
}
