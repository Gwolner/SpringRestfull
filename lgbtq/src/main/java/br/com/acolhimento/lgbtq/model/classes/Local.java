package br.com.acolhimento.lgbtq.model.classes;

import java.util.ArrayList;

public class Local {

	private int id;
	private String nome;
	private String link;
	private String descricao;
	private Coordenada coordenada;
	private Endereco endereco;	
	private ArrayList<ComentarioLocal> comentarios;
	
	public Local(){
		this.coordenada = new Coordenada();
		this.endereco = new Endereco();
		this.comentarios = new ArrayList<ComentarioLocal>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public ArrayList<ComentarioLocal> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ComentarioLocal comentario) {
		this.comentarios.add(comentario);
	}
	
}
