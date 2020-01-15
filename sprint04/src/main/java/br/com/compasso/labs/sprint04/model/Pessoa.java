package br.com.compasso.labs.sprint04.model;

public class Pessoa {

	private Integer codigo;
	private String nome;
	private String endereco;
	private Integer idade;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "" + "\n" + "Nome: " + nome + "" + "\n" + "Endereço: " + endereco + "" + "\n"
				+ "Idade: " + idade + "\n";
	}
}