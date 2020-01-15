package br.com.compasso.labs.sprint04.service;

import java.io.IOException;
import java.util.List;

import br.com.compasso.labs.sprint04.dao.PessoaDAO;
import br.com.compasso.labs.sprint04.model.Pessoa;

public class ListaPessoa {

	private PessoaDAO pessoaDAO;
	
	public ListaPessoa() throws IOException {
		pessoaDAO = PessoaDAO.getInstance();
	}
	
	public List<Pessoa> buscarTodos() {
		return pessoaDAO.findAll();
	}
	
}
