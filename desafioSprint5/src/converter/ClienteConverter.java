package converter;

import model.Cliente;

public class ClienteConverter {

	private static final String DELIMITADOR = ";";

	public static Cliente converterLinhaDoArquivoParaCliente(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}

		String[] props = linha.split(DELIMITADOR);
		Cliente cliente = new Cliente();
		cliente.setCodigo(Integer.parseInt(props[0]));
		cliente.setNome(props[1]);
		cliente.setEndereco(props[2]);
		return cliente;
	}

	public static String converterClienteParaLinhaDoArquivo(Cliente cliente) {
		StringBuffer lineStrCliente = new StringBuffer();
		lineStrCliente.append(cliente.getCodigo());
		lineStrCliente.append(DELIMITADOR);
		lineStrCliente.append(cliente.getNome());
		lineStrCliente.append(DELIMITADOR);
		lineStrCliente.append(cliente.getEndereco());

		return lineStrCliente.toString();
	}

}
