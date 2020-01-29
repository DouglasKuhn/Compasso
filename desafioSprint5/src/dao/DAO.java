package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Converter;
import service.EscreverLinhaArquivo;
import service.LerArquivo;
import service.LerLinhaArquivo;

public class DAO implements LerLinhaArquivo {

	private static List<Object> objList = new ArrayList<Object>();
	private String fileName = "pessoas.txt";
	private static DAO instance;
	private LerArquivo lerArquivo = new LerArquivo(this);
	private EscreverLinhaArquivo escreverLinhaArquivo = new EscreverLinhaArquivo();

	public DAO() throws IOException {
		this.lerArquivo.readFile(fileName);
	}

	public static synchronized DAO getInstance() throws IOException {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	public boolean add(Object obj) {
		escreverLinhaDoArquivo(fileName, Converter.);
		return objList.add(obj);
	}

	@Override
	public void lerLinhaDoArquivo(String linha) {
		// TODO Auto-generated method stub

	}

}
