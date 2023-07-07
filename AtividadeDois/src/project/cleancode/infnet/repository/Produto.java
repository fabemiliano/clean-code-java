package AtividadeDois.src.project.cleancode.infnet.repository;

import AtividadeDois.src.project.cleancode.infnet.vo.ProdutoVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    public ArrayList<ProdutoVO> getProduto(){
        ProdutoVO produtoUm = new ProdutoVO("Livro", new BigDecimal("75.00"));
        ProdutoVO produtoDois = new ProdutoVO("Filme", new BigDecimal("50.00"));

        List<ProdutoVO> dividaUm = new ArrayList<>();
        dividaUm.add(produtoUm);
        dividaUm.add(produtoDois);

        return (ArrayList<ProdutoVO>) dividaUm;
    }
}
