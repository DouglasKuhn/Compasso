package service;

import java.io.IOException;

import dao.ProdutoDAO;
import model.Produto;

public class CadastraProduto {
	
	 private ProdutoDAO produtoDAO;

	public CadastraProduto() throws IOException {
			produtoDAO = ProdutoDAO.getInstance();
	}

	public void cadastrarProduto(Produto produto) throws IOException {
			produtoDAO.add(produto);
	}
}
