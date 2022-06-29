package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public int inserir(Servico servico) throws SQLException {
		
		String sql = "insert into servico (designacao) values (?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection()
				.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, servico.getDesignacao());
		
		pstm.execute();
		
		int lastId = 0;
		
		final ResultSet rs = pstm.getGeneratedKeys();
		if (rs.next()) {
		    lastId = rs.getInt(1);
		}
		
		return lastId;
	}

	@Override
	public void alterar(Servico Servico) throws SQLException {		

		String sql = "update servico set designacao=? where id=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, Servico.getDesignacao());
		pstm.setInt(2, Servico.getId());

		pstm.execute();
	}

	@Override
	public Servico ler(Integer id) throws SQLException {		

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

		String sql = "delete from servico where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		pstm.execute();

	}

	@Override
	public List<Servico> lerTudo() throws SQLException {
		
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