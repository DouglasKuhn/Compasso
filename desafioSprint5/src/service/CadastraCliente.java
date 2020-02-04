package service;

import java.io.IOException;

import dao.ClienteDAO;
import model.Cliente;

public class CadastraCliente {

private ClienteDAO clienteDAO;

	public CadastraCliente() throws IOException {
		clienteDAO = ClienteDAO.getInstance();
	}

	public void cadastrarCliente(Cliente cliente) throws IOException {
		clienteDAO.add(cliente);
	}
}
