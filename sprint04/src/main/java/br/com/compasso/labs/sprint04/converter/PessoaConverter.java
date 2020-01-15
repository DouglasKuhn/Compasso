package br.com.compasso.labs.sprint04.converter;

import br.com.compasso.labs.sprint04.model.Pessoa;

public class PessoaConverter {
	
	private static final String DELIMITADOR = ";";
	
	public static Pessoa converterLinhaDoArquivoParaPessoa(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}
		
		String[] props = linha.split(DELIMITADOR);
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo(Integer.parseInt(props[0]));
		pessoa.setNome(props[1]);
		pessoa.setEndereco(props[2]);
		pessoa.setIdade(Integer.parseInt(props[3]));
		return pessoa;
		
	}
	
	public static String converterPessoaParaLinhaDoArquivo(Pessoa pessoa) {
		StringBuffer lineStrPessoa = new StringBuffer();
		lineStrPessoa.append(pessoa.getCodigo());
		lineStrPessoa.append(DELIMITADOR);
		lineStrPessoa.append(pessoa.getNome());
		lineStrPessoa.append(DELIMITADOR);
		lineStrPessoa.append(pessoa.getEndereco());
		lineStrPessoa.append(DELIMITADOR);
		lineStrPessoa.append(pessoa.getIdade());

		return lineStrPessoa.toString();
	}
	
}
