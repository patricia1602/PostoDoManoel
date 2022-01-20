package Service;

import Bean.AbastecimentoBean;
import DAO.AbastecimentoDao;
import java.sql.SQLException;
import java.util.List;

public class AbastecimentoService {

    AbastecimentoDao abastecimentoDao = new AbastecimentoDao();

    public void salvar(AbastecimentoBean pAbastecimentoBean) throws SQLException {
        if (pAbastecimentoBean.getId() == null) {
            abastecimentoDao.salvar(pAbastecimentoBean);
        } else {
            abastecimentoDao.alterar(pAbastecimentoBean);
        }
    }

    public void deletar(Integer pId) throws SQLException {
        abastecimentoDao.deletar(pId);
    }

    public List<AbastecimentoBean> listar() throws SQLException {
        List<AbastecimentoBean> listaAbastecimentoBean = abastecimentoDao.listar();
        return listaAbastecimentoBean;
    }

    public List<AbastecimentoBean> buscar(String param) throws SQLException {
        List<AbastecimentoBean> listaAbastecimentoBean = abastecimentoDao.buscar(param);
        return listaAbastecimentoBean;

    }
}
