package solid_aula_2;

public class EnviadorDeEmail implements AcaoAposGerarNota {

    public void executa(NotaFiscal nf) {
        System.out.println("envia email da nf " + nf.getId());
    }
}