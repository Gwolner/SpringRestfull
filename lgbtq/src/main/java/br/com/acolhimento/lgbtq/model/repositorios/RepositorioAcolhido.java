package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Acolhido;
import br.com.acolhimento.lgbtq.model.classes.Coordenada;

public class RepositorioAcolhido implements Repositorio<Acolhido, String>{

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioAcolhido() {

	}

	@Override
	public void inserir(Acolhido acolhido) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into acolhido "
				+ "(cpf, rg, nome, tipo_contato, contato, data_nascimento, coordenada)"
				+ "values (?,?,?,?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, acolhido.getCpf());
		pstm.setString(2, acolhido.getRg());
		pstm.setString(3, acolhido.getNome());
		pstm.setString(4, acolhido.getTipoContato());
		pstm.setString(5, acolhido.getContato());
		pstm.setString(6, acolhido.getDataNascimento());
		
		if(acolhido.getCoordenada() == null){
			pstm.setInt(7, 0);
		}else {			
			pstm.setInt(7, acolhido.getCoordenada().getId());
		}		
		
		pstm.execute();
		
	}

	@Override
	public void alterar(Acolhido acolhido) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update acolhido "
					+ "set rg=?, nome=?, tipo_contato=?, contato=?, data_nascimento=?, coordenada =?"
					+ "where cpf=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, acolhido.getRg());
		pstm.setString(2, acolhido.getNome());
		pstm.setString(3, acolhido.getTipoContato());
		pstm.setString(4, acolhido.getContato());
		pstm.setString(5, acolhido.getDataNascimento());
		
		if(acolhido.getCoordenada() == null){
			pstm.setInt(6, 0);
		}else {			
			pstm.setInt(6, acolhido.getCoordenada().getId());
		}
		
		pstm.setString(7, acolhido.getCpf());
		
		pstm.execute();
	}

	@Override
	public Acolhido ler(String cpf) throws SQLException {
		// TODO Auto-generated method stub
		
		//String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codigo) where c.placa = ?";
		String sql = "select * from acolhido as a join coordenada as c on (a.coordenada = c.id) where a.cpf = ?";
		//String sql = "select * from acolhido where cpf = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cpf);
		
		ResultSet result = pstm.executeQuery();
		
		Acolhido acolhido = null;
		
		if(result.next()) {
			
			acolhido = new Acolhido();
			
			acolhido.setCpf(result.getString("cpf"));
			acolhido.setRg(result.getString("rg"));
			acolhido.setNome(result.getString("nome"));
			acolhido.setTipoContato(result.getString("tipo_contato"));
			acolhido.setContato(result.getString("contato"));
			acolhido.setDataNascimento(result.getString("data_nascimento"));
			
			Coordenada coordenada = new Coordenada();
			
			coordenada.setId(result.getInt("id"));
			coordenada.setLatitude(result.getString("latitude"));
			coordenada.setLongitude(result.getString("longitude"));
			
			acolhido.setCoordenada(coordenada);
		}
		
		return acolhido;
	}

	@Override
	public void deletar(String cpf) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from acolhido where cpf=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cpf);
		
		pstm.execute();
	}

	@Override
	public List<Acolhido> lerTudo() throws SQLException {
		// TODO Auto-generated method stub
		
		//String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codigo)";
		String sql = "select * from acolhido as a join coordenada as c on (a.coordenada = c.id)";
		//String sql = "select * from acolhido";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Acolhido> acolhidos = new ArrayList<Acolhido>();
		
		while(result.next()) {
			
			Acolhido acolhido = new Acolhido();
			
			acolhido.setCpf(result.getString("cpf"));
			acolhido.setRg(result.getString("rg"));
			acolhido.setNome(result.getString("nome"));
			acolhido.setTipoContato(result.getString("tipo_contato"));
			acolhido.setContato(result.getString("contato"));
			acolhido.setDataNascimento(result.getString("data_nascimento"));
			
			Coordenada coordenada = new Coordenada();
			
			coordenada.setId(result.getInt("id"));
			coordenada.setLatitude(result.getString("latitude"));
			coordenada.setLongitude(result.getString("longitude"));
			
			acolhido.setCoordenada(coordenada);
			
			acolhidos.add(acolhido);
		}
		
		return acolhidos;
	}
}
