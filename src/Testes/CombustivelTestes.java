package Testes;

import Bean.CombustivelBean;
import Service.CombustivelService;
import java.sql.SQLException;
import java.util.List;

public class CombustivelTestes {

    CombustivelService combustivelService = new CombustivelService();

    public static void main(String[] args) throws SQLException {
        CombustivelTestes t = new CombustivelTestes();

        //t.deletar(5);
        t.listar();
        //t.buscar("GNV");

        /*CombustivelBean pCombustivelBean = new CombustivelBean();
 pCombustivelBean.setNome("Diesel");
 pCombustivelBean.setValorUnidade(1.10);
 t.salvar(pCombustivelBean);*/
    }

    //listar
    public void listar() throws SQLException {
        List<CombustivelBean> listaCombustiveis = combustivelService.listar();
        mostraCombustiveis(listaCombustiveis);
    }

    //buscar
    public void buscar(String param) throws SQLException {
        List<CombustivelBean> listaCombustiveis = combustivelService.buscar(param);

        if (!listaCombustiveis.isEmpty()) {
            mostraCombustiveis(listaCombustiveis);
        } else {
            System.out.println("Nenhum combustivel '" + param + "' encontrado.");

        }
    }

    public void salvar(CombustivelBean pCombustivelBean) throws SQLException {
        combustivelService.salvar(pCombustivelBean);
        buscar(pCombustivelBean.getNome());
    }

    public void deletar(Integer pId) throws SQLException {
        combustivelService.deletar(pId);
    }

    public void mostraCombustiveis(List<CombustivelBean> listaCombustiveis) {
        for (int i = 0; i < listaCombustiveis.size(); i++) {
            System.out.println("\n<------------------------------------------->\n");
            System.out.println(" ID: " + listaCombustiveis.get(i).getId());
            System.out.println(" NOME: " + listaCombustiveis.get(i).getNome());
            System.out.println(" VALOR_UNIDADE: " + listaCombustiveis.get(i).getValorUnidade());
            System.out.println("\n<------------------------------------------->\n");
        }
    }
}
