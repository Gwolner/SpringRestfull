package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Servico;

public class RepositorioServico implements Repositorio<Servico, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioServico() {

	}

	@Override
	public void inserir(Servico servico) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into servico (designacao) values (?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, servico.getDesignacao());
		
		pstm.execute();	
	}

	@Override
	public void alterar(Servico Servico) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update servico set designacao=? where id=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, Servico.getDesignacao());
		pstm.setInt(2, Servico.getId());

		pstm.execute();
	}

	@Override
	public Servico ler(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from servico where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		ResultSet result = pstm.executeQuery();

		Servico servico = null;

		if (result.next()) {

			servico = new Servico();
			
			servico.setId(result.getInt("id"));
			servico.setDesignacao(result.getString("designacao"));
			
		}

		return servico;
	}

	@Override
	public void deletar(Integer k) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from servico where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		pstm.execute();

	}

	@Override
	public List<Servico> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from servico";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<Servico> servicos = new ArrayList<Servico>();

		while (result.next()) {

			Servico servico = new Servico();

			servico.setId(result.getInt("id"));
			servico.setDesignacao(result.getString("designacao"));

			servicos.add(servico);

		}

		return servicos;
	}

}