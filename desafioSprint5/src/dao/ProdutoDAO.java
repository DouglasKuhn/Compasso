package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import converter.ProdutoConverter;
import model.Produto;
import service.LerArquivo;
import service.LerLinhaArquivo;

public class ProdutoDAO implements LerLinhaArquivo {

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

	public void add(Produto produto) throws IOException {
		produtos.add(produto);
		ordenaPorDescricao(produtos);
		escreverLinhaDoArquivo(fileName, produtos);
	}

	public List<Produto> findAll() {
		return Collections.unmodifiableList(produtos);
	}

	@Override
	public void lerLinhaDoArquivo(String linha) {
		produtos.add(ProdutoConverter.converterLinhaDoArquivoParaProduto(linha));
	}

	public void escreverLinhaDoArquivo(String fileName, List<Produto> lstProduto) throws IOException {
		boolean existeArquivo = new File(fileName).exists();
		FileWriter fileWriter = new FileWriter(fileName);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		if (existeArquivo) {
			for (Produto prod : lstProduto) {
				printWriter.println(ProdutoConverter.converterProdutoParaLinhaDoArquivo(prod));
			}
		} else {
			for (Produto prod : lstProduto) {
				printWriter.print(ProdutoConverter.converterProdutoParaLinhaDoArquivo(prod));
			}
		}
		printWriter.close();
		fileWriter.close();
	}

	private static void ordenaPorDescricao(List<Produto> lista) {
		Collections.sort(lista, new Comparator<Produto>() {
			@Override
			public int compare(Produto p1, Produto p2) {
				return p1.getDescricao().compareTo(p2.getDescricao());
			}
		});
	}
}
