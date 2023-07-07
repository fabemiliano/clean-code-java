package ProjetoFinal.src.project.cleancode.infnet.enums;

public enum StatusAssinaturaEnum {

    ATIVA ("Assinatura Ativa"),
    PENDENTE("Assinatura Em Atraso");

    private String descricao;


    private StatusAssinaturaEnum(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
