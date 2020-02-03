package service;

import java.io.IOException;

import dao.DAO;
import model.Produto;

public class Cadastra {

	private DAO dao;

	public Cadastra() throws IOException {
		dao = DAO.getInstance();
	}

	public void cadastrar(Produto obj) throws IOException {
		System.out.println("sdfsg");
		dao.add(obj);
	}
}
