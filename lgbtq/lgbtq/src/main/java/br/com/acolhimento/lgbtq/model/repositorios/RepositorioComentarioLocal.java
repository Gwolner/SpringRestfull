package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.ComentarioLocal;

public class RepositorioComentarioLocal implements Repositorio<ComentarioLocal, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioComentarioLocal() {

	}

	@Override
	public int inserir(ComentarioLocal comentarioLocal) throws SQLException {

		String sql = "insert into comentario_local(texto, avaliacao, local_id) values (?, ?, ?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, comentarioLocal.getTexto());
		pstm.setInt(2, comentarioLocal.getAvaliacao());
		pstm.setInt(3, comentarioLocal.getIdLocal());
		
		if(pstm.execute()) {
			return 1;
		}else {
			return 0;
		}	
	}

	@Override
	public void alterar(ComentarioLocal comentarioLocal) throws SQLException {

		String sql = "update comentario_local set texto=?, avaliacao=? where id=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, comentarioLocal.getTexto());
		pstm.setInt(2, comentarioLocal.getAvaliacao());
		
		pstm.setInt(3, comentarioLocal.getId());
		
		System.out.println("getTexto: "+comentarioLocal.getTexto());
		System.out.println("getAvaliacao: "+comentarioLocal.getAvaliacao());
		System.out.println("getId: "+comentarioLocal.getId());

		pstm.execute();
	}

	@Override
	public ComentarioLocal ler(Integer id) throws SQLException {

		String sql = "select * from comentario_local where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		ResultSet result = pstm.executeQuery();

		ComentarioLocal comentarioLocal = null;

		if (result.next()) {

			comentarioLocal = new ComentarioLocal();
			
			comentarioLocal.setId(id);
			comentarioLocal.setTexto(result.getString("texto"));
			comentarioLocal.setAvaliacao(result.getInt("avaliacao"));
			
		}

		return comentarioLocal;
	}

	@Override
	public void deletar(Integer id) throws SQLException {

		String sql = "delete from comentario_local where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	}

	@Override
	public List<ComentarioLocal> lerTudo() throws SQLException {

		String sql = "select * from comentario_local";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<ComentarioLocal> comentarios = new ArrayList<ComentarioLocal>();

		while (result.next()) {

			ComentarioLocal comentarioLocal = new ComentarioLocal();

			comentarioLocal.setId(result.getInt("id"));
			comentarioLocal.setTexto(result.getString("texto"));
			comentarioLocal.setAvaliacao(result.getInt("avaliacao"));

			comentarios.add(comentarioLocal);

		}

		return comentarios;
	}
	
	public ArrayList<ComentarioLocal> lerComentarioPorIdLocal(int id) throws SQLException {

		String sql = "select * from comentario_local where local_id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);

		ResultSet result = pstm.executeQuery();

		ArrayList<ComentarioLocal> comentarios = new ArrayList<ComentarioLocal>();

		while (result.next()) {

			ComentarioLocal comentarioLocal = new ComentarioLocal();

			comentarioLocal.setId(result.getInt("id"));
			comentarioLocal.setTexto(result.getString("texto"));
			comentarioLocal.setAvaliacao(result.getInt("avaliacao"));
			comentarioLocal.setIdLocal(result.getInt("local_id"));

			comentarios.add(comentarioLocal);

		}

		return comentarios;
	}

}