package lab6;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
	private int id;
	private static int idStatic;
	private double valorMensal;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> ListaSinistro = new ArrayList<Sinistro>();
	private ArrayList<Condutor> ListaCondutor = new ArrayList<Condutor>();
	
	//Constructor
	public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
			ArrayList<Sinistro> listaSinistro, ArrayList<Condutor> listaCondutor) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		ListaSinistro = listaSinistro;
		ListaCondutor = listaCondutor;
		++idStatic;
		id = idStatic;
	}
	
	//Getters e Setters
	public double getvalorMensal() {
		return valorMensal;
	}
	public void setvalorMensal(int valorMensal) {
		this.valorMensal = valorMensal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public ArrayList<Sinistro> getListaSinistro() {
		return ListaSinistro;
	}
	public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
		ListaSinistro = listaSinistro;
	}
	public ArrayList<Condutor> getListaCondutor() {
		return ListaCondutor;
	}
	public void setListaCondutor(ArrayList<Condutor> listaCondutor) {
		ListaCondutor = listaCondutor;
	}

	//Métodos
	public boolean autorizarCondutor(Condutor condutor) {
		if (condutor == null) {
			return false;
		}
		this.ListaCondutor.add(condutor);
		return true;
	}
	
	public boolean desautorizarCondutor(String cpf) {
	    for (Condutor condutor: this.ListaCondutor) {
	        if (condutor.getCpf().equalsIgnoreCase(cpf)) { 
	        	this.ListaCondutor.remove(condutor); 
	            return true; 
	        }
	    }
	    return false;
	}
	
	public boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor) {
		Sinistro sinistro = new Sinistro(data, endereco, this, condutor);
		this.ListaSinistro.add(sinistro);
		return true;
	}
	public abstract Cliente getCliente();
	public abstract double calculaValor(Seguradora seguradora);
	@Override
    public String toString() {
        return "Id: " + this.getId()+ "\n\tNome da Seguradora: " + this.seguradora.getNome() + "\n\tValor Mensal: " + this.getvalorMensal(); 
    }
}
