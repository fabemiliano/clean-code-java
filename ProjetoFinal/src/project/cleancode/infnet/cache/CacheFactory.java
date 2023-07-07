package ProjetoFinal.src.project.cleancode.infnet.cache;

import ProjetoFinal.src.project.cleancode.infnet.repository.Assinatura;
import ProjetoFinal.src.project.cleancode.infnet.repository.Pagamento;
import ProjetoFinal.src.project.cleancode.infnet.vo.AssinaturaVO;
import ProjetoFinal.src.project.cleancode.infnet.vo.PagamentoVO;
import ProjetoFinal.src.project.cleancode.infnet.vo.ProdutoVO;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CacheFactory {

    private ArrayList<PagamentoVO> pagamento = new Pagamento().getPagamento();

    private ArrayList<ArrayList<AssinaturaVO>> assinaturaComplemento = new Assinatura().getAssinaturaParcela();

    private String linha = "===========================================================================================\n";


    public void getInicioProjetoFinal(){
        System.out.println("\nProjeto Final Complemento da Atividade Dois: - Padrão criacional Factory Method Escolhido\n");
        System.out.println("====================================CARREGANDO INFORMAÇÕES DO 'REPOSITORIO' - BANCO DE DADOS=======================\n");
        System.out.println("=====================================SIMULAÇÃO=============================================\n");

    }
    public void getTempoAssinaturaExecutada() {
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Numero de Renovação de Assinaturas Ocorridas durante o tempo de uso: " + testeMecanismos.getTempoAssinatura() + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    public void getValorTotalDebitado() {
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total para ser debitado até o momento: " + testeMecanismos.getValorTotalDebitado(assinaturaComplemento.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    public void getValorTotalMensalidade() {
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total que deveria ser debitado até o momento: " + testeMecanismos.getValorTotalDebitado(assinaturaComplemento.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    public void getStatusAssinatura() {
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura do Cliente: " + testeMecanismos.getStatusAssinatura(assinaturaComplemento.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    public void getStatusAssinaturaPagamentoProduto() {
        for (PagamentoVO testeMecanismos : pagamento) {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura: " + testeMecanismos.getStatusAssinatura(assinaturaComplemento.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
            System.out.println("Comprando produto para: " + testeMecanismos.getCliente().getNome() + "\n");
            testeMecanismos.validarExecucaoPagamentoProduto(assinaturaComplemento.get(pagamento.indexOf(testeMecanismos)));
            testeMecanismos.getProdutos().add(new ProdutoVO("Filme", new BigDecimal("50.00")));
        }
        System.out.println(linha);
    }
}

