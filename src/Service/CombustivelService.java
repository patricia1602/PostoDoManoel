/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Bean.CombustivelBean;
import DAO.CombustivelDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author leona
 */
public class CombustivelService {
    
    CombustivelDao combustivelDao = new CombustivelDao();
    
    public void salvar(CombustivelBean pCombustivelBean) throws SQLException {
        if (pCombustivelBean.getId() == null) {
            combustivelDao.salvar(pCombustivelBean);    
        } else {
            combustivelDao.alterar(pCombustivelBean);
        }       
    }
    
    public void deletar(Integer pId) throws SQLException {
        combustivelDao.deletar(pId);
    }
    
    public List<CombustivelBean> listar() throws SQLException {
        List<CombustivelBean> listaCombustivelBean = combustivelDao.listar();
        return listaCombustivelBean;
    }
    
    public List<CombustivelBean> buscar(String param) throws SQLException {
        List<CombustivelBean> listaCombustivelBean = combustivelDao.buscar(param);
        return listaCombustivelBean;
    }
    
}
