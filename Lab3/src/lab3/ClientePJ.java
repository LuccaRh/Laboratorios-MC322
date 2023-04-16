package lab3;
import java.time.LocalDate;

public class ClientePJ extends Cliente{
	private String cnpj;
	private LocalDate dataFundacao;
	public ClientePJ(String nome, String endereco, String cpnj, LocalDate dataFundacao) {
		super(nome, endereco);
		this.cnpj = cpnj;
		this.dataFundacao = dataFundacao;
	}
	
	//Getters e Setters (deixar private setters que não fazem sentido serem mudados)
	public String getCpnj() {
		return cnpj;
	}
	private void setCpnj(String cpnj) {
		this.cnpj = cpnj;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	//Métodos
	
	public boolean validarCnpj() {
		//utilização de regex com replace all para remover tudo que não seja numero da string
		String cnpjResultado = this.cnpj.replaceAll("[^\\d]", "");
		
		//Verificação do tamanho do cpf, se não tiver 14 digitos, retorna false
		int tamanho = cnpjResultado.length(); 
		if (tamanho != 14) { 
			return false;
		}
		
		//Verificação se todos digitos do cnpj são iguais, se forem, retorna false
		boolean igual = digitosIguais(cnpjResultado);
		if (!igual) {
			return false;
		}
		
		//Verificar digito verificador
		//Primeiro Digito
		int[] verificador = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		String[] cnpjStringArray = cnpjResultado.split("");
		int somatorio1 = 0;
		for (int i = 0; i < tamanho - 2; i++) {
			somatorio1 += verificador[i] * Integer.parseInt(cnpjStringArray[i]);
		}
		int resto = somatorio1 % 11;
		int primeiroDigito = 11 - resto;
		if (primeiroDigito > 9) {
			primeiroDigito = 0;
		}
		if (primeiroDigito != Integer.parseInt(cnpjStringArray[12])) {
			return false;
		}
		//Segundo digito
		int[] verificador2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		int somatorio2 = 0;
		for (int i = 0; i < tamanho - 1; i++) {
			somatorio2 += verificador2[i] * Integer.parseInt(cnpjStringArray[i]);
		}
		int resto2 = somatorio2 % 11;
		int SegundoDigito = 11 - resto2;
		if (SegundoDigito > 9) {
			SegundoDigito = 0;
		}
		if (SegundoDigito != Integer.parseInt(cnpjStringArray[13])) {
			return false;
		}
		return true;
	}
}
