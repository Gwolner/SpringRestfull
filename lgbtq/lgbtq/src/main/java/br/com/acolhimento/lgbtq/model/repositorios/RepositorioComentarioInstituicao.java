package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.ComentarioInstituicao;
import br.com.acolhimento.lgbtq.model.classes.Descricao;
import br.com.acolhimento.lgbtq.model.classes.Servico;

public class RepositorioComentarioInstituicao implements Repositorio<ComentarioInstituicao, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioComentarioInstituicao() {

	}

	@Override
	public int inserir(ComentarioInstituicao comentarioInstituicao) throws SQLException {

		String sql = "insert into comentario_instituicao(texto, instituicao_cnpj) values (?, ?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, comentarioInstituicao.getTexto());		
		pstm.setString(2, comentarioInstituicao.getCnpjInstituicao());

		if(pstm.execute()) {
			return 1;
		}else {
			return 0;
		}	
	}

	@Override
	public void alterar(ComentarioInstituicao comentarioInstituicao) throws SQLException {

		String sql = "update comentario_instituicao set texto=? where id=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, comentarioInstituicao.getTexto());
		
		pstm.setInt(2, comentarioInstituicao.getId());

		pstm.execute();
	}

	@Override
	public ComentarioInstituicao ler(Integer id) throws SQLException {

		String sql = "select * from comentario_instituicao where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		ResultSet result = pstm.executeQuery();

		ComentarioInstituicao comentarioInstituicao = null;

		if (result.next()) {

			comentarioInstituicao = new ComentarioInstituicao();
			
			comentarioInstituicao.setId(result.getInt("id"));
			comentarioInstituicao.setTexto(result.getString("texto"));
			
		}

		return comentarioInstituicao;
	}

	@Override
	public void deletar(Integer id) throws SQLException {

		String sql = "delete from comentario_instituicao where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	}

	@Override
	public List<ComentarioInstituicao> lerTudo() throws SQLException {

		String sql = "select * from comentario_instituicao";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<ComentarioInstituicao> comentarios = new ArrayList<ComentarioInstituicao>();

		while (result.next()) {

			ComentarioInstituicao comentarioInstituicao = new ComentarioInstituicao();

			comentarioInstituicao.setId(result.getInt("id"));
			comentarioInstituicao.setTexto(result.getString("texto"));

			comentarios.add(comentarioInstituicao);

		}

		return comentarios;
	}
	
	public ArrayList<ComentarioInstituicao> lerComentarioPorCnpjInstituicao(String cnpj) throws SQLException {

		String sql = "select * from comentario_instituicao where instituicao_cnpj = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cnpj);

		ResultSet result = pstm.executeQuery();

		ArrayList<ComentarioInstituicao> comentarios = new ArrayList<ComentarioInstituicao>();

		while (result.next()) {

			ComentarioInstituicao comentarioInstituicao = new ComentarioInstituicao();

			comentarioInstituicao.setId(result.getInt("id"));
			comentarioInstituicao.setTexto(result.getString("texto"));
			comentarioInstituicao.setCnpjInstituicao(result.getString("instituicao_cnpj"));

			comentarios.add(comentarioInstituicao);

		}

		return comentarios;
	}
	
	public ArrayList<Descricao> lerDescricaoPorCnpjInstituicao(String cnpj) throws SQLException {

//		String sql = "select * from descricao_servico where instituicao_cnpj = ?";
		
		String sql = "SELECT *, descricao_servico.id AS descricao_id "
				+ "FROM descricao_servico "
				+ "INNER JOIN servico "
				+ "ON descricao_servico.servico_id = servico.id "
				+ "WHERE instituicao_cnpj  = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cnpj);

		ResultSet result = pstm.executeQuery();

		ArrayList<Descricao> descricoes = new ArrayList<Descricao>();

		while (result.next()) {

			Descricao descricao = new Descricao();

			descricao.setId(result.getInt("descricao_id"));			
			descricao.setDescricao(result.getString("descricao"));
			
			Servico servico = new Servico();
			
			servico.setId(result.getInt("servico_id"));
			servico.setDesignacao(result.getString("designacao"));
			
			descricao.setServico(servico);

			descricoes.add(descricao);

		}

		return descricoes;
	}

}