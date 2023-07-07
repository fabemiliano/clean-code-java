package AtividadeDois.src.project.cleancode.infnet.repository;

import AtividadeDois.src.project.cleancode.infnet.vo.AssinaturaVO;
import AtividadeDois.src.project.cleancode.infnet.vo.ClienteVO;
import AtividadeDois.src.project.cleancode.infnet.vo.PagamentoVO;
import AtividadeDois.src.project.cleancode.infnet.vo.ProdutoVO;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Pagamento {

    public ArrayList<PagamentoVO> getPagamento(){

        ArrayList<ClienteVO> cliente = new Cliente().getCliente();
        ArrayList<ProdutoVO> produto = new Produto().getProduto();
        ArrayList<AssinaturaVO> assinatura = new Assinatura().getAssinatura();

        ArrayList<PagamentoVO> pagamento= new ArrayList<>();
        pagamento.add(new PagamentoVO(produto, LocalDateTime.now(), cliente.get(0), assinatura.get(0)));
        pagamento.add(new PagamentoVO(produto, LocalDateTime.now().minusDays(1), cliente.get(1), assinatura.get(1)));
        pagamento.add(new PagamentoVO(produto, LocalDateTime.now().minusMonths(1), cliente.get(2), assinatura.get(2)));

        return pagamento;
    }

}
