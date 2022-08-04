package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Local;

public class RepositorioLocal implements Repositorio<Local, Integer>{

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioLocal() {

	}

	@Override
	public int inserir(Local local) throws SQLException {
		
		int lastId = 0;
		String sql = "insert into local "
				+ "(nome, link, descricao, endereco_id, coordenada_id)"
				+ "values (?,?,?,?,?)";		
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection()
				.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, local.getNome());
		pstm.setString(2, local.getLink());
		pstm.setString(3, local.getDescricao());
		pstm.setInt(4, local.getEndereco().getId());
		pstm.setInt(5, local.getCoordenada().getId());
		
		pstm.execute();
		
		final ResultSet rs = pstm.getGeneratedKeys();
		if (rs.next()) {
		    lastId = rs.getInt(1);
		}
		
		return lastId;
	}

	@Override
	public void alterar(Local local) throws SQLException {
		
		String sql = "update local "
					+ "set nome=?, link=?, descricao=?"
					+ "where id=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, local.getNome());
		pstm.setString(2, local.getLink());
		pstm.setString(3, local.getDescricao());		
		pstm.setInt(4, local.getId());
		
		pstm.execute();
	}

	@Override
	public Local ler(Integer id) throws SQLException {
		
		String sql = "select * from local where id = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		ResultSet result = pstm.executeQuery();
		
		Local local = null;
		
		if(result.next()) {
			
			local = new Local();
			
			local.setId(result.getInt("id"));
			local.setNome(result.getString("nome"));
			local.setLink(result.getString("link"));
			local.setDescricao(result.getString("descricao"));
			
			if(result.getObject("coordenada_id") != null) {
				local.getCoordenada().setId(result.getInt("coordenada_id"));
			}
			
			local.getEndereco().setId(result.getInt("endereco_id"));
		}
		
		return local;
	}

	@Override
	public void deletar(Integer id) throws SQLException {
		
		String sql = "delete from local where id=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
	}

	@Override
	public List<Local> lerTudo() throws SQLException {
		
		String sql = "select * from local";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Local> locais = new ArrayList<Local>();
		
		while(result.next()) {
			
			Local local = new Local();
			
			local.setId(result.getInt("id"));
			local.setNome(result.getString("nome"));
			local.setLink(result.getString("link"));
			local.setDescricao(result.getString("descricao"));
			
			if(result.getObject("coordenada_id") != null) {
				local.getCoordenada().setId(result.getInt("coordenada_id"));
			}
			
			local.getEndereco().setId(result.getInt("endereco_id"));
			
			locais.add(local);
		}
		
		return locais;
	}
}

