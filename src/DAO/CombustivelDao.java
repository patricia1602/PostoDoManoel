package DAO;

import Bean.CombustivelBean;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CombustivelDao {

    /* public void salvar(CombustivelBean combustivelBean) throws SQLException {
        
        try {
        
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            
            if (combustivelBean.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO `combustivel` (`nome`,`valor_unidade`) VALUES (?,?)");
            } else {
                ps = conexao.prepareStatement("update combustivel set nome=?, valor_unidade=? where id=?");
                ps.setInt(3, combustivelBean.getId());
            }
            
            ps.setString(1, combustivelBean.getNome());
            ps.setDouble(2, combustivelBean.getValorUnidade());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao tentar salvar!", ex);
        }
    }*/
    public void salvar(CombustivelBean combustivelBean) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO `combustivel` (`nome`,`valor_unidade`) VALUES (?,?)");
            ps.setString(1, combustivelBean.getNome());
            ps.setDouble(2, combustivelBean.getValorUnidade());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao tentar salvar!", ex);
        }
    }
    
     public void alterar(CombustivelBean combustivelBean) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("update combustivel set nome=?, valor_unidade=? where id=?");
            ps.setString(1, combustivelBean.getNome());
            ps.setDouble(2, combustivelBean.getValorUnidade());
            ps.setInt(3, combustivelBean.getId());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao tentar alterar!", ex);
        }
    }

    public void deletar(Integer pId) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from combustivel where id = ?");
            ps.setInt(1, pId);
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao deletar!", ex);
        }
    }

    public List<CombustivelBean> listar() throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from combustivel");
            ResultSet resultSet = ps.executeQuery();
            List<CombustivelBean> listCombustivelBean = new ArrayList<>();
            while (resultSet.next()) {
                CombustivelBean combustivelBean = new CombustivelBean();
                combustivelBean.setId(resultSet.getInt("id"));
                combustivelBean.setNome(resultSet.getString("nome"));
                combustivelBean.setValorUnidade(resultSet.getDouble("valor_unidade"));
                listCombustivelBean.add(combustivelBean);
            }
            Conexao.fecharConexao();
            return listCombustivelBean;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar!", ex);
        }
    }

    public List<CombustivelBean> buscar(String param) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from combustivel where id like '%" + param + "%' || nome like '%" + param + "%' || valor_unidade like '%" + param + "%'");
            ResultSet resultSet = ps.executeQuery();
            List<CombustivelBean> listCombustivelBean = new ArrayList<>();
            while (resultSet.next()) {
                CombustivelBean combustivelBean = new CombustivelBean();
                combustivelBean.setId(resultSet.getInt("id"));
                combustivelBean.setNome(resultSet.getString("nome"));
                combustivelBean.setValorUnidade(resultSet.getDouble("valor_unidade"));
                listCombustivelBean.add(combustivelBean);
            }
            Conexao.fecharConexao();
            return listCombustivelBean;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar!", ex);
        }
    }
}
