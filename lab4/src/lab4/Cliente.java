package lab4;
import java.util.ArrayList;
public abstract class Cliente {
	private String nome;
	private String endereco;
	private double valorSeguro;
	public ArrayList <Veículo> ListaVeiculos = new ArrayList<Veículo>();

	public Cliente(String nome, String endereco, double valorSeguro) {
		this.nome = nome;
		this.endereco = endereco;
		this.valorSeguro = valorSeguro;
	}

	//Getters e Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public ArrayList<Veículo> getListaVeiculos() {
		return ListaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veículo> listaVeiculos) {
		ListaVeiculos = listaVeiculos;
	}

	// Métodos
	public abstract double calculaScore();
	
	@Override
    public String toString() {
        return "Nome: " + this.nome + "\n\tEndereço: " + this.endereco; 
    }
	
}