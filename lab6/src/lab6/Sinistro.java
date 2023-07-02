package lab6;
import java.time.LocalDate;

public class Sinistro {
	private LocalDate data;
	private String endereco;
	private static int idStatic;
	private int id;
	private Seguro seguro;
	private Condutor condutor;
	
	//Constructor
	public Sinistro(LocalDate data, String endereco, Seguro seguro, Condutor condutor) {
		this.data = data;
		this.endereco = endereco;
		this.seguro = seguro;
		this.condutor = condutor;
		++idStatic;
		this.id = idStatic;
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}



	@Override
    public String toString() {
        return this.getId() + "," + this.getData() + "," + this.getEndereco() + "," + this.getCondutor().getCpf() + "," + this.getSeguro().getId();
    }
	
}