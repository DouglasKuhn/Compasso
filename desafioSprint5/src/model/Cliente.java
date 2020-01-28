package model;

public class Cliente {
	private Integer codigo;
	private String nome;
	private String endereco;

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

	@Override
	public String toString() {
		return "Código: " + codigo + "" + "\n" + "Nome: " + nome + "" + "\n" + "Endereço: " + endereco + "" + "\n";
	}

}
