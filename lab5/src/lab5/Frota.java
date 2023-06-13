package lab5;

import java.util.ArrayList;

public class Frota {
	private String code;
	private ArrayList<Veículo> listaVeiculos = new ArrayList<Veículo>();
	
	
	public Frota(String code, ArrayList<Veículo> listaVeiculos) {
		super();
		this.code = code;
		this.listaVeiculos = listaVeiculos;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<Veículo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(ArrayList<Veículo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public boolean addVeiculo(Veículo veiculo) {
		if (veiculo == null) {
			return false;
		}
		this.listaVeiculos.add(veiculo);
		return true;
	}
	public boolean removeVeiculo(String placa) {
		for (Veículo veiculo: this.listaVeiculos) {
	        if (veiculo.getPlaca().equalsIgnoreCase(placa)) { 
	        	this.listaVeiculos.remove(veiculo); 
	            return true; 
	        }
	    }
	    return false;
	}
	@Override
    public String toString() {
		StringBuilder placas = new StringBuilder();
		for (Veículo veiculo : this.listaVeiculos) {
            placas.append("\n\t").append("Placa: ").append(veiculo.getPlaca());
        }
        return "Code: " + this.code + "\n\tVeículos: " + placas;
    }
}
