package lab4;

public enum CalcSeguro {
	VALOR_BASE (100),
	FATOR_18_30 (1.2),
	FATOR_30_60 (1),
	FATOR_60_90 (1.5);
	
	public final double valores;
	
	CalcSeguro (double valores){
		this.valores = valores;
	}
}
