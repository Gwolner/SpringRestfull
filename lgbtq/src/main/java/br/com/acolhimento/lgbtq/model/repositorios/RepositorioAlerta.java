package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.Acolhido;
import br.com.acolhimento.lgbtq.model.classes.Alerta;
import br.com.acolhimento.lgbtq.model.classes.Coordenada;
import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.classes.Instituicao;

public class RepositorioAlerta implements Repositorio<Alerta, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioAlerta() {

	}

	@Override
	public int inserir(Alerta alerta) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into alerta"
					+ "(status, acolhido, instituicao) "
					+ "values (?, ?, ?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, alerta.getStatus());
		pstm.setString(2, alerta.getAcolhido().getCpf());
		pstm.setString(3, alerta.getInstituicao().getCnpj());
		
		if(pstm.execute()) {
			return 1;
		}else {
			return 0;
		}	
	}

	@Override
	public void alterar(Alerta alerta) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update alerta "
					+ "set status=?" 
					+ "where id=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, alerta.getStatus());
		pstm.setInt(2, alerta.getId());

		pstm.execute();
	}

	@Override
	public Alerta ler(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from alerta where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		ResultSet result = pstm.executeQuery();

		Alerta alerta = null;

		if (result.next()) {

			alerta = new Alerta();
			
			alerta.setId(result.getInt("id"));
			alerta.setStatus(result.getString("status"));
			
			Acolhido acolhido = new Acolhido();
			
			acolhido.setCpf(result.getString("cpf"));			
			acolhido.setRg(result.getString("rg"));
			acolhido.setNome(result.getString("nome"));
			acolhido.setTipoContato(result.getString("tipo_contato"));
			acolhido.setContato(result.getString("contato"));
			acolhido.setDataNascimento(result.getString("data_nascimento"));
//			acolhido.set
				
			Coordenada coord = new Coordenada();
			
			coord.setId(result.getInt("id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
				
			acolhido.setCoordenada(coord);
			
			Instituicao instituicao = new Instituicao();
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razaoSocial"));
			instituicao.setHorarioAbertura(result.getString("horarioAbertura"));
			instituicao.setHorarioFechamento(result.getString("horarioFechamento"));

			Endereco ender = new Endereco();
			
			ender.setId(result.getInt("id"));
			ender.setLogradouro(result.getString("logradouro"));
			ender.setNumero(result.getString("numero"));
			ender.setBairro(result.getString("bairro"));
			ender.setCidade(result.getString("cidade"));
			ender.setEstado(result.getString("estado"));
			ender.setCep(result.getString("cep"));
			
			instituicao.setEndereco(ender);
			
			alerta.setAcolhido(acolhido);
			alerta.setInstituicao(instituicao);
		}

		return alerta;
	}

	@Override
	public void deletar(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from alerta where id = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	}

	@Override
	public List<Alerta> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from alerta";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<Alerta> alertas = new ArrayList<Alerta>();

		while (result.next()) {

			Alerta alerta = new Alerta();
			
			alerta.setId(result.getInt("id"));
			alerta.setStatus(result.getString("status"));
			
			Acolhido acolhido = new Acolhido();
			
			acolhido.setCpf(result.getString("cpf"));			
			acolhido.setRg(result.getString("rg"));
			acolhido.setNome(result.getString("nome"));
			acolhido.setTipoContato(result.getString("tipo_contato"));
			acolhido.setContato(result.getString("contato"));
			acolhido.setDataNascimento(result.getString("data_nascimento"));
				
			Coordenada coord = new Coordenada();
			
			coord.setId(result.getInt("id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
				
			acolhido.setCoordenada(coord);
			
			Instituicao instituicao = new Instituicao();
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razaoSocial"));
			instituicao.setHorarioAbertura(result.getString("horarioAbertura"));
			instituicao.setHorarioFechamento(result.getString("horarioFechamento"));

			Endereco ender = new Endereco();
			
			ender.setId(result.getInt("id"));
			ender.setLogradouro(result.getString("logradouro"));
			ender.setNumero(result.getString("numero"));
			ender.setBairro(result.getString("bairro"));
			ender.setCidade(result.getString("cidade"));
			ender.setEstado(result.getString("estado"));
			ender.setCep(result.getString("cep"));
			
			instituicao.setEndereco(ender);
			
			alerta.setAcolhido(acolhido);
			alerta.setInstituicao(instituicao);

			alertas.add(alerta);
		}

		return alertas;
	}

}
