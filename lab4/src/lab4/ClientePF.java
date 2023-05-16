package lab4;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class ClientePF extends Cliente{
	private String cpf;
	private String genero;
	private LocalDate dataLicenca;;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;

	//Métodos
	public ClientePF(String nome, String endereco, double valorSeguro, String cpf,
			String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica) {
		super(nome, endereco, valorSeguro);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}

	//Getters e Setters (deixar private setters que não fazem sentido serem mudados 
	public String getCpf() {
		return cpf;
	}
	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
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

	private void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}


	// Métodos
	
	public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(this.dataNascimento, dataAtual);
        return periodo.getYears();
    }
	
	@Override
	public double calculaScore(){
		double FatorIdade;
		if (18 <= getIdade() && getIdade() < 30) {
			FatorIdade = CalcSeguro.FATOR_18_30.valores;
		}
		else if (30 <= getIdade() && getIdade() <60) {
			FatorIdade = CalcSeguro.FATOR_30_60.valores;
		}
		else {
			FatorIdade = CalcSeguro.FATOR_60_90.valores;
		}
		return CalcSeguro.VALOR_BASE.valores * FatorIdade * this.ListaVeiculos.size();
	}
	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " + this.getEndereco() + "\n\tValor do Seguro: " + this.getValorSeguro()
    + "\n\tCpf: " + this.cpf + 
        "\n\tGênero: " + this.genero + "\n\tData de Licença: " + this.dataLicenca + "\n\tEducação: " + this.educacao
        + "\n\tData de Nascimento: " + this.dataNascimento + "\n\tClasse Econômica: " + this.classeEconomica; 
    }
}
