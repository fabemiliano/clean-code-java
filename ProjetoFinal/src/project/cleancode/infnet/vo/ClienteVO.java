package ProjetoFinal.src.project.cleancode.infnet.vo;

public class ClienteVO {

    private String Nome;

    private String id;

    public ClienteVO(String nome, String id) {
        this.Nome = nome;
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
