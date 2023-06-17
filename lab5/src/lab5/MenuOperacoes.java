package lab5;

public enum MenuOperacoes {
	CADASTROS (1),
    GERAR (2),
    EXCLUIR (3), 
    LISTAR (4), 
    CALCULARRECEITA(5),
	SAIR (6);
	
	public final int valores;
	
	MenuOperacoes (int valores){
		this.valores = valores;
	}
}
