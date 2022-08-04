package br.com.acolhimento.lgbtq.model.repositorios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acolhimento.lgbtq.model.classes.*;

public class Fachada {
	
	private static Fachada myself = null;
	
	private Repositorio<Servico, Integer> rServico = null;
	private Repositorio<Endereco, Integer> rEndereco = null;
	private Repositorio<Coordenada, Integer> rCoordenada = null;
	private Repositorio<Local, Integer> rLocal = null;
	private RepositorioInstituicao rInstituicao = null;
	private RepositorioAcolhido rAcolhido = null;
	private RepositorioComentarioInstituicao rComentarioInstituicao = null;
	private RepositorioComentarioLocal rComentarioLocal = null;
	private Repositorio<Descricao, Integer> rDescricaoServico = null;
	private Repositorio<Alerta, Integer> rAlerta = null;
	
	private Fachada() {
		this.rServico = new RepositorioServico();
		this.rEndereco = new RepositorioEndereco();
		this.rCoordenada = new RepositorioCoordenada();
		this.rLocal = new RepositorioLocal();
		this.rInstituicao = new RepositorioInstituicao();
		this.rAcolhido = new RepositorioAcolhido();
		this.rComentarioInstituicao = new RepositorioComentarioInstituicao();
		this.rComentarioLocal = new RepositorioComentarioLocal();
		this.rDescricaoServico = new RepositorioDescricao();
		this.rAlerta = new RepositorioAlerta();
	}
	
	public static Fachada getCurrentInstance() {		
		if(myself == null)
			myself = new Fachada();
		
		return myself;		
	}
	
	// ################# SERVICO #################
	public int inserir(Servico servico) throws SQLException {		
		return this.rServico.inserir(servico);
	}
	
	public void alterar(Servico servico) throws SQLException {
		this.rServico.alterar(servico);
	}
	
	public Servico lerServico(int id) throws SQLException {
		return this.rServico.ler(id);
	}
	
	public void deletarServico(int id) throws SQLException {
		this.rServico.deletar(id);
	}
	
	public List<Servico> lerTodosServicos() throws SQLException{
		return this.rServico.lerTudo();
	}
	
	
	
	// ################# ENDERECO #################	
	public int inserir(Endereco endereco) throws SQLException {
		return this.rEndereco.inserir(endereco);
	}
	
	public void alterar(Endereco endereco) throws SQLException {
		this.rEndereco.alterar(endereco);
	}
	
	public Endereco lerEndereco(int id) throws SQLException {
		return this.rEndereco.ler(id);
	}
	
	public void deletarEndereco(int id) throws SQLException {
		this.rEndereco.deletar(id);
	}
	
	public List<Endereco> lerTodosEnderecos() throws SQLException{
		return this.rEndereco.lerTudo();
	}
	
	
	
	// ################# COORDENADA #################	
	public int inserir(Coordenada coord) throws SQLException {
		return this.rCoordenada.inserir(coord);
	}
	
	public void alterar(Coordenada coord) throws SQLException {
		this.rCoordenada.alterar(coord);
	}
	
	public Coordenada lerCoordenada(int id) throws SQLException {
		return this.rCoordenada.ler(id);
	}
	
	public void deletarCoordenada(int id) throws SQLException {
		this.rCoordenada.deletar(id);
	}
	
	public List<Coordenada> lerTodasCoordenadas() throws SQLException{
		return this.rCoordenada.lerTudo();
	}
	
	
	
	// ################# LOCAL #################	
	public int inserir(Local local) throws SQLException {
		return this.rLocal.inserir(local);
	}
	
	public void alterar(Local local) throws SQLException {
		this.rLocal.alterar(local);
	}
	
	public Local lerLocal(int id) throws SQLException {
		return this.rLocal.ler(id);
	}
	
	public void deletarLocal(int id) throws SQLException {
		this.rLocal.deletar(id);
	}
	
	public List<Local> lerTodosLocais() throws SQLException{
		return this.rLocal.lerTudo();
	}
	
	
	
	// ################# INSTITUICAO #################	
	public void inserir(Instituicao inst) throws SQLException {
		this.rInstituicao.inserir(inst);
	}
	
	public void alterar(Instituicao inst) throws SQLException {
		this.rInstituicao.alterar(inst);
	}
	
	public Instituicao lerInstituicao(String cnpj) throws SQLException {
		return this.rInstituicao.ler(cnpj);
	}
	
	public void deletarInstituicao(String cnpj) throws SQLException {
		this.rInstituicao.deletar(cnpj);
	}
	
	public List<Instituicao> lerTodasInstituicoes() throws SQLException{
		return this.rInstituicao.lerTudo();
	}
	
