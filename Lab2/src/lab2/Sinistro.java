package lab2;

public class Sinistro {
	private String data;
	private String endereco;
	private static int idStatic;
	private int id;
	
	//Constructor
	public Sinistro(String data, String endereco) {
		this.data = data;
		this.endereco = endereco;
		++idStatic;
		id = idStatic;
		
	}
	
	//Getters e Setters
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
	
}