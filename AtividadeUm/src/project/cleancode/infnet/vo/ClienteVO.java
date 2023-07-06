package AtividadeUm.src.project.cleancode.infnet.vo;

import java.util.Objects;

public class ClienteVO {

    private String Nome;

    public ClienteVO(String nome) {
        this.Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteVO)) return false;
        ClienteVO cliente = (ClienteVO) o;
        return Objects.equals(getNome(), cliente.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        return Nome;
    }
}