	public String autenticacaoInstituicao(String email, String senha) throws SQLException{		
		return this.rInstituicao.autenticacaoInstituicao(email, senha);
	}
	
	
	
	// ################# ACOLHIDO #################	
	public int inserir(Acolhido inst) throws SQLException {
		return this.rAcolhido.inserir(inst);
	}
	
	public void alterar(Acolhido inst) throws SQLException {
		this.rAcolhido.alterar(inst);
	}
	
	public Acolhido lerAcolhido(String cnpj) throws SQLException {
		return this.rAcolhido.ler(cnpj);
	}
	
	public void deletarAcolhido(String cnpj) throws SQLException {
		this.rAcolhido.deletar(cnpj);
	}
	
	public List<Acolhido> lerTodosAcolhidos() throws SQLException{
		return this.rAcolhido.lerTudo();
	}	
	
	public String autenticacaoAcolhido(String email, String senha) throws SQLException{		
		return this.rAcolhido.autenticacaoAcolhido(email, senha);
	}	
	
	
	
	// ################# COMENTARIO INSTITUICAO #################	
	public void inserir(ComentarioInstituicao comentario) throws SQLException {
		this.rComentarioInstituicao.inserir(comentario);
	}
	
	public void alterar(ComentarioInstituicao comentario) throws SQLException {
		this.rComentarioInstituicao.alterar(comentario);
	}
	
	public ComentarioInstituicao lerComentarioInstituicao(int id) throws SQLException {
		return this.rComentarioInstituicao.ler(id);
	}
	
	public void deletarComentarioInstituicao(int id) throws SQLException {
		this.rComentarioInstituicao.deletar(id);
	}
	
	public List<ComentarioInstituicao> lerTodosComentariosInstituicao() throws SQLException{
		return this.rComentarioInstituicao.lerTudo();
	}
	
	public ArrayList<ComentarioInstituicao> lerComentarioPorCnpjInstituicao(String cnpj) throws SQLException{
		return this.rComentarioInstituicao.lerComentarioPorCnpjInstituicao(cnpj);
	}
	
	public ArrayList<Descricao> lerDescricaoPorCnpjInstituicao(String cnpj) throws SQLException{
		return this.rComentarioInstituicao.lerDescricaoPorCnpjInstituicao(cnpj);
	}
	
	
	
	// ################# COMENTARIO LOCAL #################	
	public void inserir(ComentarioLocal comentario) throws SQLException {
		this.rComentarioLocal.inserir(comentario);
	}
	
	public void alterar(ComentarioLocal comentario) throws SQLException {
		this.rComentarioLocal.alterar(comentario);
	}
	
	public ComentarioLocal lerComentarioLocal(int id) throws SQLException {
		return this.rComentarioLocal.ler(id);
	}
	
	public void deletarComentarioLocal(int id) throws SQLException {
		this.rComentarioLocal.deletar(id);
	}
	
	public List<ComentarioLocal> lerTodosComentariosLocal() throws SQLException{
		return this.rComentarioLocal.lerTudo();
	}
	
	public ArrayList<ComentarioLocal> lerComentarioPorIdLocal(int id) throws SQLException{
		return this.rComentarioLocal.lerComentarioPorIdLocal(id);
	}
	
	
	
	// ################# DESCRICAO #################	
	public int inserir(Descricao descricao) throws SQLException {
		return this.rDescricaoServico.inserir(descricao);
	}
	
	public void alterar(Descricao descricao) throws SQLException {
		this.rDescricaoServico.alterar(descricao);
	}
	
	public Descricao lerDescricaoServico(int id) throws SQLException {
		return this.rDescricaoServico.ler(id);
	}
	
	public void deletarDescricaoServico(int id) throws SQLException {
		this.rDescricaoServico.deletar(id);
	}
	
	public List<Descricao> lerTodasDescricoeServicos() throws SQLException{
		return this.rDescricaoServico.lerTudo();
	}
	
	
	
	// ################# ALERTA #################	
	public int inserir(Alerta alerta) throws SQLException {
		return this.rAlerta.inserir(alerta);
	}
	
	public void alterar(Alerta alerta) throws SQLException {
		this.rAlerta.alterar(alerta);
	}
	
	public Alerta lerAlerta(int id) throws SQLException {
		return this.rAlerta.ler(id);
	}
	
	public void deletarAlerta(int id) throws SQLException {
		this.rAlerta.deletar(id);
	}
	
	public List<Alerta> lerTodosAlertas() throws SQLException{
		return this.rAlerta.lerTudo();
	}	
	
}
