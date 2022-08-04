package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Descricao;
import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.classes.Instituicao;
import br.com.acolhimento.lgbtq.model.classes.Servico;

public class RepositorioDescricao implements Repositorio<Descricao, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado
	 * fora do pacote
	 */
	RepositorioDescricao() {

	}

	@Override
	public int inserir(Descricao descricao) throws SQLException {

		int lastId = 0;
		PreparedStatement pstm;
		final ResultSet rs;
		String sql = "insert into descricao_servico (descricao, instituicao_cnpj, servico_id) values (?, ?, ?)";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, descricao.getDescricao());
		pstm.setString(2, descricao.getInstituicao().getCnpj());
		pstm.setInt(3, descricao.getServico().getId());

		pstm.execute();

		rs = pstm.getGeneratedKeys();
		if (rs.next()) {
			lastId = rs.getInt(1);
		}

		return lastId;
	}

	@Override
	public void alterar(Descricao descricao) throws SQLException {

		PreparedStatement pstm;
		String sql = "update descricao_servico set descricao=? where id=?";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, descricao.getDescricao());
		pstm.setInt(2, descricao.getId());

		pstm.execute();
	}

	@Override
	public Descricao ler(Integer id) throws SQLException {
		
		Descricao descricao;
		Instituicao instituicao;
		Endereco ender;
		Servico servico;
		PreparedStatement pstm;
		ResultSet result;
		String sql = "SELECT descricao_servico.id AS descricao_id, descricao_servico.*, instituicao.*, servico.*, endereco.*"
					+ "FROM descricao_servico "
					+ "INNER JOIN instituicao "
					+ "ON instituicao.cnpj = descricao_servico.instituicao_cnpj "
					+ "INNER JOIN servico "
					+ "ON servico.id = descricao_servico.servico_id "
					+ "INNER JOIN endereco "
					+ "ON endereco.id = instituicao.endereco_id "
					+ "WHERE descricao_servico.id = ?";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		result = pstm.executeQuery();

		descricao = null;

		if (result.next()) {

			System.out.println("ENTREIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
			
			descricao = new Descricao();

			descricao.setId(result.getInt("descricao_id"));
			descricao.setDescricao(result.getString("descricao"));

			instituicao = new Instituicao();

			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horario_abertura"));
			instituicao.setHorarioFechamento(result.getString("horario_fechamento"));
			instituicao.setCoordenada(null);
			instituicao.setComentarios(null);
//			instituicao.setDescricoes(null);

			ender = new Endereco();

			ender.setId(result.getInt("endereco_id"));
			ender.setLogradouro(result.getString("logradouro"));
			ender.setNumero(result.getString("numero"));
			ender.setBairro(result.getString("bairro"));
			ender.setCidade(result.getString("cidade"));
			ender.setEstado(result.getString("estado"));
			ender.setCep(result.getString("cep"));

			instituicao.setEndereco(ender);

			servico = new Servico();

			servico.setId(result.getInt("servico_id"));
			servico.setDesignacao(result.getString("designacao"));

			descricao.setInstituicao(instituicao);
			descricao.setServico(servico);

		}

		return descricao;
	}

	@Override
	public void deletar(Integer id) throws SQLException {

		PreparedStatement pstm;
		String sql = "delete from descricao_servico where id = ?";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	}

	@Override
	public List<Descricao> lerTudo() throws SQLException {

		Descricao descricao;
		Instituicao instituicao;
		Endereco ender;
		Servico servico;
		List<Descricao> descricoes;
		ResultSet result;
		PreparedStatement pstm;
		String sql = "SELECT descricao_servico.id AS descricao_id, descricao_servico.*, instituicao.*, servico.*, endereco.*"
					+ "FROM descricao_servico "
					+ "INNER JOIN instituicao "
					+ "ON instituicao.cnpj = descricao_servico.instituicao_cnpj "
					+ "INNER JOIN servico "
					+ "ON servico.id = descricao_servico.servico_id "
					+ "INNER JOIN endereco "
					+ "ON endereco.id = instituicao.endereco_id ";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		result = pstm.executeQuery();

		descricoes = new ArrayList<Descricao>();

		while (result.next()) {

			descricao = new Descricao();

			descricao.setId(result.getInt("descricao_id"));
			descricao.setDescricao(result.getString("descricao"));

			instituicao = new Instituicao();

			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horario_abertura"));
			instituicao.setHorarioFechamento(result.getString("horario_fechamento"));
			instituicao.setCoordenada(null);
			instituicao.setComentarios(null);
//			instituicao.setDescricoes(null);

			ender = new Endereco();

			ender.setId(result.getInt("endereco_id"));
			ender.setLogradouro(result.getString("logradouro"));
			ender.setNumero(result.getString("numero"));
			ender.setBairro(result.getString("bairro"));
			ender.setCidade(result.getString("cidade"));
			ender.setEstado(result.getString("estado"));
			ender.setCep(result.getString("cep"));

			instituicao.setEndereco(ender);

			servico = new Servico();

			servico.setId(result.getInt("servico_id"));
			servico.setDesignacao(result.getString("designacao"));

			descricao.setInstituicao(instituicao);
			descricao.setServico(servico);

			descricoes.add(descricao);
		}

		return descricoes;
	}

}
