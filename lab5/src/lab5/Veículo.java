package lab5;

public class Veículo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	//Constructor
	public Veículo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	
	//Getters e Setters	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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
	
	@Override
    public String toString() {
        return "Placa: " + this.placa + "\n\tMarca: " + this.marca + "\n\tModelo: " + this.modelo + "\n\tAno de Fabricação: " + this.anoFabricacao;
    }
	
}