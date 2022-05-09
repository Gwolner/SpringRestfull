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
	private ArrayList<DescricaoServico> descricoes;
	
	
	public Instituicao(){
		this.comentarios = new ArrayList<ComentarioInstituicao>();
		this.descricoes = new ArrayList<DescricaoServico>();
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


	public void setComentarios(ComentarioInstituicao comentario) {
		this.comentarios.add(comentario);
	}


	public ArrayList<DescricaoServico> getDescricoes() {
		return descricoes;
	}


	public void setDescricoes(DescricaoServico descricao) {
		this.descricoes.add(descricao);
	}
	
	
	
	

}
