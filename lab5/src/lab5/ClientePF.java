package lab5;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class ClientePF extends Cliente{
	private String cpf;
	private String genero;
	private String educacao;
	private LocalDate dataNascimento;
	private ArrayList <Veículo> listaVeiculos = new ArrayList<Veículo>();	

	//Constructor
	public ClientePF(String nome, String endereco, String email, String telefone, String cpf, String genero,
			String educacao, LocalDate dataNascimento, ArrayList<Veículo> listaVeiculos) {
		super(nome, endereco, email, telefone);
		this.cpf = cpf;
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.listaVeiculos = listaVeiculos;
	}

	//Getters e Setters
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEducacao() {
		return educacao;
	}
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public ArrayList<Veículo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(ArrayList<Veículo> listaVeiculos) {
		listaVeiculos = listaVeiculos;
	}

	//Métodos
	public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(this.dataNascimento, dataAtual);
        return periodo.getYears();
    }
	public boolean cadastrarVeiculo(Veículo veiculo) {
		if (veiculo == null) {
			return false;
		}
		this.listaVeiculos.add(veiculo);
		return true;
	}
	public boolean removerVeiculo(String placa) {
		for (Veículo veiculo: this.listaVeiculos) {
	        if (veiculo.getPlaca().equalsIgnoreCase(placa)) { 
	        	this.listaVeiculos.remove(veiculo); 
	            return true; 
	        }
	    }
	    return false;
	}
	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " + this.getEndereco()     + "\n\tCpf: " + this.cpf + 
        "\n\tGênero: " + this.genero + "\n\tEducação: " + this.educacao
        + "\n\tData de Nascimento: " + this.dataNascimento + "\n\tQuantidade de Veiculos:" + this.listaVeiculos.size(); 
    }
}
