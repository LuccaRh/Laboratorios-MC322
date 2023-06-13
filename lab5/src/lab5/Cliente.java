package lab5;

public abstract class Cliente {
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	
	public Cliente(String nome, String endereco, String email, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}

	//Getters e Setters
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
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
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
    public String toString() {
        return "Nome: " + this.nome + "\n\tEndereço: " + this.endereco  + "\n\tTelefone: " + this.telefone + "\n\tEmail: " + this.email; 
    }
	
}