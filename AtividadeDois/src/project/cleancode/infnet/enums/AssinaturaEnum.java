package AtividadeDois.src.project.cleancode.infnet.enums;

import java.math.BigDecimal;

import static AtividadeDois.src.project.cleancode.infnet.util.constants.AssinaturaConstants.*;

public enum AssinaturaEnum {

    TRIMESTRAL,
    SEMESTRAL,
    ANUAL;

    public BigDecimal getValorPlano(){
        switch (this){
            case TRIMESTRAL:
                return ASSINATURA_TRIMESTRAL;
            case SEMESTRAL:
                return ASSINATURA_SEMESTRAL;
            case ANUAL:
                return ASSINATURA_ANUAL;
            default:
                throw new IllegalArgumentException("Tipo de Valor de Plano de Assinatura não Encontrado");
        }
    }

    public BigDecimal getTaxa() {
        switch (this){
            case TRIMESTRAL:
                return TAXA_TRIMESTRAL;
            case SEMESTRAL:
                return TAXA_SEMESTRAL;
            case ANUAL:
                return TAXA_ANUAL;
            default :
                throw new IllegalArgumentException("Tipo de Taxa de Assinatura não Encontrado");
        }
    }

    public Long getValorTempo(){
        switch (this){
            case TRIMESTRAL:
                return VALOR_TRIMESTRAL;
            case SEMESTRAL:
                return VALOR_SEMESTRAL;
            case ANUAL:
                return VALOR_ANUAL;
            default:
                throw new IllegalArgumentException("Tipo de Valor de Tempo de Assinatura não Encontrado");
        }
    }

}
