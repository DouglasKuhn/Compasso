package model;

public class Produto implements Converter {
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
	public Object converterLinhaDoArquivo(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}

		String[] props = linha.split(DELIMITADOR);
		this.setCodigo(Integer.parseInt(props[0]));
		this.setDescricao(props[1]);
		this.setValor(Double.parseDouble(props[2]));
		return this;
	}

	@Override
	public String converterParaLinhaDoArquivo() {
		StringBuffer lineStr = new StringBuffer();
		lineStr.append(this.getCodigo());
		lineStr.append(DELIMITADOR);
		lineStr.append(this.getDescricao());
		lineStr.append(DELIMITADOR);
		lineStr.append(this.getValor());

		return lineStr.toString();
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "" + "\n" + "Descricao: " + descricao + "" + "\n" + "Valor: R$" + valor + "\n";
	}
}
