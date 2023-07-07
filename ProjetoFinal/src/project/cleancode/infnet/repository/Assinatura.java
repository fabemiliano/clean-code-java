package ProjetoFinal.src.project.cleancode.infnet.repository;

import ProjetoFinal.src.project.cleancode.infnet.enums.AssinaturaEnum;
import ProjetoFinal.src.project.cleancode.infnet.vo.AssinaturaVO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assinatura {

    public ArrayList<AssinaturaVO> getAssinatura(){
        AssinaturaVO assinaturaFabiano = new AssinaturaVO(LocalDateTime.now().minusMonths(8), AssinaturaEnum.TRIMESTRAL, true);
        AssinaturaVO assinaturaEmiliano = new AssinaturaVO(LocalDateTime.now().minusMonths(8), AssinaturaEnum.SEMESTRAL, true);
        AssinaturaVO assinaturaAntônio = new AssinaturaVO(LocalDateTime.now().minusMonths(12), AssinaturaEnum.ANUAL, false);

        ArrayList<AssinaturaVO> assinatura = new ArrayList<>();
        assinatura.add(assinaturaFabiano);
        assinatura.add(assinaturaEmiliano);
        assinatura.add(assinaturaAntônio);

        return assinatura;
    }

    public ArrayList<ArrayList<AssinaturaVO>> getAssinaturaParcela(){

        ArrayList<AssinaturaVO> assinatura = getAssinatura();

        ArrayList<ArrayList<AssinaturaVO>> parcelaCliente = new ArrayList<>();

        assinatura.forEach(numeroParcela ->{
            ArrayList<AssinaturaVO> assinaturaTmp = new ArrayList<>();
            long parcela = numeroParcela.getParcela();

            for (long i = 0; i < parcela; i++){
                assinaturaTmp.add(numeroParcela);
            }

            parcelaCliente.add(assinaturaTmp);
        });

        return parcelaCliente;
    }

}
