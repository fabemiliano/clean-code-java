package AtividadeDois.src.project.cleancode.infnet.vo;

import java.time.LocalDateTime;
import java.util.List;

public class PagamentoVO extends AssinaturaVO {

    private List<ProdutoVO> produtos;

    private LocalDateTime dataCompra;

    private ClienteVO cliente;

    public PagamentoVO(List<ProdutoVO> produtos, LocalDateTime dataCompra, ClienteVO cliente, AssinaturaVO assinatura) {
        super(assinatura.getBegin(), assinatura.getTipoAssinatura(), assinatura.getQuitado());
        this.produtos = produtos;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
    }

    public PagamentoVO(PagamentoVO pagamento) {
        this.produtos = pagamento.getProdutos();
        this.dataCompra = pagamento.getDataCompra();
        this.cliente = pagamento.getCliente();
    }

    public List<ProdutoVO> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<ProdutoVO> produtos) {
        this.produtos = produtos;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }


}
