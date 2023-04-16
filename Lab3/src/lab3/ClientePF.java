package lab3;
import java.time.LocalDate;

public class ClientePF extends Cliente{
	private String cpf;
	private String genero;
	private LocalDate dataLicenca;;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;


	public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao,
			LocalDate dataNascimento, String classeEconomica) {
		super(nome, endereco);
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
	public boolean validarCpf() {
		//utilização de regex com replace all para remover tudo que não seja numero da string
		String cpfResultado = this.cpf.replaceAll("[^\\d]", "");
		//Verificação do tamanho do cpf, se não tiver 11 digitos, retorna false
		int tamanho = cpfResultado.length(); 
		if (tamanho != 11) { 
			return false;
		}
		
		//Verificação se todos digitos do cpf são iguais, se forem, retorna false
		boolean igual = digitosIguais(cpfResultado);
		if (!igual) {
			return false;
		}
		
		//Verificar digito verificador
		//Primeiro Digito
		int[] verificador = {10, 9, 8, 7, 6, 5, 4, 3, 2};
		String[] cpfStringArray = cpfResultado.split("");
		int somatorio1 = 0;
		for (int i = 0; i < tamanho - 2; i++) {
			somatorio1 += verificador[i] * Integer.parseInt(cpfStringArray[i]);
		}
		int resto = somatorio1 % 11;
		int primeiroDigito = 11 - resto;
		if (primeiroDigito > 9) {
			primeiroDigito = 0;
		}
		if (primeiroDigito != Integer.parseInt(cpfStringArray[9])) {
			return false;
		}
		//Segundo digito
		int[] verificador2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		int somatorio2 = 0;
		for (int i = 0; i < tamanho - 1; i++) {
			somatorio2 += verificador2[i] * Integer.parseInt(cpfStringArray[i]);
		}
		int resto2 = somatorio2 % 11;
		int SegundoDigito = 11 - resto2;
		if (SegundoDigito > 9) {
			SegundoDigito = 0;
		}
		if (SegundoDigito != Integer.parseInt(cpfStringArray[10])) {
			return false;
		}
		return true;
	}
	
	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " + this.getEndereco() + "\n\tCpf: " + this.cpf + 
        "\n\tGênero: " + this.genero + "\n\tData de Licença: " + this.dataLicenca + "\n\tEducação: " + this.educacao
        + "\n\tData de Nascimento: " + this.dataNascimento + "\n\tClasse Econômica: " + this.classeEconomica; 
    }
}
