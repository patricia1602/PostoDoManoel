package Testes;

import Bean.FrentistaBean;
import Service.FrentistaService;
import java.sql.SQLException;
import java.util.List;

public class FrentistaTestes {
    
    FrentistaService frentistaService = new FrentistaService();
    
    public static void main(String[] args) throws SQLException {
        FrentistaTestes t = new FrentistaTestes();

        //t.deletar(5);
        t.listar();
        //t.buscar("GNV");
        
    }

    //listar
    public void listar() throws SQLException {
        List<FrentistaBean> listaFrentista = frentistaService.listar();
        mostraFrentista(listaFrentista);
    }

    //buscar
    public void buscar(String param) throws SQLException {
        List<FrentistaBean> listaFrentista = frentistaService.buscar(param);
        
        if (!listaFrentista.isEmpty()) {
            mostraFrentista(listaFrentista);
        } else {
            System.out.println("Nenhum frentista '" + param + "' encontrado.");
        }
    }
    
    public void salvar(FrentistaBean pFrentistaBean) throws SQLException {
        frentistaService.salvar(pFrentistaBean);
        buscar(pFrentistaBean.getNome());
    }
    
    public void deletar(Integer pId) throws SQLException {
        frentistaService.deletar(pId);
        
    }
    
    public void mostraFrentista(List<FrentistaBean> listaFrentista) {
        for (int i = 0; i < listaFrentista.size(); i++) {
            System.out.println("\n<------------------------------------------->\n");
            System.out.println(" ID: " + listaFrentista.get(i).getId());
            System.out.println(" NOME: " + listaFrentista.get(i).getNome());
            System.out.println("\n<------------------------------------------->\n");
        }
    }
}
