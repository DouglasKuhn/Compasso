package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import converter.ClienteConverter;
import model.Cliente;
import service.LerArquivo;
import service.LerLinhaArquivo;

public class ClienteDAO implements LerLinhaArquivo{

	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private String fileName = "Clientes.txt";
	private static ClienteDAO instance;
	private LerArquivo lerArquivo = new LerArquivo(this);
	
	public ClienteDAO() throws IOException {
		this.lerArquivo.readFile(fileName);
	}
	
	public static synchronized ClienteDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}
	
	public void add(Cliente cliente) throws IOException {
		clientes.add(cliente);
		ordenaPorNome(clientes);
		escreverLinhaDoArquivo(fileName, clientes);
	}
	
	public List<Cliente> findAll() {
		return Collections.unmodifiableList(clientes);
	}

	@Override
	public void lerLinhaDoArquivo(String linha) {
		clientes.add(ClienteConverter.converterLinhaDoArquivoParaCliente(linha));
	}
	
	public void escreverLinhaDoArquivo(String fileName, List<Cliente> lstCliente) throws IOException {
		boolean existeArquivo = new File(fileName).exists();
		FileWriter fileWriter = new FileWriter(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileWriter, true);
		if (existeArquivo) {
			for (Cliente cli : lstCliente) {
				printWriter.println(ClienteConverter.converterClienteParaLinhaDoArquivo(cli));
			}
		} else {
			for (Cliente cli : lstCliente) {
				printWriter.print(ClienteConverter.converterClienteParaLinhaDoArquivo(cli));
			}
		}
		printWriter.close();
		fileWriter.close();
	}
	
	private static void ordenaPorNome(List<Cliente> lista) {
		Collections.sort(lista, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente p1, Cliente p2) {
				return p1.getNome().compareTo(p2.getNome());
			}
		});
	}
	
	
}
