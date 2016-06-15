package steps

import cucumber.api.PendingException
import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController

/**
 * Created by Walber on 15/06/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def controlador = new EquipamentoController()
Given(~/^o sistema possui o equipamento "([^"]*)" cadastrado$/) { String nome ->
    Equipamento equipamento = TestDataAndOperations.createEquipamento(nome, "status","localização", controlador)
    assert Equipamento.findByNome(nome) != null
}
When(~/^eu tento alterar o status de "([^"]*)" para "([^"]*)"$/) { String nome, status ->
    TestDataAndOperations.updateStatus(Equipamento.findByNome(nome), status, controlador)

}
Then(~/^o sistema altera os dados de "([^"]*)" para "([^"]*)"$/) { String nome, status ->
    assert Equipamento.findByNome(nome).status == status
}