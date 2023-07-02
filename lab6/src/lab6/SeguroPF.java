package lab6;

import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPF extends Seguro{
	private Veículo veiculo;
	private ClientePF cliente;
	
	//Constructor
	
	public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
			ArrayList<Sinistro> listaSinistro, ArrayList<Condutor> listaCondutor, Veículo veiculo, ClientePF cliente) {
		super(dataInicio, dataFim, seguradora, listaSinistro, listaCondutor);
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	//Getters e Setters
	public Veículo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veículo veiculo) {
		this.veiculo = veiculo;
	}

	public ClientePF getCliente() {
		return cliente;
	}
	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}
	
	//Métodos
	
	public double calculaValor(Seguradora seguradora){
		double FatorIdade;
		if (cliente.getIdade() < 30) {
			FatorIdade = CalcSeguro.FATOR_18_30.valores;
		}
		else if (30 <= cliente.getIdade() && cliente.getIdade() <60) {
			FatorIdade = CalcSeguro.FATOR_30_60.valores;
		}
		else {
			FatorIdade = CalcSeguro.FATOR_60_90.valores;
		}

		return CalcSeguro.VALOR_BASE.valores * FatorIdade * (1 + 1/(seguradora.getSegurosPorCliente(this.cliente).size()+2)) 
			* (2 + seguradora.getSinistrosPorCliente(this.cliente).size()/10) * (5 + seguradora.getSinistrosPorCondutores(this.cliente).size()/10);
	}
	
	@Override
    public String toString() {
		StringBuilder condutores = new StringBuilder();
		for (Condutor condutor : this.getListaCondutor()) {
			condutores.append(condutor.getCpf()).append(";");
        }
		int lastIndexC = condutores.length() - 1;
		condutores.deleteCharAt(lastIndexC);
		String condutoresCpf = condutores.toString();
		
		StringBuilder sinistros  = new StringBuilder();
		for (Sinistro sinistro: this.getListaSinistro()) {
            sinistros.append(sinistro.getId()).append(";");
        }
		int lastIndex = sinistros.length() - 1;
		sinistros.deleteCharAt(lastIndex);
		String sinistrosId = sinistros.toString();
        return this.getId() + "," + this.getDataInicio() + "," + this.getDataFim() + "," + this.getSeguradora().getNome() + "," + sinistrosId 
        		+ "," + condutoresCpf + "," + calculaValor(this.getSeguradora()); 
    }
}
