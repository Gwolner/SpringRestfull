package br.com.acolhimento.lgbtq.model.classes;

public class Acolhido {

	private String cpf;
	private String rg;
	private String nome;
	private String tipoContato;
	private String contato;
	private String dataNascimento;
	private Coordenada coordenada;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipoContato() {
		return tipoContato;
	}
	
	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
	
}
