
public class TestaICCC {
	public static void main(String[] args) {
		Imposto iccc = new ICCC();
		
		CalculardorDeImposto calculadora = new CalculardorDeImposto();
		
		Orcamento orcamento = new Orcamento(50.0);
		calculadora.realizaCalculo(orcamento, iccc);
		
		orcamento = new Orcamento(1000.0);
		calculadora.realizaCalculo(orcamento, iccc);
		
		orcamento = new Orcamento(3000.0);
		calculadora.realizaCalculo(orcamento, iccc);
		
		orcamento = new Orcamento(5000.0);
		calculadora.realizaCalculo(orcamento, iccc);
	}
}
