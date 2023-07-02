package lab6;
import java.time.LocalDate;
import java.time.Period;


public class ClientePF extends Cliente{
	private String cpf;
	private String genero;
	private String educacao;
	private LocalDate dataNascimento;
	private Veículo veiculo;	

	//Constructor
	public ClientePF(String nome, String endereco, String email, String telefone, String cpf, String genero,
			String educacao, LocalDate dataNascimento, Veículo veiculo) {
		super(nome, endereco, email, telefone);
		this.cpf = cpf;
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.veiculo = veiculo;
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

	public Veículo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veículo veiculo) {
		this.veiculo = veiculo;
	}

	//Métodos
	public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(this.dataNascimento, dataAtual);
        return periodo.getYears();
    }
	
	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " + this.getEndereco()     + "\n\tCpf: " + this.cpf + 
        "\n\tGênero: " + this.genero + "\n\tEducação: " + this.educacao
        + "\n\tData de Nascimento: " + this.dataNascimento + "\n\tPlaca do veículo:" + this.veiculo.getPlaca(); 
    }
}
