package lab6;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {

	public static void main(String[] args) {
		
		
		//Clientes
		ArrayList<Cliente> listaClienteX = new ArrayList<Cliente>();
		ArrayList<Cliente> listaClienteY = new ArrayList<Cliente>();
		ArrayList<Cliente> listaClienteZ = new ArrayList<Cliente>();
		
		ArquivoClientePF arquivoClientePF = new ArquivoClientePF();
		Cliente[] clientespf = arquivoClientePF.criarArrayClientesPF();
		for (int i = 0; i<10; i++) {
			if (i < 4) {
				listaClienteX.add(clientespf[i]);
			}
			else if (4<= i && i <7) {
				listaClienteY.add(clientespf[i]);
			}
			else {
				listaClienteZ.add(clientespf[i]);
			}
		}
        
		ArquivoClientePJ arquivoClientePJ = new ArquivoClientePJ();
		Cliente[] clientespj = arquivoClientePJ.criarArrayClientesPJ();
		for (int i = 0; i<5; i++) {
			if (i == 0) {
				listaClienteX.add(clientespj[i]);
			}
			else if (2 <= i) {
				listaClienteY.add(clientespj[i]);
			}
			else {
				listaClienteZ.add(clientespj[i]);
			}
		}
        

        //Criar Seguradoras
		Seguradora seguradoraX = new Seguradora("SeguradoraX", "19-997645670", "SeguradoraX@gmail.com", "BG", "21.901.626/0001-49", new ArrayList<Seguro>(), listaClienteX);
		Seguradora seguradoraY = new Seguradora("SeguradoraY", "11-994565970", "SeguradoraY@gmail.com", "SP", "79.999.869/0001-41", new ArrayList<Seguro>(), listaClienteY);
		Seguradora seguradoraZ = new Seguradora("SeguradoraZ", "11-994375370", "SeguradoraZ@gmail.com", "SP", "04.067.503/0001-35", new ArrayList<Seguro>(), listaClienteZ);
		
		
		ArquivoCondutores arquivoCondutores = new ArquivoCondutores();
		Condutor[] condutores = arquivoCondutores.criarArrayCondutores();
		ArrayList<Condutor> condutoresX = new ArrayList<>();
		ArrayList<Condutor> condutoresY = new ArrayList<>();
		ArrayList<Condutor> condutoresZ = new ArrayList<>();
		
		for (int i = 0; i<10; i++) {
			if (i < 3) {
				condutoresX.add(condutores[i]);
			}
			else if (i<6) {
				condutoresY.add(condutores[i]);
			}
			else {
				condutoresZ.add(condutores[i]);
			}
		}
		
		ArquivoVeículo arquivoVeiculos = new ArquivoVeículo();
		Veículo[] veiculos = arquivoVeiculos.criarArrayVeiculos();
		//Seguros
		
		SeguroPF seguroX = new SeguroPF(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31), seguradoraX,
				new ArrayList<Sinistro>(), condutoresX, veiculos[0], (ClientePF) clientespf[0]);
		SeguroPF seguroY = new SeguroPF(LocalDate.of(2022, 3, 15), LocalDate.of(2023, 3, 14), seguradoraY,
				new ArrayList<Sinistro>(), condutoresY, veiculos[1], (ClientePF) clientespf[1]);
		SeguroPF seguroZ = new SeguroPF(LocalDate.of(2022, 6, 20), LocalDate.of(2023, 6, 19), seguradoraZ,
				new ArrayList<Sinistro>(), condutoresZ, veiculos[2], (ClientePF) clientespf[2]);
		//Sinistros
		
		Sinistro sinistro1 = new Sinistro(LocalDate.of(2022, 5, 1), "Rua A", seguroX, condutores[0]);
		Sinistro sinistro2 = new Sinistro(LocalDate.of(2023, 5, 2), "Rua B", seguroY, condutores[1]);
		Sinistro sinistro3 = new Sinistro(LocalDate.of(2023, 5, 3), "Rua C", seguroZ, condutores[2]);
		
		seguroX.getListaSinistro().add(sinistro1);
		seguroY.getListaSinistro().add(sinistro2);
		seguroZ.getListaSinistro().add(sinistro3);
		
		//Criação de arquivos
		String caminhoArquivoSeguro = "src/lab6/lab06-seguradora_arquivos_v2/seguros.csv";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoSeguro))) {
            // Escrever o cabeçalho do arquivo
            writer.write("Id, Data Início, Data Fim, Seguradora, lista Sinistros, lista Condutores, Valor Mensal");
            writer.newLine();

            // Escrever os dados no arquivo
            writer.write(seguroX.toString());
            writer.newLine();
            writer.write(seguroY.toString());
            writer.newLine();
            writer.write(seguroZ.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
		
		String caminhoArquivoSinistro = "src/lab6/lab06-seguradora_arquivos_v2/sinistros.csv";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoSinistro))) {
            // Escrever o cabeçalho do arquivo
            writer.write("Id, Data, Endereço, condutor, Seguro");
            writer.newLine();

            // Escrever os dados no arquivo
            writer.write(sinistro1.toString());
            writer.newLine();
            writer.write(sinistro2.toString());
            writer.newLine();
            writer.write(sinistro3.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
		
		//Mostrar arquivos em tabelas
        String[] colunas = {"Id","Data Início","Data Fim","Seguradora", "Lista Sinistros", "Lista Condutores", "Valor mensal"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivoSeguro))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                tableModel.addRow(dados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JTable table = new JTable();
        table.setModel(tableModel);
        
        String[] colunas1 = {"Id","Data","Endereço","Condutor", "Seguro"};
        DefaultTableModel tableModel1 = new DefaultTableModel(colunas1, 0);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivoSinistro))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                tableModel1.addRow(dados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JTable table1 = new JTable();
        table1.setModel(tableModel1);
        
        
        
        
		SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try {
					new Interface(table, table1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	}
}
