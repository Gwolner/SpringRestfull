package br.com.acolhimento.lgbtq.model.classes;

import java.util.ArrayList;

public class Instituicao {

	private String cnpj;
	private String razaoSocial;
	private String horarioAbertura;
	private String horarioFechamento;
	private Coordenada coordenada;
	private Endereco endereco;
	private ArrayList<ComentarioInstituicao> comentarios;
	private ArrayList<Descricao> descricoes;
	
	private String email;
	private String senha;	
	
	public Instituicao(){
		this.coordenada = new Coordenada();
		this.endereco = new Endereco();
		this.comentarios = new ArrayList<ComentarioInstituicao>();
		this.descricoes = new ArrayList<Descricao>();
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(String horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public String getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(String horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public ArrayList<ComentarioInstituicao> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<ComentarioInstituicao> comentarios) {
		this.comentarios = comentarios;
	}

	public ArrayList<Descricao> getDescricoes() {
		return descricoes;
	}

	public void setDescricoes(ArrayList<Descricao> descricoes) {
		this.descricoes = descricoes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
