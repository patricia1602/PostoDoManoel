package DAO;

import Bean.AbastecimentoBean;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbastecimentoDao {

    public void salvar(AbastecimentoBean abastecimentoBean) throws SQLException {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO abastecimento(id_combustivel, quantidade_litro, valor_total, id_frentista)"
                    + "VALUES(?,?,?,?)");
            ps.setInt(1, abastecimentoBean.getIdCombustivel());
            ps.setDouble(2, abastecimentoBean.getQuantidadeLitro());
            ps.setDouble(3, abastecimentoBean.getValorTotal());
            ps.setInt(4, abastecimentoBean.getIdFrentista());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao tentar salvar!", ex);
        }
    }

    public void alterar(AbastecimentoBean abastecimentoBean) throws SQLException {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("update abastecimento set id_combustivel=?,"
                    + " quantidade_litro=?, valor_total=?, id_frentista, where id=?");
            ps.setInt(1, abastecimentoBean.getIdCombustivel());
            ps.setDouble(2, abastecimentoBean.getQuantidadeLitro());
            ps.setDouble(3, abastecimentoBean.getValorTotal());
            ps.setInt(4, abastecimentoBean.getIdFrentista());
            ps.setInt(5, abastecimentoBean.getId());

            ps.execute();
            Conexao.fecharConexao();
        } catch (Exception ex) {
            throw new SQLException("Erro ao tentar alterar", ex);
        }
    }

    public void deletar(Integer pId) throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from abastecimento where id=?");
            ps.setInt(1, pId);
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao deletar!", ex);
        }
    }

    public List<AbastecimentoBean> listar() throws SQLException {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from abastecimento");
            ResultSet resultSet = ps.executeQuery();
            List<AbastecimentoBean> listAbastecimentoBean = new ArrayList<>();
            while (resultSet.next()) {
                AbastecimentoBean abastecimentoBean = new AbastecimentoBean();
                abastecimentoBean.setId(resultSet.getInt("id"));
                abastecimentoBean.setIdCombustivel(resultSet.getInt("id_combustivel"));
                abastecimentoBean.setQuantidadeLitro((int) resultSet.getDouble("quantidade_litro"));
                abastecimentoBean.setValorTotal(resultSet.getDouble("valor_total"));
                abastecimentoBean.setIdFrentista(resultSet.getInt("id_frentista"));
                listAbastecimentoBean.add(abastecimentoBean);

            }
            Conexao.fecharConexao();
            return listAbastecimentoBean;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar!", ex);
        }
    }

    public List<AbastecimentoBean> buscar(String param) throws SQLException {

        try {
            Connection conexao = Conexao.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select * from abastecimento where id like '%" + param + "%' ||id_combustivel like '%" + param + "%' ||quantidade_litro like '%" + param + "%' ||valor_total like '%" + param + "%' ||id_frentista like '%" + param + "%'");
            
            ResultSet resultSet = ps.executeQuery();
            List<AbastecimentoBean> listAbastecimentoBean = new ArrayList<>();
            while (resultSet.next()) {
                AbastecimentoBean abastecimentoBean = new AbastecimentoBean();
                abastecimentoBean.setId(resultSet.getInt("id"));
                abastecimentoBean.setIdCombustivel(resultSet.getInt("id_combustivel"));
                abastecimentoBean.setQuantidadeLitro((int) resultSet.getDouble("quantidade_litro"));
                abastecimentoBean.setValorTotal(resultSet.getDouble("valor_total"));
                abastecimentoBean.setIdFrentista(resultSet.getInt("id_frentista"));
                listAbastecimentoBean.add(abastecimentoBean);

            }
            Conexao.fecharConexao();
            return listAbastecimentoBean;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar!", ex);
        }
    }
}
