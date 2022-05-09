package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Coordenada;

public class RepositorioCoordenada implements Repositorio<Coordenada, Integer>{
	
	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioCoordenada() {

	}

	@Override
	public void inserir(Coordenada coordenada) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into coordenada (latitude,longitude) values (?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, coordenada.getLatitude());
		pstm.setString(2, coordenada.getLongitude());
		
		pstm.execute();
		
	}

	@Override
	public void alterar(Coordenada coordenada) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update coordenada "
					+ "set latitude=?, longitude=? "
					+ "where id=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, coordenada.getLatitude());
		pstm.setString(2, coordenada.getLongitude());
		
		pstm.execute();
	}

	@Override
	public Coordenada ler(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
		//String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codigo) where c.placa = ?";
		String sql = "select * from coordenada where id = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		ResultSet result = pstm.executeQuery();
		
		Coordenada coordenada = null;
		
		if(result.next()) {
			
			coordenada = new Coordenada();
			
			coordenada.setId(result.getInt("id"));
			coordenada.setLatitude(result.getString("latitude"));
			coordenada.setLongitude(result.getString("longitude"));
			
		}
		
		return coordenada;
	}

	@Override
	public void deletar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from coordenada where id=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
	}

	@Override
	public List<Coordenada> lerTudo() throws SQLException {
		// TODO Auto-generated method stub
		
		//String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codigo)";
		String sql = "select * from coordenada";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		
		while(result.next()) {
			
			Coordenada coordenada = new Coordenada();
			
			coordenada.setId(result.getInt("id"));
			coordenada.setLatitude(result.getString("latitude"));
			coordenada.setLongitude(result.getString("longitude"));
			
			coordenadas.add(coordenada);
		}
		
		return coordenadas;
	}
}