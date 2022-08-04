package br.com.acolhimento.lgbtq.model.classes;

public class Coordenada {

	private int id;
	private String longitude;
	private String latitude;
	
	public Coordenada() {
		this.id = 0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}	
	
}
