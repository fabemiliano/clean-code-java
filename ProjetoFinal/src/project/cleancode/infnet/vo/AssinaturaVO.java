package ProjetoFinal.src.project.cleancode.infnet.vo;

import ProjetoFinal.src.project.cleancode.infnet.enums.AssinaturaEnum;
import ProjetoFinal.src.project.cleancode.infnet.enums.StatusAssinaturaEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class AssinaturaVO {

    private LocalDateTime begin;

    private Optional<LocalDateTime>  end;

    private AssinaturaEnum tipoAssinatura;

    private Boolean quitado;

    private Long parcela;

    public AssinaturaVO(){
    }

    public AssinaturaVO(LocalDateTime begin, AssinaturaEnum tipoAssinatura, Boolean quitado) {
        this.begin = begin;
        this.end =  Optional.empty();
        this.tipoAssinatura = tipoAssinatura;
        this.quitado = quitado;
        this.parcela = getTempoAssinatura();
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public Optional<LocalDateTime>  getEnd() {
        return end;
    }

    public AssinaturaEnum getTipoAssinatura() {
        return tipoAssinatura;
    }

    public Boolean getQuitado() {
        return quitado;
    }

    public Long getParcela() {
        return parcela;
    }

    public Long getTempoAssinatura(){
        return -ChronoUnit.MONTHS.between(LocalDateTime.now(), begin) / tipoAssinatura.getValorTempo();
    }

    public BigDecimal getValorTotalMensalidade(){
        return tipoAssinatura.getValorPlano()
                    .multiply(BigDecimal.valueOf(getTempoAssinatura())).add(
                        tipoAssinatura.getTaxa()
                            .multiply(tipoAssinatura.getValorPlano())
                            .multiply(BigDecimal.valueOf(getTempoAssinatura())));
    }

    public BigDecimal getValorTotalDebitado(List<AssinaturaVO> pagamentoAssinatura){
        return new BigDecimal(pagamentoAssinatura.stream().filter(assinaturaPaga -> assinaturaPaga.getQuitado()).map(assinatura -> assinatura.getTipoAssinatura().getValorPlano()).count()).add(
                        BigDecimal.valueOf(pagamentoAssinatura.stream().filter(assinaturaPaga -> assinaturaPaga.getQuitado()).count())
                            .multiply(tipoAssinatura.getTaxa()))
                            .multiply(tipoAssinatura.getValorPlano());
    }

    public StatusAssinaturaEnum getStatusAssinatura(List<AssinaturaVO> pagamentoAssinatura){
        return getValorTotalDebitado(pagamentoAssinatura).compareTo(getValorTotalMensalidade()) == 0 ? StatusAssinaturaEnum.ATIVA : StatusAssinaturaEnum.PENDENTE;
    }

    public void validarExecucaoPagamentoProduto(List<AssinaturaVO> pagamentoAssinatura){
        if (getStatusAssinatura(pagamentoAssinatura) == StatusAssinaturaEnum.PENDENTE){
            throw new IllegalArgumentException("Náo é Possível efetuar à Compra de Produtos devido a assinatura está Pendente");
        }
    }

}
