package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Converter;
//import service.LerArquivo;
import service.LerLinhaArquivo;

public class DAO implements LerLinhaArquivo {

	private static List<Object> objList = new ArrayList<Object>();
//	private String fileName = "pessoas.txt";
	private static DAO instance;
//	private LerArquivo lerArquivo = new LerArquivo(this);
	private Converter converter;

	public DAO() throws IOException {
//		this.lerArquivo.readFile(fileName);
	}

	public static synchronized DAO getInstance() throws IOException {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	public void add(Object obj) throws IOException {
		System.out.println(obj.getClass() + ".txt");
		escreverLinhaDoArquivo((obj.getClass() + ".txt"), converter.converterParaLinhaDoArquivo());
		objList.add(obj);
	}

	public List<Object> findAll() {
		return Collections.unmodifiableList(objList);
	}

	@Override
	public void lerLinhaDoArquivo(String linha) {
		objList.add(converter.converterLinhaDoArquivo(linha));
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
