package lab5;

public enum CalcSeguro {
	VALOR_BASE (10),
	FATOR_18_30 (1.25),
	FATOR_30_60 (1),
	FATOR_60_90 (1.5);
	
	public final double valores;
	
	CalcSeguro (double valores){
		this.valores = valores;
	}
}
