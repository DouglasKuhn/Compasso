package model;

public interface Converter {
	
	static final String DELIMITADOR = ";";

	public Object converterLinhaDoArquivo(String linha);
	
	public String converterParaLinhaDoArquivo();
	
}
