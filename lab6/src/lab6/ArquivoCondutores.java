package lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoCondutores implements l_Arquivo{
	@Override
	public boolean gravarArquivo() {
		return true;
	}
	@Override
	public String lerArquivo()throws IOException {
        String caminhoArquivo = "src/lab6/lab06-seguradora_arquivos_v2/condutores.csv";
        StringBuilder conteudoArquivo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudoArquivo.append(linha).append("\n");
            }
        } catch (IOException e) {
            throw new IOException("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return conteudoArquivo.toString();
	}
	
	public Condutor[] criarArrayCondutores() {
	    // Dividir o conteúdo do arquivo em linhas
		String conteudoArquivo = "";
		try {
			conteudoArquivo = this.lerArquivo();
		}catch(IOException e){
            e.printStackTrace();
        }
		
	    String[] linhas = conteudoArquivo.split("\n");

	    Condutor[] condutores = new Condutor[linhas.length - 1];

	    for (int i = 1; i < linhas.length; i++) {
	        // Dividir a linha em colunas (utilizando a vírgula como separador)
	        String[] colunas = linhas[i].split(",");

	        // Extrair os valores das colunas
	        String cpf = colunas[0];
	        String nome = colunas[1];
	        String telefone = colunas[2];
	        String endereco = colunas[3];
	        String email = colunas[4];
	        String dataNascimento = colunas[5];
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate data = LocalDate.parse(dataNascimento, formatter);
	        // Criar um objeto Veículo com os valores extraídos
	        Condutor condutor = new Condutor(cpf, nome, telefone, endereco, email, data, new ArrayList<Sinistro>());    		
	        // Adicionar o veículo ao array de veículos
	        condutores[i - 1] = condutor; // O índice do array começa em 0, por isso subtrai 1 do índice i
	    }

	    // Retornar o array de veículos
	    return condutores;
	}

}
