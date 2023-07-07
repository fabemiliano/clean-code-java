package ProjetoFinal.src.project.cleancode.infnet;

import ProjetoFinal.src.project.cleancode.infnet.cache.CacheFactory;

public class main {
    public static void main(String[] args) {
        CacheFactory cacheFactory = new CacheFactory();

        cacheFactory.getInicioProjetoFinal();
        cacheFactory.getTempoAssinaturaExecutada();
        cacheFactory.getValorTotalMensalidade();
        cacheFactory.getValorTotalDebitado();
        cacheFactory.getStatusAssinaturaPagamentoProduto();
    }
}
