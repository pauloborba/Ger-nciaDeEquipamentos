package steps

import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController

/**
 * Created by acab2 on 24/05/2016.
 */
class TestDataAndOperations {

    static public void createEquipamento(String nome, String status, String localizacao, EquipamentoController controlador){
        controlador.params << [nome:nome, status:status, localizacao:localizacao, lista:false]
        controlador.save()
        controlador.response.reset()

    }

    static public Equipamento buscarEquipamento(String nome, String localizacao, String status, boolean lista, EquipamentoController controlador){
        Equipamento equipamento = controlador.busca(nome, localizacao, status, lista)
        return equipamento
    }

    static public void modificarLocalizacao(Equipamento equipamento, String novaLocalizacao, EquipamentoController controlador){
        controlador.setLocal(equipamento, novaLocalizacao)
    }

}
