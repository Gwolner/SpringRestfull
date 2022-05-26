package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Endereco;

public class RepositorioEndereco implements Repositorio<Endereco, Integer>{

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioEndereco() {

	}

	@Override
	public int inserir(Endereco endereco) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into endereco "
				+ "(logradouro, numero, bairro, cidade, estado, cep)"
				+ "values (?,?,?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection()
				.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, endereco.getLogradouro());
		pstm.setString(2, endereco.getNumero());
		pstm.setString(3, endereco.getBairro());
		pstm.setString(4, endereco.getCidade());
		pstm.setString(5, endereco.getEstado());
		pstm.setString(6, endereco.getCep());
		
		pstm.execute();

		int lastId = 0;
		
		final ResultSet rs = pstm.getGeneratedKeys();
		if (rs.next()) {
		    lastId = rs.getInt(1);
		}
		
		return lastId;
	}

	@Override
	public void alterar(Endereco endereco) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update endereco "
					+ "set logradouro=?, numero=?, bairro=?, cidade=?, estado=?, cep =?"
					+ "where id=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, endereco.getLogradouro());
		pstm.setString(2, endereco.getNumero());
		pstm.setString(3, endereco.getBairro());
		pstm.setString(4, endereco.getCidade());
		pstm.setString(5, endereco.getEstado());
		pstm.setString(6, endereco.getCep());		
		pstm.setInt(7, endereco.getId());
		
		pstm.execute();
	}

	@Override
	public Endereco ler(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
		//String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codigo) where c.placa = ?";
		String sql = "select * from endereco where id = ?";
		//String sql = "select * from endereco where cpf = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		ResultSet result = pstm.executeQuery();
		
		Endereco endereco = null;
		
		if(result.next()) {
			
			endereco = new Endereco();
			
			endereco.setId(result.getInt("id"));
			endereco.setLogradouro(result.getString("logradouro"));
			endereco.setNumero(result.getString("numero"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCidade(result.getString("cidade"));
			endereco.setEstado(result.getString("estado"));
			endereco.setCep(result.getString("cep"));
			
		}
		
		return endereco;
	}

	@Override
	public void deletar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from endereco where id=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
	}

	@Override
	public List<Endereco> lerTudo() throws SQLException {
		// TODO Auto-generated method stub
		
		//String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codigo)";
		String sql = "select * from endereco";
		//String sql = "select * from endereco";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		while(result.next()) {
			
			Endereco endereco = new Endereco();
			
			endereco.setId(result.getInt("id"));
			endereco.setLogradouro(result.getString("logradouro"));
			endereco.setNumero(result.getString("numero"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCidade(result.getString("cidade"));
			endereco.setEstado(result.getString("estado"));
			endereco.setCep(result.getString("cep"));
			
			enderecos.add(endereco);
		}
		
		return enderecos;
	}
}
