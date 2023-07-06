package AtividadeUm.src.project.cleancode.infnet.vo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PagamentoVO {

    private List<ProdutoVO> produtos;

    private LocalDateTime dataCompra;

    private ClienteVO cliente;

    public PagamentoVO(List<ProdutoVO> produtos, LocalDateTime dataCompra, ClienteVO cliente) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PagamentoVO)) return false;
        PagamentoVO pagamento = (PagamentoVO) o;
        return Objects.equals(getProdutos(), pagamento.getProdutos()) && Objects.equals(getDataCompra(), pagamento.getDataCompra()) && Objects.equals(getCliente(), pagamento.getCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProdutos(), getDataCompra(), getCliente());
    }
}
