package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.DescricaoServico;
import br.com.acolhimento.lgbtq.model.classes.Coordenada;
import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.classes.Instituicao;
import br.com.acolhimento.lgbtq.model.classes.Servico;

public class RepositorioDescricaoServico implements Repositorio<DescricaoServico, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioDescricaoServico() {

	}

	@Override
	public int inserir(DescricaoServico descricao) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into descricao_servico"
					+ "(descricao, instituicao, servico) "
					+ "values (?, ?, ?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, descricao.getDescricao());
		
		if(descricao.getInstituicao() == null){
			pstm.setString(2, "Não informado");
		}else {			
			pstm.setString(2, descricao.getInstituicao().getCnpj());
		}
		
		if(descricao.getServico() == null){
			pstm.setInt(3, 0);
		}else {			
			pstm.setInt(3, descricao.getServico().getId());
		}

		if(pstm.execute()) {
			return 1;
		}else {
			return 0;
		}	
	}

	@Override
	public void alterar(DescricaoServico descricao) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update descricao_servico "
					+ "set descricao=?" 
					+ "where id=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, descricao.getDescricao());
		pstm.setInt(2, descricao.getId());

		pstm.execute();
	}

	@Override
	public DescricaoServico ler(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from descricao_servico where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		ResultSet result = pstm.executeQuery();

		DescricaoServico descricao = null;

		if (result.next()) {

			descricao = new DescricaoServico();
			
			descricao.setId(result.getInt("id"));
			descricao.setDescricao(result.getString("descricao"));
			
			Instituicao instituicao = new Instituicao();
			
			instituicao.setCnpj(result.getString("cnpj"));		
			instituicao.setRazaoSocial(result.getString("razaoSocial"));
			instituicao.setHorarioAbertura(result.getString("horarioAbertura"));
			instituicao.setHorarioFechamento(result.getString("horarioFechamento"));
				
			Coordenada coord = new Coordenada();
			
			coord.setId(result.getInt("id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
				
			instituicao.setCoordenada(coord);			

			Endereco ender = new Endereco();
		
			ender.setId(result.getInt("id"));
			ender.setLogradouro(result.getString("logradouro"));
			ender.setNumero(result.getString("numero"));
			ender.setBairro(result.getString("bairro"));
			ender.setCidade(result.getString("cidade"));
			ender.setEstado(result.getString("estado"));
			ender.setCep(result.getString("cep"));
			
			instituicao.setEndereco(ender);
					
			Servico servico = new Servico();
			
			servico.setId(result.getInt("id"));
			servico.setDesignacao(result.getString("designacao"));			
			
			descricao.setInstituicao(instituicao);
			descricao.setServico(servico);
		}

		return descricao;
	}

	@Override
	public void deletar(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from descricao_servico where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	}

	@Override
	public List<DescricaoServico> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from descricao_servico";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<DescricaoServico> descricoes = new ArrayList<DescricaoServico>();

		while (result.next()) {

			DescricaoServico descricao = new DescricaoServico();
			
			descricao.setId(result.getInt("id"));
			descricao.setDescricao(result.getString("descricao"));
			
			Instituicao instituicao = new Instituicao();
			
			instituicao.setCnpj(result.getString("cnpj"));		
			instituicao.setRazaoSocial(result.getString("razaoSocial"));
			instituicao.setHorarioAbertura(result.getString("horarioAbertura"));
			instituicao.setHorarioFechamento(result.getString("horarioFechamento"));
				
			Coordenada coord = new Coordenada();
			
			coord.setId(result.getInt("id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
				
			instituicao.setCoordenada(coord);			

			Endereco ender = new Endereco();
		
			ender.setId(result.getInt("id"));
			ender.setLogradouro(result.getString("logradouro"));
			ender.setNumero(result.getString("numero"));
			ender.setBairro(result.getString("bairro"));
			ender.setCidade(result.getString("cidade"));
			ender.setEstado(result.getString("estado"));
			ender.setCep(result.getString("cep"));
			
			instituicao.setEndereco(ender);
					
			Servico servico = new Servico();
			
			servico.setId(result.getInt("id"));
			servico.setDesignacao(result.getString("designacao"));			
			
			descricao.setInstituicao(instituicao);
			descricao.setServico(servico);

			descricoes.add(descricao);
		}

		return descricoes;
	}

}
