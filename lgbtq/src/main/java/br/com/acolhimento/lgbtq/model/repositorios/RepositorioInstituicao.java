package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.classes.Instituicao;
import br.com.acolhimento.lgbtq.model.classes.Coordenada;

public class RepositorioInstituicao  implements Repositorio<Instituicao, String>{

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioInstituicao() {

	}

	@Override
	public void inserir(Instituicao instituicao) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into instituicao"
			+ "(cnpj, razao_social, horario_abertura, horario_fechamento, coordenada, endereco) "
			+ "values (?,?,?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, instituicao.getCnpj());
		pstm.setString(2, instituicao.getRazaoSocial());
		pstm.setString(3, instituicao.getHorarioAbertura());
		pstm.setString(4, instituicao.getHorarioFechamento());
		
		if(instituicao.getCoordenada() == null){
			pstm.setInt(5, 0);
		}else {			
			pstm.setInt(5, instituicao.getCoordenada().getId());
		}	
		
		if(instituicao.getEndereco() == null){
			pstm.setInt(6, 0);
		}else {			
			pstm.setInt(6, instituicao.getEndereco().getId());
		}	
		
		pstm.execute();
		
	}

	@Override
	public void alterar(Instituicao instituicao) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update instituicao "
			+ "set razao_social=?, horario_abertura=?, horario_fechamento=? "
			+ "where cnpj=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, instituicao.getRazaoSocial());
		pstm.setString(2, instituicao.getHorarioAbertura());
		pstm.setString(3, instituicao.getHorarioFechamento());
		pstm.setString(4, instituicao.getCnpj());
		
		pstm.execute();
	}

	@Override
	public Instituicao ler(String cnpj) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from instituicao as i join coordenada as c on (i.coordenada = c.id) where i.cnpj = ?";
		//String sql = "select * from instituicao where cnpj = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cnpj);
		
		ResultSet result = pstm.executeQuery();
		
		Instituicao instituicao = null;
		
		if(result.next()) {
			
			instituicao = new Instituicao();
			
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horarioAbertura"));
			instituicao.setHorarioFechamento(result.getString("horarioFechamento"));
			
			Coordenada coord = new Coordenada();
			
			coord.setId(result.getInt("id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
			
			Endereco endereco = new Endereco();
			
			endereco.setId(result.getInt("id"));
			endereco.setLogradouro(result.getString("logradouro"));
			endereco.setNumero(result.getString("numero"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCidade(result.getString("cidade"));
			endereco.setEstado(result.getString("estado"));
			endereco.setCep(result.getString("cep"));
			
			instituicao.setCoordenada(coord);
			instituicao.setEndereco(endereco);
		}
		
		return instituicao;
	}

	@Override
	public void deletar(String cnpj) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from instituicao where cnpj=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cnpj);
		
		pstm.execute();
	}

	@Override
	public List<Instituicao> lerTudo() throws SQLException {
		// TODO Auto-generated method stub
		
//		String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codigo)";
		String sql = "select * from instituicao";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		
		while(result.next()) {
			
			Instituicao instituicao = new Instituicao();
			
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horarioAbertura"));
			instituicao.setHorarioFechamento(result.getString("horarioFechamento"));
			
			Coordenada coord = new Coordenada();
			
			coord.setId(result.getInt("id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
			
			Endereco endereco = new Endereco();
			
			endereco.setId(result.getInt("id"));
			endereco.setLogradouro(result.getString("logradouro"));
			endereco.setNumero(result.getString("numero"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCidade(result.getString("cidade"));
			endereco.setEstado(result.getString("estado"));
			endereco.setCep(result.getString("cep"));
			
			instituicao.setCoordenada(coord);
			instituicao.setEndereco(endereco);
			
			instituicoes.add(instituicao);
		}
		
		return instituicoes;
	}
}
