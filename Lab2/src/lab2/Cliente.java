package lab2;
public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String endereco;
	private int idade;
	
	// Constructor
	public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.idade = idade;
	}
	
	// Getters e Setters
	// Setters de atributos que não fazem sentido serem mudados serão privados (cpf, dataNascimento)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	private void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	// Métodos
	// Verificar se um cpf tem todos digitos iguais
	private boolean digitosIguais(String cpfResultado) {
		char firstNumero = cpfResultado.charAt(0);
	    
		//Comparar primeiro digito com todos os outros
		//Se um deles for difirente, então o cpf não tem todos digitos iguais, assim retornando true
	    for (int i = 1; i < cpfResultado.length(); i++) {
	        if (cpfResultado.charAt(i) != firstNumero) {
	            return true;
	        }
	    }
	   //Se forem comparados todos os digitos, e forem iguais, é retornando false
	    return false;
	}
	
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
		int[] verificador = {10, 9, 8, 7, 6, 5, 4, 3, 2, 0};
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
		verificador[9] = primeiroDigito;
		//Segundo digito
		int somatorio2 = 0;
		for (int i = 0; i < tamanho - 1; i++) {
			somatorio2 += verificador[i] * Integer.parseInt(cpfStringArray[i]);
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
}