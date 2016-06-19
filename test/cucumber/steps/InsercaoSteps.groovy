package steps

import cucumber.api.PendingException
import gerenciadeequipamentos.ArmazemController
import gerenciadeequipamentos.Armazem
import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController
/**
 * Created by Walber on 19/06/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def EquipamentoController controladorEquipamento;
def ArmazemController controladorArmazem;
Given(~/^O sistema possui o armazem "([^"]*)" com lotacao incompleta$/) { String armazem ->
    TestDataAndOperations.createArmazem(armazem, 0,10, controladorArmazem)
    assert !Armazem.findByNome(armazem).cheio
}
And(~/^O sistema nao possui o equipamento "([^"]*)"$/) { String equipamento ->
    assert !Equipamento.findByNome(equipamento)
}
When(~/^Eu tento adicionar o equipamento "([^"]*)" com a localizacao "([^"]*)"$/) { String equipamento, String localizacao ->
    TestDataAndOperations.createEquipamento(equipamento,"status", localizacao, Date.parse("dd-MM-yyyy","06-07-2016"),controladorEquipamento)
}
Then(~/^O sistema Armazena o equipamento "([^"]*)"$/) { String equipamento ->
    assert Equipamento.findByNome(equipamento)
}
And(~/^Atualiza a lotacao do "([^"]*)"$/) { String armazem ->
    assert Armazem.findByNome(armazem).getLotacao() != 0
}
Given(~/^O sistema possui o armazem "([^"]*)" com lotacao completa$/) { String armazem ->

    assert Armazem.findByNome(armazem).getCheio()
}
Then(~/^O sistema nao armazena o equipamento "([^"]*)"$/) { String equipamento->
    assert !Equipamento.findByNome(equipamento)
}