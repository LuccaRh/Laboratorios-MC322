package lab3;
import java.util.ArrayList;
public class Cliente {
	private String nome;
	private String endereco;
	public ArrayList <Veículo> ListaVeiculos = new ArrayList<Veículo>();
	
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	// Métodos
	// Verificar se um cpf/cnpj tem todos digitos iguais
	public boolean digitosIguais(String Resultado) {
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
	@Override
    public String toString() {
        return "Nome: " + this.nome + "\n\tEndereço: " + this.endereco; 
    }
	
}