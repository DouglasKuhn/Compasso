package br.com.compasso.labs.sprint04.service;

import java.io.IOException;

import br.com.compasso.labs.sprint04.dao.PessoaDAO;
import br.com.compasso.labs.sprint04.model.Pessoa;

public class CadastraPessoa {
	
	private PessoaDAO pessoaDAO;
	
	public CadastraPessoa() throws IOException {
		pessoaDAO = PessoaDAO.getInstance();
	}

	public boolean cadastrarPessoa(Pessoa pessoa) throws IOException {
		return pessoaDAO.add(pessoa);
	}
	
}
