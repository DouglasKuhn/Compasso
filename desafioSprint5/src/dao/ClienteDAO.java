package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public boolean add(Cliente cliente) throws IOException {
		escreverLinhaDoArquivo(fileName, ClienteConverter.converterClienteParaLinhaDoArquivo(cliente));
		return clientes.add(cliente);
	}
	
	public List<Cliente> findAll() {
		return Collections.unmodifiableList(clientes);
	}

	@Override
	public void lerLinhaDoArquivo(String linha) {
		clientes.add(ClienteConverter.converterLinhaDoArquivoParaCliente(linha));
	}
	
	public void escreverLinhaDoArquivo(String fileName, String linhaStr) throws IOException {
		boolean existeArquivo = new File(fileName).exists();
		FileWriter fileWriter = new FileWriter(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileWriter, true);
		if (existeArquivo) {
			printWriter.println(linhaStr);
		} else {
			printWriter.print(linhaStr);
		}
		printWriter.close();
		fileWriter.close();
	}
	
	
}
