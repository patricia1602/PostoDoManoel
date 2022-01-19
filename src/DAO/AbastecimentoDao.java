package DAO;

import Bean.AbastecimentoBean;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbastecimentoDao {

    public void salvar(AbastecimentoBean abastecimentoBean) throws SQLException {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO 'abastecimento'"
                    + "('combustivel', 'quantidade_litro', 'valor_Total', 'frentista')"
                    + "VALUES(?,?,?,?)");
            ps.setString(1, abastecimentoBean.getIdCombustivel());
            ps.setDouble(2, abastecimentoBean.getQuantidadeLitro());
            ps.setBigDecimal(3, abastecimentoBean.getValorTotal());
            ps.setString(4, abastecimentoBean.getIdFrentista());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao tentar salvar!", ex);
        }
    }

    public void alterar(AbastecimentoBean abastecimentoBean) throws SQLException {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("update abastecimento set combustivel=?, quantidade_litro=?, valor_total=?, frentista");
            ps.setString(1, abastecimentoBean.getIdCombustivel());
            ps.setDouble(2, abastecimentoBean.getQuantidadeLitro());
            ps.setBigDecimal(3, abastecimentoBean.getValorTotal());
            ps.setString(4, abastecimentoBean.getIdFrentista());
            ps.setInt(5, abastecimentoBean.getId());

            ps.execute();
            Conexao.fecharConexao();
        } catch (Exception ex) {
            throw new SQLException("Erro ao tentar alterar", ex);
        }
    }
}
