package maven.demo;

public class Carro {
	private String id;
	private String marca;
	private String modelo;
	private String placa;
	
	public Carro() {
		this.setId("");
		this.marca = "";
		this.modelo = "";
		this.placa = "";
	}
	
	public Carro(String id, String marca, String modelo, String placa) {
		this.setId(id);
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}


	@Override
	public String toString() {
		return "Usuario [codigo=" + marca + ", login=" + marca + ", senha=" + modelo + ", sexo=" + placa + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}	
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}	
}
