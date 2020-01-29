package service;

import dao.DAO;

public class Cadastra {

	private DAO dao;

	public Cadastra() {
		dao = DAO.getInstance();
	}

	public boolean cadastrarProduto(Object obj) {
		return dao.add(obj);

	}
}
