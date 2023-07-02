package lab6;
import java.text.Normalizer;

public class Validacao {
	public static class ValidacaoStatic{
		// Verificar se um cpf/cnpj tem todos digitos iguais
		public static boolean digitosIguais(String Resultado) {
			char firstNumero = Resultado.charAt(0);
		    
			//Comparar primeiro digito com todos os outros
			//Se um deles for difirente, então o resultado não tem todos digitos iguais, assim retornando true
		    for (int i = 1; i < Resultado.length(); i++) {
		        if (Resultado.charAt(i) != firstNumero) {
		            return true;
		        }
		    }
		   //Se forem comparados todos os digitos, e forem iguais, é retornando false
		    return false;
		}
		public static boolean validarCpf(String cpf) {
			//utilização de regex com replace all para remover tudo que não seja numero da string
			String cpfResultado = cpf.replaceAll("[^\\d]", "");
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
		public static boolean validarCnpj(String cnpj) {
			//utilização de regex com replace all para remover tudo que não seja numero da string
			String cnpjResultado = cnpj.replaceAll("[^\\d]", "");
			
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
	public static boolean validaNome(String nome) {
		String nomeSemAcentos = Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		if(nomeSemAcentos.matches("[a-zA-Z]+")) {
		    return true;
		} else {
		    System.out.println("Escreve um nome apenas com letras e acentuações.");
		    return false;
		}
	}
	}
}
