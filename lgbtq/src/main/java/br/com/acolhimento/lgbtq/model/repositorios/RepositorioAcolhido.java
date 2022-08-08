package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Acolhido;

public class RepositorioAcolhido implements Repositorio<Acolhido, String>{

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioAcolhido() {

	}

	@Override
	public int inserir(Acolhido acolhido) throws SQLException {
		
		String sql = "insert into acolhido "
				+ "(cpf, rg, nome, tipo_contato, contato, data_nascimento, coordenada_id, email, senha)"
				+ "values (?,?,?,?,?,?,?,?,?)";		
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, acolhido.getCpf());
		pstm.setString(2, acolhido.getRg());
		pstm.setString(3, acolhido.getNome());
		pstm.setString(4, acolhido.getTipoContato());
		pstm.setString(5, acolhido.getContato());
		pstm.setString(6, acolhido.getDataNascimento());
		pstm.setInt(7, acolhido.getCoordenada().getId());
		pstm.setString(8, acolhido.getEmail());
		pstm.setString(9, acolhido.getSenha());

		if(pstm.execute()) {
			return 1;
		}else {
			return 0;
		}		
	}

	@Override
	public void alterar(Acolhido acolhido) throws SQLException {
		
		String sql = "update acolhido "
					+ "set rg=?, nome=?, tipo_contato=?, contato=?, data_nascimento=?, email=?, senha=?"
					+ "where cpf=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, acolhido.getRg());
		pstm.setString(2, acolhido.getNome());
		pstm.setString(3, acolhido.getTipoContato());
		pstm.setString(4, acolhido.getContato());
		pstm.setString(5, acolhido.getDataNascimento());
		pstm.setString(6, acolhido.getEmail());
		pstm.setString(7, acolhido.getSenha());
		
		pstm.setString(8, acolhido.getCpf());
		
		pstm.execute();
	}

	@Override
	public Acolhido ler(String cpf) throws SQLException {
		
		String sql = "select * from acolhido where cpf = ?";
		
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
			acolhido.setEmail(result.getString("email"));
			
			if(result.getObject("coordenada_id") != null) {
				acolhido.getCoordenada().setId(result.getInt("coordenada_id"));
			}
		}	
		return acolhido;
	}

	@Override
	public void deletar(String cpf) throws SQLException {
		
		String sql = "delete from acolhido where cpf=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cpf);
		
		pstm.execute();
	}

	@Override
	public List<Acolhido> lerTudo() throws SQLException {

		String sql = "select * from acolhido";
		
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
			acolhido.setEmail(result.getString("email"));
			
			if(result.getObject("coordenada_id") != null) {
				acolhido.getCoordenada().setId(result.getInt("coordenada_id"));
			}
			
			acolhidos.add(acolhido);
		}
		return acolhidos;
	}
	
	public String autenticacaoAcolhido(String email, String senha) throws SQLException {
		
		String sql = "select cpf from acolhido where email = ? and senha = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, email);
		pstm.setString(2, senha);
		
		ResultSet result = pstm.executeQuery();
		
		Acolhido acolhido = null;
		
		if(result.next()) {
			
			acolhido = new Acolhido();
			
			acolhido.setCpf(result.getString("cpf"));
			
		}	
		
		if(acolhido != null) {
			return acolhido.getCpf();
		}else {
			return "0";
		}
		
	}

}
