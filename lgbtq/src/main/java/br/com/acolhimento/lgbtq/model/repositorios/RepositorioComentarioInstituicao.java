package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.ComentarioInstituicao;

public class RepositorioComentarioInstituicao implements Repositorio<ComentarioInstituicao, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioComentarioInstituicao() {

	}

	@Override
	public void inserir(ComentarioInstituicao comentarioInstituicao) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into comentario_instituicao (texto) values (?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, comentarioInstituicao.getTexto());

		pstm.execute();
	}

	@Override
	public void alterar(ComentarioInstituicao comentarioInstituicao) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update comentario_instituicao set texto=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, comentarioInstituicao.getTexto());

		pstm.execute();
	}

	@Override
	public ComentarioInstituicao ler(Integer id) throws SQLException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

		String sql = "delete from comentario_instituicao where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	}

	@Override
	public List<ComentarioInstituicao> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

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

}