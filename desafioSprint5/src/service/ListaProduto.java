package service;

import java.io.IOException;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ListaProduto {

private ProdutoDAO produtoDAO;
	
	public ListaProduto() throws IOException {
		produtoDAO = ProdutoDAO.getInstance();
	}
	
	public List<Produto> buscarTodos() {
		return produtoDAO.findAll();
	}
}
