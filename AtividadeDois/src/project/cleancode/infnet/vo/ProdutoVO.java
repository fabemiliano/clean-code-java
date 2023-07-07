package AtividadeDois.src.project.cleancode.infnet.vo;

import java.math.BigDecimal;
import java.nio.file.Path;

public class ProdutoVO {

    private String nome;

    private BigDecimal Preco;

    private Path file;

    public ProdutoVO(){
    }

    public ProdutoVO(String nome, BigDecimal preco) {
        this.nome = nome;
        this.Preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return Preco;
    }

    public void setPreco(BigDecimal preco) {
        Preco = preco;
    }

    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }

}
