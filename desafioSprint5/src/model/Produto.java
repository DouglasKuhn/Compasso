package model;

public class Produto {
	private Integer codigo;
	private String descricao;
	private Double valor;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "" + "\n" + "Descricao: " + descricao + "" + "\n" + "Valor: R$" + valor + "\n";
	}
}
