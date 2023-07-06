package AtividadeUm.src.project.cleancode.infnet;

import AtividadeUm.src.project.cleancode.infnet.vo.PagamentoVO;
import AtividadeUm.src.project.cleancode.infnet.vo.AssinaturaVO;
import AtividadeUm.src.project.cleancode.infnet.vo.ClienteVO;
import AtividadeUm.src.project.cleancode.infnet.vo.ProdutoVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;

public class Start {
    public static void main(String[] args) {
        System.out.println("\n=====================================QUESTÃO 1=============================================");
        System.out.println("Crie uma Classe com um método main para criar alguns produtos, clientes e pagamentos. Crie Pagamentos com: a data de hoje, ontem e um do mês passado.\n");

        ClienteVO fabiano = new ClienteVO("Fabiano");
        ClienteVO emiliano = new ClienteVO("Emiliano");


        ProdutoVO produtoUm = new ProdutoVO("Livro", new BigDecimal("75.00"));
        ProdutoVO produtoDois = new ProdutoVO("Filme", new BigDecimal("50.00"));

        List<ProdutoVO> dividaUm = new ArrayList<>();
        dividaUm.add(produtoUm);
        dividaUm.add(produtoDois);

        List<ProdutoVO> dividaDois = new ArrayList<>();
        dividaDois.add(produtoDois);

        ArrayList<PagamentoVO> pagamentoFabiano = new ArrayList<>();
        pagamentoFabiano.add(new PagamentoVO(dividaUm, LocalDateTime.now(), fabiano));
        pagamentoFabiano.add(new PagamentoVO(dividaDois, LocalDateTime.now().minusDays(1), fabiano));
        pagamentoFabiano.add(new PagamentoVO(dividaDois, LocalDateTime.now().minusMonths(1), fabiano));

        ArrayList<PagamentoVO> pagamentoEmiliano = new ArrayList<>();
        pagamentoEmiliano.add(new PagamentoVO(dividaUm, LocalDateTime.now(), emiliano));
        pagamentoEmiliano.add(new PagamentoVO(dividaDois, LocalDateTime.now().minusDays(1), emiliano));


        List<ArrayList<PagamentoVO>> Cliente = new ArrayList<>();
        Cliente.add(pagamentoFabiano);
        Cliente.add(pagamentoEmiliano);

        System.out.println("\n=====================================QUESTÃO 2=============================================");
        System.out.println("Ordene e imprima os pagamentos pela data de compra.\n");

        Consumer<ProdutoVO> imprimirProdutoCliente = produtoCliente -> System.out.println("Nome: " + produtoCliente.getNome() + " - Valor: R$ " + produtoCliente.getPreco());

        Consumer<PagamentoVO> imprimirPagamentoCliente =
                pagamentoClienteData -> {
                    System.out.println("Data de Pagamento: " + pagamentoClienteData.getDataCompra() + "\nProdutos: ");
                    pagamentoClienteData.getProdutos().forEach(imprimirProdutoCliente);
                    System.out.println("\n");
                };

        Cliente.forEach(ordenarPagamentoData ->{
            ordenarPagamentoData.sort(comparing(PagamentoVO::getDataCompra));
            ordenarPagamentoData.forEach(imprimirPagamentoCliente);
        });

        System.out.println("\n=====================================QUESTÃO 3=============================================");
        System.out.println("Calcule e Imprima a soma dos valores de um pagamento com optional e recebendo um Double diretamente.\n");

        Optional<Double> pagamentoUnico = Optional.of(dividaUm.stream().mapToDouble(p -> p.getPreco().doubleValue()).sum());
        System.out.println("Pagamento da Dívida Um: " + pagamentoUnico.get());

        System.out.println("\n=====================================QUESTÃO 4=============================================");
        System.out.println("Calcule o Valor de todos os pagamentos da Lista de pagamentos.\n");

        Consumer<PagamentoVO> imprimirPagamentoTotal =
                pagamentoTotal -> {
                    System.out.println("Data de Pagamento: " + pagamentoTotal.getDataCompra() + "\nProdutos: " + pagamentoTotal.getProdutos().stream().mapToDouble(value -> value.getPreco().doubleValue()).sum());
                };

        Cliente.forEach(pagamentoTotal -> {
            pagamentoTotal.forEach(imprimirPagamentoTotal);
        });


        System.out.println("\n=====================================QUESTÃO 5=============================================");
        System.out.println("Imprima a quantidade de cada Produto vendido\n");
        Consumer<PagamentoVO> imprimirQuantidadeProduto =
                pagamentoTotal -> {
                    System.out.println("Data de Pagamento: " + pagamentoTotal.getDataCompra() + "\nProdutos: " + pagamentoTotal.getProdutos().stream().map(value -> value.getNome()).count());
                };

        Cliente.forEach(pagamentoTotal -> {
            pagamentoTotal.forEach(imprimirQuantidadeProduto);
        });

        System.out.println("\n=====================================QUESTÃO 6=============================================");
        System.out.println("Crie um Mapa de <Cliente, List , onde Cliente pode ser o nome do cliente\n");

        Cliente.forEach(cliente ->{
            System.out.println("Cliente: " + cliente.get(0).getCliente().getNome());
            cliente.sort(comparing(PagamentoVO::getDataCompra));
            cliente.forEach(imprimirPagamentoCliente);
        });

        System.out.println("\n=====================================QUESTÃO 7=============================================");
        System.out.println("Qual cliente gastou mais?\n");

        Cliente.forEach(cliente ->{
            System.out.println("Cliente: " + cliente.get(0).getCliente().getNome());
            AtomicReference<Double> totalPagamento = new AtomicReference<>(0.00);
            cliente.forEach(pagamento -> {
                totalPagamento.set(totalPagamento.get() + pagamento.getProdutos().stream().mapToDouble(preco -> preco.getPreco().doubleValue()).sum());
            });
            System.out.println("Valor Total Pago: " + totalPagamento);
        });

        System.out.println("\n=====================================QUESTÃO 8=============================================");
        System.out.println("Quanto foi faturado em um determinado mês?\n");

        Cliente.forEach(cliente ->{
            System.out.println("Cliente: " + cliente.get(0).getCliente().getNome());
            AtomicReference<Double> totalPagamento = new AtomicReference<>(0.00);
            cliente.forEach(pagamento -> {
                Optional<ProdutoVO> gastoMes = pagamento.getProdutos().stream().filter(mes -> pagamento.getDataCompra().getMonth() == Month.of(LocalDateTime.now().getMonth().ordinal()+1)).findAny();
                gastoMes.ifPresent((produto) -> {
                    totalPagamento.set(totalPagamento.get() + produto.getPreco().doubleValue());
                });
            });
            System.out.println("Valor Total Pago no Mês de Maio: " + totalPagamento);
        });

        System.out.println("\n=====================================QUESTÃO 9=============================================");
        System.out.println("Crie 3 assinaturas com assinaturas de 99.98 reais, sendo 2 deles com assinaturas encerradas.\n");
        ArrayList<AssinaturaVO> assinatura = new ArrayList<>();
        assinatura.add(new AssinaturaVO(new BigDecimal("99.98"), LocalDateTime.of(2023, Month.JANUARY, 1, 7, 0)));
        assinatura.add(new AssinaturaVO(new BigDecimal("99.98"), LocalDateTime.of(2023, Month.FEBRUARY, 1, 8, 0), LocalDateTime.of(2023, Month.JUNE, 1, 11, 0)));
        assinatura.add(new AssinaturaVO(new BigDecimal("99.98"), LocalDateTime.of(2023, Month.MARCH, 1, 9, 0), LocalDateTime.of(2023, Month.JULY, 1, 12, 0)));

        System.out.println("\n=====================================QUESTÃO 10============================================");
        System.out.println("Imprima o tempo em meses de alguma assinatura ainda ativa.\n");

        assinatura.forEach(assinaturaAtiva -> {
            if (assinaturaAtiva.getBegin() != null && !assinaturaAtiva.getEnd().isPresent()){
                long mesesAtivo = ChronoUnit.MONTHS.between(LocalDate.now(), assinaturaAtiva.getBegin());
                System.out.println("Assinatura " + (assinatura.indexOf(assinaturaAtiva) + 1) + " Ativa: " + (-mesesAtivo) + " meses");
            }
        });

        System.out.println("\n=====================================QUESTÃO 11============================================");
        System.out.println("Imprima o tempo de meses entre o start e end de todas assinaturas. Não utilize IFs para assinaturas sem end Time\n");

        assinatura.forEach(assinaturaAtiva -> {
            long mesesAtivo = ChronoUnit.MONTHS.between(assinaturaAtiva.getEnd().orElse(LocalDateTime.now()), assinaturaAtiva.getBegin());
            System.out.println("Meses da Assinatura " + (assinatura.indexOf(assinaturaAtiva) + 1) + " iniciou até a data de temíno ou Atual: " + (-mesesAtivo));
        });

        System.out.println("\n=====================================QUESTÃO 12============================================");
        System.out.println("Calcule o valor pago em cada assinatura até o momento.\n");

        assinatura.forEach(assinaturaAtiva -> {
            long mesesAtivo = ChronoUnit.MONTHS.between(assinaturaAtiva.getEnd().orElse(LocalDateTime.now()), assinaturaAtiva.getBegin());
            System.out.println("Meses da Assinatura " + (assinatura.indexOf(assinaturaAtiva) + 1) + " Pago: R$ " + (new BigDecimal(-mesesAtivo).multiply(assinaturaAtiva.getMensalidade())));
        });
    }
}
