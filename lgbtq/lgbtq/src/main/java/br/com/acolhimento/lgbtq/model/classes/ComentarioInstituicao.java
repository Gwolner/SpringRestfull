package br.com.acolhimento.lgbtq.model.classes;

public class ComentarioInstituicao {
	
	private int id;
	private String texto;
	private String cnpjInstituicao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCnpjInstituicao() {
		return cnpjInstituicao;
	}

	public void setCnpjInstituicao(String cnpjInstituicao) {
		this.cnpjInstituicao = cnpjInstituicao;
	}
	
}
