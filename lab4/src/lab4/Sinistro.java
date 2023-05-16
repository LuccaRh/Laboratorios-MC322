package lab4;
import java.time.LocalDate;

public class Sinistro {
	private LocalDate data;
	private String endereco;
	private static int idStatic;
	private int id;
	public Seguradora seguradora;
	public Cliente cliente;
	public Veículo veiculo;
	
	//Constructor
	public Sinistro(LocalDate data, String endereco, Cliente cliente, Veículo veiculo, Seguradora seguradora) {
		this.data = data;
		this.endereco = endereco;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.seguradora = seguradora;
		++idStatic;
		id = idStatic;
	}
	
	//Getters e Setters
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	//Id possui apenas um get, para não ser possível mudar o id de um objeto pós sua criação
	public int getId() {
		return id;
	}
	
	@Override
    public String toString() {
        return "Nome do cliente: " + this.cliente.getNome() + "\n\tPlaca do veículo: " + this.veiculo.getPlaca()+ "\n\tData: " + this.data + "\n\tEndereço: " + this.endereco + "\n\tID: " + this.id;
    }
	
}