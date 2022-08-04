package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

		int lastId = 0;
		PreparedStatement pstm;
		String sql = "insert into alerta"
					+ "(status, acolhido_cpf, instituicao_cnpj) "
					+ "values (?, ?, ?)";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		pstm.setString(1, alerta.getStatus());
		pstm.setString(2, alerta.getAcolhido().getCpf());
		pstm.setString(3, alerta.getInstituicao().getCnpj());
		
		pstm.execute();	
		
		final ResultSet rs = pstm.getGeneratedKeys();
		if (rs.next()) {
			lastId = rs.getInt(1);
		}

		return lastId;
	}

	@Override
	public void alterar(Alerta alerta) throws SQLException {

		PreparedStatement pstm;
		String sql = "update alerta "
					+ "set status=?" 
					+ "where id=?";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, alerta.getStatus());
		pstm.setInt(2, alerta.getId());

		pstm.execute();
	}

	@Override
	public Alerta ler(Integer id) throws SQLException {
		
		Alerta alerta = null;
		Acolhido acolhido;
		Coordenada coord;
		Instituicao instituicao;
		Endereco ender;	
		PreparedStatement pstm;
		ResultSet result;
		String sql = "SELECT alerta.id AS alerta_id, alerta.*, acolhido.*, coordenada.*, instituicao.*, endereco.* "
					+ "FROM acolhido "
					+ "INNER JOIN coordenada "
					+ "ON acolhido.coordenada_id = coordenada.id "
					+ "INNER JOIN alerta "
					+ "ON acolhido.cpf = alerta.acolhido_cpf "
					+ "INNER JOIN instituicao "
					+ "ON alerta.instituicao_cnpj = instituicao.cnpj "
					+ "INNER JOIN endereco "
					+ "ON endereco.id = instituicao.endereco_id "
					+ "WHERE alerta.id = ?";
		
		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		result = pstm.executeQuery();		

		if (result.next()) {
			
			alerta = new Alerta();
			
			alerta.setId(result.getInt("alerta_id"));
			alerta.setStatus(result.getString("status"));
			
			acolhido = new Acolhido();
			
			acolhido.setCpf(result.getString("cpf"));			
			acolhido.setRg(result.getString("rg"));
			acolhido.setNome(result.getString("nome"));
			acolhido.setTipoContato(result.getString("tipo_contato"));
			acolhido.setContato(result.getString("contato"));
			acolhido.setDataNascimento(result.getString("data_nascimento"));
				
			coord = new Coordenada();
			
			coord.setId(result.getInt("coordenada_id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
				
			acolhido.setCoordenada(coord);
			
			instituicao = new Instituicao();
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horario_abertura"));
			instituicao.setHorarioFechamento(result.getString("horario_fechamento"));
			instituicao.setCoordenada(null);
			instituicao.setComentarios(null);
//			instituicao.setDescricoes(null);

			ender = new Endereco();
			
			ender.setId(result.getInt("endereco_id"));
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

		PreparedStatement pstm;
		String sql = "delete from alerta where id = ?";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	}

	@Override
	public List<Alerta> lerTudo() throws SQLException {
		
		Alerta alerta;
		Acolhido acolhido;
		Coordenada coord;
		Instituicao instituicao;
		Endereco ender;
		PreparedStatement pstm;
		ResultSet result;
		List<Alerta> alertas;
		String sql = "SELECT alerta.id AS alerta_id, alerta.*, acolhido.*, coordenada.*, instituicao.*, endereco.* "
					+ "FROM acolhido "
					+ "INNER JOIN coordenada "
					+ "ON acolhido.coordenada_id = coordenada.id "
					+ "INNER JOIN alerta "
					+ "ON acolhido.cpf = alerta.acolhido_cpf "
					+ "INNER JOIN instituicao "
					+ "ON alerta.instituicao_cnpj = instituicao.cnpj "
					+ "INNER JOIN endereco "
					+ "ON endereco.id = instituicao.endereco_id ";

		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		result = pstm.executeQuery();

		alertas = new ArrayList<Alerta>();

		while (result.next()) {

			alerta = new Alerta();
			
			alerta.setId(result.getInt("alerta_id"));
			alerta.setStatus(result.getString("status"));
			
			acolhido = new Acolhido();
			
			acolhido.setCpf(result.getString("cpf"));			
			acolhido.setRg(result.getString("rg"));
			acolhido.setNome(result.getString("nome"));
			acolhido.setTipoContato(result.getString("tipo_contato"));
			acolhido.setContato(result.getString("contato"));
			acolhido.setDataNascimento(result.getString("data_nascimento"));
				
			coord = new Coordenada();
			
			coord.setId(result.getInt("coordenada_id"));
			coord.setLatitude(result.getString("latitude"));
			coord.setLongitude(result.getString("longitude"));
				
			acolhido.setCoordenada(coord);
			
			instituicao = new Instituicao();
			instituicao.setCnpj(result.getString("cnpj"));
			instituicao.setRazaoSocial(result.getString("razao_social"));
			instituicao.setHorarioAbertura(result.getString("horario_abertura"));
			instituicao.setHorarioFechamento(result.getString("horario_fechamento"));
			instituicao.setCoordenada(null);
			instituicao.setComentarios(null);
//			instituicao.setDescricoes(null);
			
			ender = new Endereco();
			
			ender.setId(result.getInt("endereco_id"));
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
