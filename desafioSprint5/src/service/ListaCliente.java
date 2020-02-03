package service;

import java.io.IOException;
import java.util.List;

import dao.ClienteDAO;
import model.Cliente;

public class ListaCliente {

private ClienteDAO clienteDAO;
	
	public ListaCliente() throws IOException {
		clienteDAO = ClienteDAO.getInstance();
	}
	
	public List<Cliente> buscarTodos() {
		return clienteDAO.findAll();
	}
}
