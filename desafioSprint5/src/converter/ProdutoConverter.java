package converter;

import model.Produto;

public class ProdutoConverter {

	private static final String DELIMITADOR = ";";

	public static Produto converterLinhaDoArquivoParaProduto(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}
		
		String[] props = linha.split(DELIMITADOR);
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(props[0]));
		produto.setDescricao(props[1]);
		produto.setValor(Double.parseDouble(props[2]));
		produto.setQuantidade(Integer.parseInt(props[3]));
		return produto;
	}

	public static String converterProdutoParaLinhaDoArquivo(Produto produto) {
		StringBuffer lineStrProduto = new StringBuffer();
		lineStrProduto.append(produto.getCodigo());
		lineStrProduto.append(DELIMITADOR);
		lineStrProduto.append(produto.getDescricao());
		lineStrProduto.append(DELIMITADOR);
		lineStrProduto.append(produto.getValor());
		lineStrProduto.append(DELIMITADOR);
		lineStrProduto.append(produto.getQuantidade());

		return lineStrProduto.toString();
	}

}

