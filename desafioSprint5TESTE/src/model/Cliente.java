package model;

public class Cliente implements Converter {
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
	public Object converterLinhaDoArquivo(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}

		String[] props = linha.split(DELIMITADOR);
		this.setCodigo(Integer.parseInt(props[0]));
		this.setNome(props[1]);
		this.setEndereco(props[2]);
		return this;
	}

	@Override
	public String converterParaLinhaDoArquivo() {
		StringBuffer lineStr = new StringBuffer();
		lineStr.append(this.getCodigo());
		lineStr.append(DELIMITADOR);
		lineStr.append(this.getNome());
		lineStr.append(DELIMITADOR);
		lineStr.append(this.getEndereco());

		return lineStr.toString();
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "" + "\n" + "Nome: " + nome + "" + "\n" + "Endereço: " + endereco + "" + "\n";
	}

}
