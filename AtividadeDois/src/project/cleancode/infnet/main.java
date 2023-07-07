package AtividadeDois.src.project.cleancode.infnet;

import AtividadeDois.src.project.cleancode.infnet.repository.Assinatura;
import AtividadeDois.src.project.cleancode.infnet.repository.Pagamento;
import AtividadeDois.src.project.cleancode.infnet.vo.AssinaturaVO;
import AtividadeDois.src.project.cleancode.infnet.vo.PagamentoVO;
import AtividadeDois.src.project.cleancode.infnet.vo.ProdutoVO;

import java.math.BigDecimal;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        System.out.println("\nSeguindo os padrões de Cleancode e solid. Refatore o seu código para deixá-lo orientado a objetos.\n");
        System.out.println("====================================CARREGANDO INFORMAÇÕES DO 'REPOSITORIO' - BANCO DE DADOS=======================\n");
        ArrayList<PagamentoVO> pagamento = new Pagamento().getPagamento();

        ArrayList<ArrayList<AssinaturaVO>> assinaturaComplementoExemplo = new Assinatura().getAssinaturaParcela();
        System.out.println("=====================================SIMULAÇÃO=============================================\n");

        System.out.println("Crie 3 tipos de assinatura, anual, semestral e trimestral. Crie um método para calcular uma taxa para cada assinatura. Obs. Imagine que esse método rodará todo último dia do mes. Anual -> Isento da taxa. Semestral -> 3% do valor total da assinatura até o presente momento. Trimestral -> 5% do valor total da assinatura até o presente momento.\n");
        System.out.println("-> Encontrado no pacote 'util' -> 'AssinaturaConstants.java'\n");

        System.out.println("Crie um atributo para controlar assinaturas com atraso de pagamento. Crie um mecanismo para validar clientes que tentarem fazer compras com assinatura em atraso e não deixá-los comprar.\n");

        System.out.println("Rode o seu código no SonarQube. Se possuir problemas corrija-os. Se não, parabéns.\n");

        System.out.println("Coloque os prints do SonarQube dentro de uma pasta chamada sonar na raiz do seu projeto.\n");

        System.out.println("Versione seu novo código em outro repositório ou uma branch diferente da tarefa anterior.\n");

        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Numero de Renovação de Assinaturas Ocorridas durante o tempo de uso: " + testeMecanismos.getTempoAssinatura() + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });

        System.out.println("===========================================================================================\n");
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total das parcelas que devem ser pagas: " + testeMecanismos.getValorTotalMensalidade() + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });

        System.out.println("===========================================================================================\n");
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total que deveria ser debitado até o momento: " + testeMecanismos.getValorTotalDebitado(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });

        System.out.println("===========================================================================================\n");
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura do Cliente: " + testeMecanismos.getStatusAssinatura(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });


        System.out.println("===========================================================================================\n");
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura: " + testeMecanismos.getStatusAssinatura(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
            System.out.println("Comprando produto para: " + testeMecanismos.getCliente().getNome() + "\n");
            testeMecanismos.validarExecucaoPagamentoProduto(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos)));
            testeMecanismos.getProdutos().add(new ProdutoVO("Filme", new BigDecimal("50.00")));
        });
        System.out.println("===========================================================================================\n");
    }
}
