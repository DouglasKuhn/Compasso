package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import converter.ProdutoConverter;
import model.Produto;
import service.LerArquivo;
import service.LerLinhaArquivo;

public class ProdutoDAO implements LerLinhaArquivo{

	private static List<Produto> produtos = new ArrayList<Produto>();
	private String fileName = "Produtos.txt";
	private static ProdutoDAO instance;
	private LerArquivo lerArquivo = new LerArquivo(this);
	
	public ProdutoDAO() throws IOException {
		this.lerArquivo.readFile(fileName);
	}

	public static synchronized ProdutoDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}

	public boolean add(Produto produto) throws IOException {
		escreverLinhaDoArquivo(fileName, ProdutoConverter.converterProdutoParaLinhaDoArquivo(produto));
		return produtos.add(produto);
	}
	
	public List<Produto> findAll() {
		return Collections.unmodifiableList(produtos);
	}

	@Override
	public void lerLinhaDoArquivo(String linha) {
		produtos.add(ProdutoConverter.converterLinhaDoArquivoParaProduto(linha));
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
