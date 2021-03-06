package Testes;

import Bean.AbastecimentoBean;
import Service.AbastecimentoService;
import java.sql.SQLException;
import java.util.List;

public class AbastecimentoTestes {

    AbastecimentoService abastecimentoService = new AbastecimentoService();

    public static void main(String[] args) throws SQLException {

        AbastecimentoTestes t = new AbastecimentoTestes();
        AbastecimentoBean pAbastecimentoBean = new AbastecimentoBean();

        //t.deletar(4);
        //t.listar();
        t.buscar("1");
        /*  
        pAbastecimentoBean.setIdCombustivel(2);
        pAbastecimentoBean.setQuantidadeLitro(1);
        pAbastecimentoBean.setValorTotal(0.99);
        pAbastecimentoBean.setIdFrentista(2);
        t.salvar(pAbastecimentoBean);
        */
    }

    //listar
    public void listar() throws SQLException {
        List<AbastecimentoBean> listaAbastecimento = abastecimentoService.listar();
        mostraAbastecimento(listaAbastecimento);
    }

    //buscar
    public void buscar(String param) throws SQLException {
        List<AbastecimentoBean> listaAbastecimento = abastecimentoService.buscar(param);

        if (!listaAbastecimento.isEmpty()) {
            mostraAbastecimento(listaAbastecimento);
        } else {
            System.out.println("Nenhum abastecimento '" + param + "' encontrado.");

        }
    }

    public void salvar(AbastecimentoBean pAbastecimentoBean) throws SQLException {
        abastecimentoService.salvar(pAbastecimentoBean);
        // buscar(pAbastecimentoBean.getIdCombustivel());
    }

    public void deletar(Integer pId) throws SQLException {
        abastecimentoService.deletar(pId);
    }

    public void mostraAbastecimento(List<AbastecimentoBean> listaAbastecimento) {
        for (int i = 0; i < listaAbastecimento.size(); i++) {
            System.out.println("\n<------------------------------------------->\n");
            System.out.println("ID: " + listaAbastecimento.get(i).getId());
            System.out.println("ID_COMBUSTIVEL:" + listaAbastecimento.get(i).getIdCombustivel());
            System.out.println("QUANTIDADE_LITRO:" + listaAbastecimento.get(i).getQuantidadeLitro());
            System.out.println("VALOR_TOTAL:" + listaAbastecimento.get(i).getValorTotal());
            System.out.println("ID_FRENTISTA:" + listaAbastecimento.get(i).getIdFrentista());
            System.out.println("\n<------------------------------------------->\n");
        }
    }
}
