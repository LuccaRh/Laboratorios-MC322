package lab5;
import java.util.Scanner;

public enum MenuOperacoes {
	CADASTROS (1),
    LISTAR (2),
    EXCLUIR (3),
    GERARSINISTRO (4),
	TRANSFERIRSEGURO (5),
	CALCRECEITASEGURADORA (6),
	SAIR (7);
	
	public final int valores;
	
	MenuOperacoes (int valores){
		this.valores = valores;
	}
}
