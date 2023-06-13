package lab5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
	private String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private LocalDate dataNasc;
	private ArrayList<Sinistro> listaSinistro = new ArrayList<Sinistro>();
	
	//Constructor
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc,
			ArrayList<Sinistro> listaSinistro) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNasc = dataNasc;
		this.listaSinistro = listaSinistro;
	}
	
	//Getters e Setters
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public ArrayList<Sinistro> getListaSinistro() {
		return listaSinistro;
	}
	public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
		listaSinistro = listaSinistro;
	}
	
	//Métodos
	public boolean adicionarSinistro(Sinistro sinistro) {
		if (sinistro == null) {
			return false;
		}
		this.listaSinistro.add(sinistro);
		return true;
	}
	
	@Override
    public String toString() {
        return "Nome do condutor: " + this.getNome() + "\n\tTelefone:" + this.getTelefone()+ "\n\tEmail: " + this.getEmail() + "\n\tCpf:" + this.getCpf()
        + "\n\tQuantidade de Sinistros:" + this.listaSinistro.size();
    }
}
