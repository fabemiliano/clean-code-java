package AtividadeDois.src.project.cleancode.infnet.repository;

import AtividadeDois.src.project.cleancode.infnet.vo.ClienteVO;

import java.util.ArrayList;

public class Cliente {
    public ArrayList<ClienteVO> getCliente(){
        ArrayList<ClienteVO> cliente = new ArrayList<ClienteVO>();
        cliente.add(new ClienteVO("Fabiano", "1"));
        cliente.add(new ClienteVO("Emiliano", "2"));
        cliente.add(new ClienteVO("Antônio", "3"));

        return cliente;
    }
}
