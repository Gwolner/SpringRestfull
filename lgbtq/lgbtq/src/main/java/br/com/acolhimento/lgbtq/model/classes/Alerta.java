package br.com.acolhimento.lgbtq.model.classes;

public class Alerta {

	private int id;
	private String status;
	private Acolhido acolhido;
	private Instituicao instituicao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Acolhido getAcolhido() {
		return acolhido;
	}
	
	public void setAcolhido(Acolhido acolhido) {
		this.acolhido = acolhido;
	}
	
	public Instituicao getInstituicao() {
		return instituicao;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
}
