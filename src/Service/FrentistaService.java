package Service;

import Bean.FrentistaBean;
import DAO.FrentistaDao;
import java.sql.SQLException;
import java.util.List;

public class FrentistaService {

         FrentistaDao frentistaDao = new FrentistaDao();
    
    public void salvar(FrentistaBean pFrentistaBean) throws SQLException {
        if (pFrentistaBean.getId() == null) {
            frentistaDao.salvar(pFrentistaBean);    
        } else {
            frentistaDao.alterar(pFrentistaBean);
        }       
    }
    
    public void deletar(Integer pId) throws SQLException {
        frentistaDao.deletar(pId);
    }
    
    public List<FrentistaBean> listar() throws SQLException {
        List<FrentistaBean> listaFrentistaBean = frentistaDao.listar();
        return listaFrentistaBean;
    }
    
    public List<FrentistaBean> buscar(String param) throws SQLException {
        List<FrentistaBean> listaFrentistaBean = frentistaDao.buscar(param);
        return  listaFrentistaBean;
    
    }
}

