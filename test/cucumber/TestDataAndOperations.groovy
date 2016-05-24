package steps

import gerenciadeequipamentos.EquipamentoController

class TestDataAndOperations {
    static public void createEquipamento(String nome, EquipamentoController controlador){
        controlador.params << [nome:nome, status:null, localizacao:null, lista:false]
        controlador.save()
        controlador.response.reset()
    }



}