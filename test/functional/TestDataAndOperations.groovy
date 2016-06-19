package steps

import gerenciadeequipamentos.ArmazemController
import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController


class TestDataAndOperations {


    static public void createArmazem(String nome, int lotacao, int areaUtil, ArmazemController controlador){

        controlador.params << [nome:nome, areaUtil:areaUtil, lotacao:lotacao, cheio:false]
        controlador.save()
        controlador.response.reset()

    }
    static public void createEquipamento(String nome, String status, String localizacao,Date data , EquipamentoController controlador){
        controlador.params << [nome:nome, status:status, localizacao:localizacao, data:data]
        controlador.save()
        controlador.response.reset()

    }

    static public Equipamento buscarEquipamento(String nome, String localizacao, String status, data, EquipamentoController controlador){
        Equipamento equipamento = controlador.busca(nome, localizacao, status, data)
        return equipamento
    }

    static public void modificarLocalizacao(Equipamento equipamento, String novaLocalizacao, EquipamentoController controlador){
        controlador.setLocal(equipamento, novaLocalizacao)
    }
    static public void updateStatus(Equipamento equipamento, String novoStatus, EquipamentoController controlador){
        controlador.updateStatus(equipamento, novoStatus)
    }
}
