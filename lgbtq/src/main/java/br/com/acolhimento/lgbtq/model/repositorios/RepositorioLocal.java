package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Local;
import br.com.acolhimento.lgbtq.model.classes.Coordenada;
import br.com.acolhimento.lgbtq.model.classes.Endereco;

public class RepositorioLocal implements Repositorio<Local, Integer>{

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioLocal() {

	}

	@Override
	public void inserir(Local local) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into local "
				+ "(nome, link, descricao, coordenada, endereco)"
				+ "values (?,?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, local.getNome());
		pstm.setString(2, local.getLink());
		pstm.setString(3, local.getDescricao());
		
		if(local.getCoordenada() == null){
			pstm.setInt(4, 0);
		}else {			
			pstm.setInt(4, local.getCoordenada().getId());
		}	
		
		if(local.getEndereco() == null){
			pstm.setInt(5, 0);
		}else {			
			pstm.setInt(5, local.getEndereco().getId());
		}		
		
		pstm.execute();		
	}

	@Override
	public void alterar(Local local) throws SQLException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
		//O Local tem que trazer as coordenadas e o endereço!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		String sql = "select * from local as l join coordenada as c on (l.coordenada = c.id) where l.id = ?";
		
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
			
			Coordenada coordenada = new Coordenada();
			
			coordenada.setId(result.getInt("id"));
			coordenada.setLatitude(result.getString("latitude"));
			coordenada.setLongitude(result.getString("longitude"));
			
			Endereco endereco = new Endereco();
			
			endereco.setId(result.getInt("id"));
			endereco.setLogradouro(result.getString("logradouro"));
			endereco.setNumero(result.getString("numero"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCidade(result.getString("cidade"));
			endereco.setEstado(result.getString("estado"));
			endereco.setCep(result.getString("cep"));			
			
			local.setCoordenada(coordenada);
			local.setEndereco(endereco);
		}
		
		return local;
	}

	@Override
	public void deletar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from local where id=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
	}

	@Override
	public List<Local> lerTudo() throws SQLException {
		// TODO Auto-generated method stub
		
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
			
			Coordenada coordenada = new Coordenada();
			
			coordenada.setId(result.getInt("id"));
			coordenada.setLatitude(result.getString("latitude"));
			coordenada.setLongitude(result.getString("longitude"));
			
			Endereco endereco = new Endereco();
			
			endereco.setId(result.getInt("id"));
			endereco.setLogradouro(result.getString("logradouro"));
			endereco.setNumero(result.getString("numero"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCidade(result.getString("cidade"));
			endereco.setEstado(result.getString("estado"));
			endereco.setCep(result.getString("cep"));			
			
			local.setCoordenada(coordenada);
			local.setEndereco(endereco);
			
			locais.add(local);
		}
		
		return locais;
	}
}

