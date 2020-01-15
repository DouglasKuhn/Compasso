package aula_1;

public class CalculadoraDeSalario {
	
	public double calcula(Funcionario funcionario) {
        if(DESENVOLVEDOR.equals(funcionario.getCargo())) {
            return new DezOuVintePorcento.calcula(funcionario);
        }

        if(DBA.equals(funcionario.getCargo()) || TESTER.equals(funcionario.getCargo())) {
            return new QuinzeOuVinteCincoPorcento.calcula(funcionario);
        }

        throw new RuntimeException("funcionario invalido");
    }
        
}
