package service;

import java.io.IOException;

import dao.ClienteDAO;
import model.Cliente;

public class CadastraCliente {

private ClienteDAO clienteDAO;

	public CadastraCliente() throws IOException {
		clienteDAO = ClienteDAO.getInstance();
	}

	public boolean cadastrarCliente(Cliente cliente) throws IOException {
		return clienteDAO.add(cliente);
	}
}
