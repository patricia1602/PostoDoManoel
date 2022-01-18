package DAO;

import Bean.FrentistaBean;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FrentistaDao {

    public void salvar(FrentistaBean frentistaBean) throws SQLException {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO 'frentista'('nome')values(?)");
            ps.setString(1, frentistaBean.getNome());

            ps.execute();
            Conexao.fecharConexao();
        } catch (Exception e) {
            throw new SQLException("Erro ao tentar salvar!", e);
        }
    }

    public void alterar(FrentistaBean frentistaBean) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("update frentista set nome=? where id=?");
            ps.setString(1, frentistaBean.getNome());
            ps.setInt(2, frentistaBean.getId());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao tentar alterar!", ex);
        }
    }

    public void deletar(Integer pId) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from fentista where id = ?");
            ps.setInt(1, pId);
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao deletar!", ex);
        }
    }

    public List<FrentistaBean> listar() throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from frentista");
            ResultSet resultSet = ps.executeQuery();
            List<FrentistaBean> listFrentistaBeans = new ArrayList<>();
            while (resultSet.next()) {
                FrentistaBean frentistaBean = new FrentistaBean();
                frentistaBean.setId(resultSet.getInt("id"));
                frentistaBean.setNome(resultSet.getString("nome"));
                listFrentistaBeans.add(frentistaBean);
            }
            Conexao.fecharConexao();
            return listFrentistaBeans;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar!", ex);
        }
    }

    public List<FrentistaBean> buscar(String param) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from frentista where id like '%" + param + "%' || nome like '%" + param + "%'");
            ResultSet resultSet = ps.executeQuery();
            List<FrentistaBean> listFrentistaBean = new ArrayList<>();
            while (resultSet.next()) {
                FrentistaBean frentistaBean = new FrentistaBean();
                frentistaBean.setId(resultSet.getInt("id"));
                frentistaBean.setNome(resultSet.getString("nome"));
                listFrentistaBean.add(frentistaBean);
            }
            Conexao.fecharConexao();
            return listFrentistaBean;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar!", ex);
        }
    }
}
