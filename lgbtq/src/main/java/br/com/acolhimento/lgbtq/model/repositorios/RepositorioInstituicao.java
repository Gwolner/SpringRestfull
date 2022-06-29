package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Instituicao;

public class RepositorioInstituicao  implements Repositorio<Instituicao, String>{

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioInstituicao() {

	}

	@Override
	public int inserir(Instituicao instituicao) throws SQLException {
		
		String sql = "insert into instituicao"
			+ "(cnpj, razao_social, horario_abertura, horario_fechamento, coordenada_id, endereco_id) "
			+ "values (?,?,?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, instituicao.getCnpj());
		pstm.setString(2, instituicao.getRazaoSocial());
		pstm.setString(3, instituicao.getHorarioAbertura());
		pstm.setString(4, instituicao.getHorarioFechamento());
		pstm.setInt(5, instituicao.getCoordenada().getId());
		pstm.setInt(6, instituicao.getEndereco().getId());
		
		if(pstm.execute()) {
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public void alterar(Instituicao instituicao) throws SQLException {
		
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
		
		String sql = "select * from instituicao where cnpj = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cnpj);
		
		ResultSet result = pstm.executeQuery();		
		
		Instituicao instituicao = null;
		
		if(result.next()) {
			instituicao = new Instituicao();
			
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horario_abertura"));
			instituicao.setHorarioFechamento(result.getString("horario_fechamento"));
			instituicao.getCoordenada().setId(result.getInt("coordenada_id"));
			instituicao.getEndereco().setId(result.getInt("endereco_id"));
		}
		
		System.out.println("instituicao: "+instituicao.getCnpj());
		
		return instituicao;
	}

	@Override
	public void deletar(String cnpj) throws SQLException {
		
		String sql = "delete from instituicao where cnpj=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cnpj);
		
		pstm.execute();
	}

	@Override
	public List<Instituicao> lerTudo() throws SQLException {
		
		String sql = "select * from instituicao";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		
		while(result.next()) {
			
			Instituicao instituicao = new Instituicao();
			
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horario_abertura"));
			instituicao.setHorarioFechamento(result.getString("horario_fechamento"));
			instituicao.getCoordenada().setId(result.getInt("coordenada_id"));
			instituicao.getEndereco().setId(result.getInt("endereco_id"));

			instituicoes.add(instituicao);
		}
		
		return instituicoes;
	}
}
