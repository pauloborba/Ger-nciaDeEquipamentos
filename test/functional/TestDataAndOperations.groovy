package steps

import gerenciadeequipamentos.ArmazemController
import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController
import gerenciadeequipamentos.Armazem

class TestDataAndOperations {


    static public def  createArmazem(String nome, int lotacao, int areaUtil, ArmazemController controlador){
        controlador.params << [nome:nome, areaUtil:areaUtil, lotacao:lotacao, cheio:false]
        controlador.save()
        controlador.response.reset()
    }

    static public def  createArmazemCheio(String nome, int lotacao, int areaUtil, ArmazemController controlador){
        controlador.params << [nome:nome, areaUtil:areaUtil, lotacao:lotacao, cheio:true]
        controlador.save()
        controlador.response.reset()
    }


    static public def createEquipamento(String nome, String status, String localizacao,Date data , EquipamentoController controlador){
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
    static public void checkIfEquipamentoDoesExists(String nome) {

        assert Equipamento.findByNome(nome)
    }

    static def EquipamentoBusca(String nome) {
        def controlador = new EquipamentoController()
        def lista = []
        controlador.params.input1 = nome //preenche a entra com  onome
        controlador.buscaEquipamento() //simula a busca
        lista = controlador.getLista() //pega dados da lista
        return lista
    }
}
